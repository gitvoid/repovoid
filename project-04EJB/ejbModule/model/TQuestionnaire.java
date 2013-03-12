package model;

import java.io.Serializable;

import javax.inject.Named;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the t_questionnaire database table.
 * 
 */
@Named
@Entity
@Table(name="t_questionnaire")
@NamedQueries({
	@NamedQuery(name = "TQuestionnaire.findAll", query = "SELECT t FROM TQuestionnaire t"),
	@NamedQuery(name = "TQuestionnaire.findByQuestionnaireId", query = "SELECT t FROM TQuestionnaire t WHERE t.questionnaireId = :questionnaireId"),
	@NamedQuery(name = "TQuestionnaire.findByQuestionnaireText", query = "SELECT t FROM TQuestionnaire t WHERE t.questionnaireText = :questionnaireText"),
	@NamedQuery(name = "TQuestionnaire.findByQuestionnaireSince", query = "SELECT t FROM TQuestionnaire t WHERE t.questionnaireSince = :questionnaireSince"),
	@NamedQuery(name = "TQuestionnaire.findByQuestionnaireDesc", query = "SELECT t FROM TQuestionnaire t WHERE t.questionnaireDesc = :questionnaireDesc") })
public class TQuestionnaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="questionnaire_id", unique=true, nullable=false)
	private Integer questionnaireId;

	@Column(name="questionnaire_desc", length=30)
	private String questionnaireDesc;

	@Temporal(TemporalType.DATE)
	@Column(name="questionnaire_since")
	private Date questionnaireSince;

	@Column(name="questionnaire_text", length=30)
	private String questionnaireText;

	//bi-directional many-to-one association to TQuestion
	@OneToMany(mappedBy="TQuestionnaire", fetch=FetchType.EAGER)
	private List<TQuestion> TQuestions;

	//bi-directional many-to-one association to TUser
	@ManyToOne
	@JoinColumn(name="user_fk_id")
	private TUser TUser;

	//bi-directional many-to-one association to TScore
	@OneToMany(mappedBy="TQuestionnaire", fetch=FetchType.EAGER)
	private List<TScore> TScores;

	public TQuestionnaire() {
	}

	public Integer getQuestionnaireId() {
		return this.questionnaireId;
	}

	public void setQuestionnaireId(Integer questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public String getQuestionnaireDesc() {
		return this.questionnaireDesc;
	}

	public void setQuestionnaireDesc(String questionnaireDesc) {
		this.questionnaireDesc = questionnaireDesc;
	}

	public Date getQuestionnaireSince() {
		return this.questionnaireSince;
	}

	public void setQuestionnaireSince(Date questionnaireSince) {
		this.questionnaireSince = questionnaireSince;
	}

	public String getQuestionnaireText() {
		return this.questionnaireText;
	}

	public void setQuestionnaireText(String questionnaireText) {
		this.questionnaireText = questionnaireText;
	}

	public List<TQuestion> getTQuestions() {
		return this.TQuestions;
	}

	public void setTQuestions(List<TQuestion> TQuestions) {
		this.TQuestions = TQuestions;
	}

	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
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
		hash += (questionnaireId != null ? questionnaireId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof TQuestionnaire)) {
			return false;
		}
		TQuestionnaire other = (TQuestionnaire) object;
		if ((this.questionnaireId == null && other.questionnaireId != null)
				|| (this.questionnaireId != null && !this.questionnaireId
						.equals(other.questionnaireId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "TQuestionnaire [questionnaireId=" + questionnaireId
				+ ", questionnaireDesc=" + questionnaireDesc
				+ ", questionnaireSince=" + questionnaireSince
				+ ", questionnaireText=" + questionnaireText + "]";
	}

	

	


}