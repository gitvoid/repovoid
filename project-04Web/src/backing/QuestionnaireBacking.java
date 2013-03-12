/**
 * 
 */
package backing;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import model.TQuestionnaire;
import model.TUser;
import session.QuestionnaireBusinessLocal;
import session.UserBusinessLocal;

@ManagedBean
@Named
@RequestScoped
/**
 * @author root
 *
 */
public class QuestionnaireBacking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	@Inject
	private QuestionnaireBusinessLocal questionnaireBusiness;

	@Inject
	private TQuestionnaire tQuestionnaire;

	@Inject
	private UserBusinessLocal userBusiness;

	@Inject
	private TUser tUser;

	public QuestionnaireBacking() {

	}

	public TQuestionnaire gettQuestionnaire() {
		return tQuestionnaire;
	}

	public void settQuestionnaire(TQuestionnaire tQuestionnaire) {
		this.tQuestionnaire = tQuestionnaire;
	}

	public String addQuestionnaire() {
		FacesContext fc1 = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc1.getExternalContext()
				.getSession(true);
		TUser user = (TUser) session.getAttribute("user");
		System.out.println(user);
		System.out.println(tUser);
		tQuestionnaire.setTUser(user);
		questionnaireBusiness.persist(this.tQuestionnaire);
		return "listquestionnaires?faces-redirect=true";
	}

	public String listQuestionnaire() {
		System.out.println(tUser);
		return "listquestionnaires?faces-redirect=true";
	}

	public String addNewQuestionnaire() {
		FacesContext fc1 = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc1.getExternalContext()
				.getSession(true);
		TUser user = (TUser) session.getAttribute("user");
		System.out.println(user);
		return "addquestionnaire?faces-redirect=true";
	}

	public List<TQuestionnaire> listAllQuestionnaire() {
		return questionnaireBusiness.getAll();
	}

	public String addQuestion(Integer questionnaireId) {
		TQuestionnaire ques=questionnaireBusiness.getQuestionnaireById(questionnaireId);
		System.out.println(ques);
		tQuestionnaire=ques;
		System.out.println(tQuestionnaire);
		FacesContext fc1=FacesContext.getCurrentInstance();
		HttpSession session=(HttpSession) fc1.getExternalContext().getSession(true);
		session.setAttribute("questionnaire", ques);
		return "addquestion?faces-redirect=true";

	}
}
