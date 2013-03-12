package session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.TScore;

/**
 * Session Bean implementation class ScoreBusiness
 */
@Stateless
public class ScoreBusiness implements ScoreBusinessLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	private EntityManager em;

	public ScoreBusiness() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void persist(TScore tScore) {
		em.persist(tScore);

	}

	@Override
	public void update(TScore tScore) {
		em.merge(tScore);

	}

	@Override
	public void delete(TScore tScore) {
		TScore score = new TScore();
		score = em.merge(tScore);
		em.remove(score);

	}

	@Override
	public TScore getScoreById(Integer scoreId) {
		Query query = em.createNamedQuery("TScore.findByScoreId");
		query.setParameter("scoreId", scoreId);
		return (TScore) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TScore> getAll() {
		Query query = em.createNamedQuery("TScore.findAll");
		return query.getResultList();
	}

}
