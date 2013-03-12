package model;

import java.io.Serializable;

import javax.inject.Named;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the t_user database table.
 * 
 */
@Named
@Entity
@Table(name = "t_user")
@NamedQueries({
		@NamedQuery(name = "TUser.findAll", query = "SELECT t FROM TUser t"),
		@NamedQuery(name = "TUser.findByUserId", query = "SELECT t FROM TUser t WHERE t.userId = :userId"),
		@NamedQuery(name = "TUser.findByUserFirstname", query = "SELECT t FROM TUser t WHERE t.userFirstname = :userFirstname"),
		@NamedQuery(name = "TUser.findByUserLastname", query = "SELECT t FROM TUser t WHERE t.userLastname = :userLastname"),
		@NamedQuery(name = "TUser.findByUserEmail", query = "SELECT t FROM TUser t WHERE t.userEmail = :userEmail"),
		@NamedQuery(name = "TUser.findByUserLogin", query = "SELECT t FROM TUser t WHERE t.userLogin = :userLogin"),
		@NamedQuery(name = "TUser.findByUserPassword", query = "SELECT t FROM TUser t WHERE t.userPassword = :userPassword"),
		@NamedQuery(name = "TUser.findByUserSince", query = "SELECT t FROM TUser t WHERE t.userSince = :userSince"),
		@NamedQuery(name = "TUser.findByUserIsmaster", query = "SELECT t FROM TUser t WHERE t.userIsmaster = :userIsmaster") })
public class TUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	private Integer userId;

	@Column(name = "user_email", length = 40)
	private String userEmail;

	@Column(name = "user_firstname", length = 30)
	private String userFirstname;

	@Column(name = "user_ismaster")
	private Integer userIsmaster;

	@Column(name = "user_lastname", length = 30)
	private String userLastname;

	@Column(name = "user_login", length = 40)
	private String userLogin;

	@Column(name = "user_password", length = 30)
	private String userPassword;

	@Temporal(TemporalType.DATE)
	@Column(name = "user_since")
	private Date userSince;

	// bi-directional many-to-one association to TQuestionnaire
	@OneToMany(mappedBy = "TUser", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private List<TQuestionnaire> TQuestionnaires;

	// bi-directional many-to-one association to TScore
	@OneToMany(mappedBy = "TUser", fetch = FetchType.EAGER)
	private List<TScore> TScores;

	public TUser() {
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserFirstname() {
		return this.userFirstname;
	}

	public void setUserFirstname(String userFirstname) {
		this.userFirstname = userFirstname;
	}

	public Integer getUserIsmaster() {
		return this.userIsmaster;
	}

	public void setUserIsmaster(Integer userIsmaster) {
		this.userIsmaster = userIsmaster;
	}

	public String getUserLastname() {
		return this.userLastname;
	}

	public void setUserLastname(String userLastname) {
		this.userLastname = userLastname;
	}

	public String getUserLogin() {
		return this.userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Date getUserSince() {
		return this.userSince;
	}

	public void setUserSince(Date userSince) {
		this.userSince = userSince;
	}

	public List<TQuestionnaire> getTQuestionnaires() {
		return this.TQuestionnaires;
	}

	public void setTQuestionnaires(List<TQuestionnaire> TQuestionnaires) {
		this.TQuestionnaires = TQuestionnaires;
	}

	public List<TScore> getTScores() {
		return this.TScores;
	}

	public void setTScores(List<TScore> TScores) {
		this.TScores = TScores;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (userId != null ? userId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof TUser)) {
			return false;
		}
		TUser other = (TUser) object;
		if ((this.userId == null && other.userId != null)
				|| (this.userId != null && !this.userId.equals(other.userId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "TUser [userId=" + userId + ", userEmail=" + userEmail
				+ ", userFirstname=" + userFirstname + ", userIsmaster="
				+ userIsmaster + ", userLastname=" + userLastname
				+ ", userLogin=" + userLogin + ", userPassword=" + userPassword
				+ ", userSince=" + userSince + "]";
	}

	
}