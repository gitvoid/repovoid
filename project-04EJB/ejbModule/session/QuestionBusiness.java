package session;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.TQuestion;

/**
 * Session Bean implementation class QuestionBusiness
 */
@Named
@Stateless
public class QuestionBusiness implements QuestionBusinessLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	private EntityManager em;

	public QuestionBusiness() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void persist(TQuestion tQuestion) {
		em.persist(tQuestion);

	}

	@Override
	public void update(TQuestion tQuestion) {
		em.merge(tQuestion);

	}

	@Override
	public void delete(TQuestion tQuestion) {
		TQuestion question = new TQuestion();
		question = em.merge(tQuestion);
		em.remove(question);

	}

	@Override
	public TQuestion getQuestionById(Integer QuestionId) {
		Query query = em.createNamedQuery("TQuestion.findByQuestionId");
		query.setParameter("questionId", QuestionId);
		return (TQuestion) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TQuestion> getAll() {
		Query query = em.createNamedQuery("TQuestion.findAll");
		System.out.println(query.getResultList());
		return query.getResultList();
	}


}
