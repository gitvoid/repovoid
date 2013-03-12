/**
 * 
 */
package backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import model.TQuestion;
import model.TQuestionnaire;
import model.TReponse;
import model.TScore;
import model.TUser;
import session.QuestionBusinessLocal;
import session.ReponseBusinessLocal;
import session.ScoreBusinessLocal;

@Named
@SessionScoped
/**
 * @author root
 *
 */
public class ReponseBacking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@Inject
	private ReponseBusinessLocal reponseBusiness;

	@Inject
	private TReponse tReponse;

	@Inject
	private QuestionBusinessLocal questionBusiness;

	private List<TReponse> lr1 = new ArrayList<TReponse>();

	private int somme;

	private int nombreReponse;

	@Inject
	private TScore tScore;

	@Inject
	private TUser tUser;

	@Inject
	private TQuestionnaire tQuestionnaire;

	@Inject
	private ScoreBusinessLocal scoreBusiness;

	public ReponseBacking() {
		// TODO Auto-generated constructor stub
	}

	public TReponse gettReponse() {
		return tReponse;
	}

	public void settReponse(TReponse tReponse) {
		lr1.add(tReponse);
		this.tReponse = tReponse;
	}

	public String addReponse() {
		FacesContext fc1 = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc1.getExternalContext()
				.getSession(true);
		TQuestion question = (TQuestion) session.getAttribute("question");
		tReponse.setTQuestion(question);
		reponseBusiness.persist(tReponse);
		return "listquestions?faces-redirect=true";
	}

	public String listReponse(Integer questionId) {
		FacesContext fc1 = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc1.getExternalContext()
				.getSession(true);
		TQuestion question = questionBusiness.getQuestionById(questionId);
		session.setAttribute("question", question);
		return "listreponse?faces-redirect=true";
	}

	public List<TReponse> listReponseByIdQuestion() {
		FacesContext fc1 = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc1.getExternalContext()
				.getSession(true);
		TQuestion question = (TQuestion) session.getAttribute("question");
		List<TReponse> lr1 = reponseBusiness.getAll();
		List<TReponse> results = new ArrayList<TReponse>();
		for (int i = 0; i < lr1.size(); i++) {
			if (lr1.get(i).getTQuestion().equals(question)) {
				results.add(lr1.get(i));
			}
		}
		return results;
	}

	Converter reponseConverter = new Converter() {

		@Override
		public String getAsString(FacesContext context, UIComponent component,
				Object value) {
			return value.toString();

		}

		@Override
		public Object getAsObject(FacesContext context, UIComponent component,
				String value) {
			TReponse reponse = reponseBusiness.getReponseById(Integer
					.parseInt(value));
			System.out.println(reponse.getReponseId());
			return reponse;
		}
	};

	public Converter getReponseConverter() {
		return reponseConverter;
	}

	public void setReponseConverter(Converter reponseConverter) {
		this.reponseConverter = reponseConverter;
	}

	public String validerReponse() {
		this.somme = 0;
		this.nombreReponse = lr1.size();
		for (TReponse r : lr1) {
			somme += r.getReponseIscorrect().intValue();
		}
		FacesContext fc1 = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc1.getExternalContext()
				.getSession(true);
		TQuestionnaire q1 = (TQuestionnaire) session
				.getAttribute("questionnaire");
		TUser u1 = (TUser) session.getAttribute("user");
		tScore.setScorePoints(String.valueOf(somme));
		tScore.setTQuestionnaire(q1);
		tScore.setTUser(u1);
		scoreBusiness.persist(tScore);
		this.lr1.clear();
		return "resultatquestionnaire?faces-redirect=true";
	}

	public List<TReponse> getLr1() {
		return lr1;
	}

	public void setLr1(List<TReponse> lr1) {
		this.lr1 = lr1;
	}

	public int getSomme() {
		return somme;
	}

	public void setSomme(int somme) {
		this.somme = somme;
	}

	public int getNombreReponse() {
		return nombreReponse;
	}

	public void setNombreReponse(int nombreReponse) {
		this.nombreReponse = nombreReponse;
	}

}
