/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.TUser;

/**
 *
 * @author void
 */
@Named
@Stateless
public class UserBusiness implements UserBusinessLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void persist(TUser tUser) {
        em.persist(tUser);
    }

    @Override
    public void update(TUser tUser) {
        em.merge(tUser);
    }

    @Override
    public void delete(TUser tUser) {
        TUser tUser1 = new TUser();
        tUser1 = em.merge(tUser);
        em.remove(tUser1);
    }

    @Override
    public TUser getUserById(Integer userId) {
        Query query = em.createNamedQuery("TUser.findByUserId");
        query.setParameter("userId", userId);
        return (TUser) query.getSingleResult();
    }

    @Override
    public TUser findUser(String userLogin) {
        Query query = em.createNamedQuery("TUser.findByUserLogin");
        query.setParameter("userLogin", userLogin);
        return (TUser) query.getSingleResult();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void persist1(Object object) {
        em.persist(object);
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<TUser> getAll() {
       Query query = em.createNamedQuery("TUser.findAll");
       System.out.print(query.getResultList());
       return query.getResultList();
    }
}
