/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.util.List;
import javax.ejb.Local;
import model.TUser;

/**
 *
 * @author void
 */
@Local
public interface UserBusinessLocal {
    public void persist(TUser tUser);
    public void update(TUser tUser);
    public void delete(TUser tUser);
    public TUser getUserById(Integer userId);
    public TUser findUser(String userLogin);
    public List<TUser> getAll();
}
