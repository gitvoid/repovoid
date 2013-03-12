package model;

import java.io.Serializable;

import javax.inject.Named;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the t_score database table.
 * 
 */
@Named
@Entity
@Table(name = "t_score")
@NamedQueries({
		@NamedQuery(name = "TScore.findAll", query = "SELECT t FROM TScore t"),
		@NamedQuery(name = "TScore.findByScoreId", query = "SELECT t FROM TScore t WHERE t.scoreId = :scoreId"),
		@NamedQuery(name = "TScore.findByScoreMark", query = "SELECT t FROM TScore t WHERE t.scoreMark = :scoreMark"),
		@NamedQuery(name = "TScore.findByScoreSince", query = "SELECT t FROM TScore t WHERE t.scoreSince = :scoreSince"),
		@NamedQuery(name = "TScore.findByScorePoints", query = "SELECT t FROM TScore t WHERE t.scorePoints = :scorePoints") })
public class TScore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "score_id", unique = true, nullable = false)
	private Integer scoreId;

	@Column(name = "score_mark", length = 30)
	private String scoreMark;

	@Column(name = "score_points", length = 30)
	private String scorePoints;

	@Temporal(TemporalType.DATE)
	@Column(name = "score_since")
	private Date scoreSince;

	// bi-directional many-to-one association to TQuestionnaire
	@ManyToOne
	@JoinColumn(name = "questionnaire_fk_id")
	private TQuestionnaire TQuestionnaire;

	// bi-directional many-to-one association to TUser
	@ManyToOne
	@JoinColumn(name = "user_fk_id")
	private TUser TUser;

	public TScore() {
	}

	public Integer getScoreId() {
		return this.scoreId;
	}

	public void setScoreId(Integer scoreId) {
		this.scoreId = scoreId;
	}

	public String getScoreMark() {
		return this.scoreMark;
	}

	public void setScoreMark(String scoreMark) {
		this.scoreMark = scoreMark;
	}

	public String getScorePoints() {
		return this.scorePoints;
	}

	public void setScorePoints(String scorePoints) {
		this.scorePoints = scorePoints;
	}

	public Date getScoreSince() {
		return this.scoreSince;
	}

	public void setScoreSince(Date scoreSince) {
		this.scoreSince = scoreSince;
	}

	public TQuestionnaire getTQuestionnaire() {
		return this.TQuestionnaire;
	}

	public void setTQuestionnaire(TQuestionnaire TQuestionnaire) {
		this.TQuestionnaire = TQuestionnaire;
	}

	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (scoreId != null ? scoreId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof TScore)) {
			return false;
		}
		TScore other = (TScore) object;
		if ((this.scoreId == null && other.scoreId != null)
				|| (this.scoreId != null && !this.scoreId.equals(other.scoreId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "TScore [scoreId=" + scoreId + ", scoreMark=" + scoreMark
				+ ", scorePoints=" + scorePoints + ", scoreSince=" + scoreSince
				+ "]";
	}

}