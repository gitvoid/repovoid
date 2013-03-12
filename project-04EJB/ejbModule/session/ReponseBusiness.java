package session;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.TReponse;

/**
 * Session Bean implementation class ReponseBusiness
 */
@Named
@Stateless
public class ReponseBusiness implements ReponseBusinessLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	private EntityManager em;

	public ReponseBusiness() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void persist(TReponse tReponse) {
		em.persist(tReponse);

	}

	@Override
	public void update(TReponse tReponse) {
		em.merge(tReponse);

	}

	@Override
	public void delete(TReponse tReponse) {
		TReponse reponse = new TReponse();
		reponse = em.merge(tReponse);
		em.remove(reponse);
	}

	@Override
	public TReponse getReponseById(Integer ReponseId) {
		Query query = em.createNamedQuery("TReponse.findByReponseId");
		query.setParameter("reponseId", ReponseId);
		return (TReponse) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TReponse> getAll() {
		Query query = em.createNamedQuery("TReponse.findAll");
		System.out.println(query.getResultList());
		return query.getResultList();
	}

}
