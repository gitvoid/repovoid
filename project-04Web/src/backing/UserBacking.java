/**
 * 
 */
package backing;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import model.TUser;
import session.UserBusinessLocal;

@ManagedBean
@Named
@SessionScoped
/**
 * @author root
 *
 */
public class UserBacking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	@Inject
	private UserBusinessLocal userBusiness;

	@Inject
	private TUser tUser;

	public UserBacking() {
		// TODO Auto-generated constructor stub
	}

	public TUser gettUser() {
		return tUser;
	}

	public void settUser(TUser tUser) {
		this.tUser = tUser;
	}

	public String addUser() {
		userBusiness.persist(this.tUser);
		return "connectuser?faces-redirect=true";
	}

	public List<TUser> listAllUsers() {
		return userBusiness.getAll();
	}

	public String connectUser() {
		System.out.println(tUser);
		TUser user = userBusiness.findUser(this.tUser.getUserLogin());
		System.out.println(user);
		if (tUser.getUserPassword().equals(user.getUserPassword())) {
			System.out.println("true");
			tUser=user;
			FacesContext fc1=FacesContext.getCurrentInstance();
			HttpSession session=(HttpSession) fc1.getExternalContext().getSession(true);
			session.setAttribute("user", user);
			System.out.println(tUser);
			return "welcomeuser?faces-redirect=true";

		} else {
			System.out.println("false");
			return "erroruser?faces-redirect=true";
		}

	}

	public String disconnectUser() {
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
		return "connectuser?faces-redirect=true";
	}
}
