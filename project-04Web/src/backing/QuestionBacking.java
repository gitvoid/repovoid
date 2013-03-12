/**
 * 
 */
package backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import model.TQuestion;
import model.TQuestionnaire;
import session.QuestionBusinessLocal;
import session.QuestionnaireBusinessLocal;

@Named
@RequestScoped
/**
 * @author root
 *
 */
public class QuestionBacking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@Inject
	private QuestionBusinessLocal questionBusiness;

	@Inject
	private TQuestion tQuestion;

	@Inject
	private QuestionnaireBusinessLocal questionnaireBusiness;

	public QuestionBacking() {
		// TODO Auto-generated constructor stub
	}

	public TQuestion gettQuestion() {
		return tQuestion;
	}

	public void settQuestion(TQuestion tQuestion) {
		this.tQuestion = tQuestion;
	}

	public String addQuestion() {
		FacesContext fc1 = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc1.getExternalContext()
				.getSession(true);
		TQuestionnaire ques = (TQuestionnaire) session
				.getAttribute("questionnaire");
		System.out.println(ques);
		tQuestion.setTQuestionnaire(ques);
		questionBusiness.persist(tQuestion);
		return "listquestionnaires?faces-redirect=true";
	}

	public String listQuestion(Integer questionnaireId) {
		FacesContext fc1 = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc1.getExternalContext()
				.getSession(true);
		TQuestionnaire ques = questionnaireBusiness
				.getQuestionnaireById(questionnaireId);
		session.setAttribute("questionnaire", ques);
		System.out.println(ques.getQuestionnaireId());
		System.out.println(questionnaireId);
		return "listquestions?faces-redirect=true";
	}

	public List<TQuestion> listQuestionsByIdQuestionnaire() {
		FacesContext fc1 = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc1.getExternalContext()
				.getSession(true);
		TQuestionnaire ques = (TQuestionnaire) session
				.getAttribute("questionnaire");
		List<TQuestion> lq1 = questionBusiness.getAll();
		List<TQuestion> results = new ArrayList<TQuestion>();
		for (int i = 0; i < lq1.size(); i++) {
			if (lq1.get(i).getTQuestionnaire().equals(ques)) {
				results.add(lq1.get(i));
			}
		}
		System.out.println(results);
		return results;
	}
	
	public String addReponse(Integer questionId) {
		TQuestion question=questionBusiness.getQuestionById(questionId);	
		tQuestion=question;
		System.out.println(tQuestion);
		FacesContext fc1=FacesContext.getCurrentInstance();
		HttpSession session=(HttpSession) fc1.getExternalContext().getSession(true);
		session.setAttribute("question", question);
		return "addreponse?faces-redirect=true";

	}
	
	public String passQuestion(Integer questionnaireId) {
		FacesContext fc1 = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc1.getExternalContext()
				.getSession(true);
		TQuestionnaire ques = questionnaireBusiness
				.getQuestionnaireById(questionnaireId);
		session.setAttribute("questionnaire", ques);
		return "passquestionnaire?faces-redirect=true";
	}

}
