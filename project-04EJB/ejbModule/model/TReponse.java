package model;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the t_reponse database table.
 * 
 */
@Named
@Entity
@Table(name = "t_reponse")
@NamedQueries({
		@NamedQuery(name = "TReponse.findAll", query = "SELECT t FROM TReponse t"),
		@NamedQuery(name = "TReponse.findByReponseId", query = "SELECT t FROM TReponse t WHERE t.reponseId = :reponseId"),
		@NamedQuery(name = "TReponse.findByReponseText", query = "SELECT t FROM TReponse t WHERE t.reponseText = :reponseText"),
		@NamedQuery(name = "TReponse.findByReponseSince", query = "SELECT t FROM TReponse t WHERE t.reponseSince = :reponseSince"),
		@NamedQuery(name = "TReponse.findByReponsePoints", query = "SELECT t FROM TReponse t WHERE t.reponsePoints = :reponsePoints"),
		@NamedQuery(name = "TReponse.findByReponseIscorrect", query = "SELECT t FROM TReponse t WHERE t.reponseIscorrect = :reponseIscorrect") })
public class TReponse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reponse_id", unique = true, nullable = false)
	private Integer reponseId;

	@Column(name = "reponse_iscorrect")
	private Integer reponseIscorrect;

	@Column(name = "reponse_points", length = 30)
	private String reponsePoints;

	@Temporal(TemporalType.DATE)
	@Column(name = "reponse_since")
	private Date reponseSince;

	@Column(name = "reponse_text", length = 30)
	private String reponseText;

	// bi-directional many-to-one association to TQuestion
	@ManyToOne
	@JoinColumn(name = "question_fk_id")
	private TQuestion TQuestion;

	public TReponse() {
	}

	public Integer getReponseId() {
		return this.reponseId;
	}

	public void setReponseId(Integer reponseId) {
		this.reponseId = reponseId;
	}

	public Integer getReponseIscorrect() {
		return this.reponseIscorrect;
	}

	public void setReponseIscorrect(Integer reponseIscorrect) {
		this.reponseIscorrect = reponseIscorrect;
	}

	public String getReponsePoints() {
		return this.reponsePoints;
	}

	public void setReponsePoints(String reponsePoints) {
		this.reponsePoints = reponsePoints;
	}

	public Date getReponseSince() {
		return this.reponseSince;
	}

	public void setReponseSince(Date reponseSince) {
		this.reponseSince = reponseSince;
	}

	public String getReponseText() {
		return this.reponseText;
	}

	public void setReponseText(String reponseText) {
		this.reponseText = reponseText;
	}

	public TQuestion getTQuestion() {
		return this.TQuestion;
	}

	public void setTQuestion(TQuestion TQuestion) {
		this.TQuestion = TQuestion;
	}
	

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reponseId != null ? reponseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TReponse)) {
            return false;
        } 
        return true;
    }

	@Override
	public String toString() {
		return reponseId.toString();
	}
    
    

}