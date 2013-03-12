package session;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.TQuestionnaire;

/**
 * Session Bean implementation class QuestionnaireBusiness
 */
@Named
@Stateless
public class QuestionnaireBusiness implements QuestionnaireBusinessLocal {

	/**
	 * Default constructor.
	 */

	@PersistenceContext
	private EntityManager em;

	public QuestionnaireBusiness() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void persist(TQuestionnaire tQuestionnaire) {
		em.persist(tQuestionnaire);

	}

	@Override
	public void update(TQuestionnaire tQuestionnaire) {
		em.merge(tQuestionnaire);

	}

	@Override
	public void delete(TQuestionnaire tQuestionnaire) {
		TQuestionnaire questionnaire = new TQuestionnaire();
		questionnaire = em.merge(tQuestionnaire);
		em.remove(questionnaire);

	}

	@Override
	public TQuestionnaire getQuestionnaireById(Integer QuestionnaireId) {
		Query query = em
				.createNamedQuery("TQuestionnaire.findByQuestionnaireId");
		query.setParameter("questionnaireId", QuestionnaireId);
		return (TQuestionnaire) query.getSingleResult();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TQuestionnaire> getAll() {
		Query query = em.createNamedQuery("TQuestionnaire.findAll");
		System.out.println(query.getResultList());
		return query.getResultList();
	}

}
