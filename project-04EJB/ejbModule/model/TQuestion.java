package model;

import java.io.Serializable;

import javax.inject.Named;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the t_question database table.
 * 
 */
@Named
@Entity
@Table(name = "t_question")
@NamedQueries({
		@NamedQuery(name = "TQuestion.findAll", query = "SELECT t FROM TQuestion t"),
		@NamedQuery(name = "TQuestion.findByQuestionId", query = "SELECT t FROM TQuestion t WHERE t.questionId = :questionId"),
		@NamedQuery(name = "TQuestion.findByQuestionText", query = "SELECT t FROM TQuestion t WHERE t.questionText = :questionText"),
		@NamedQuery(name = "TQuestion.findByQuestionSince", query = "SELECT t FROM TQuestion t WHERE t.questionSince = :questionSince"),
		@NamedQuery(name = "TQuestion.findByQuestionLevel", query = "SELECT t FROM TQuestion t WHERE t.questionLevel = :questionLevel"),
		@NamedQuery(name = "TQuestion.findByQuestionIndic", query = "SELECT t FROM TQuestion t WHERE t.questionIndic = :questionIndic") })
public class TQuestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "question_id", unique = true, nullable = false)
	private Integer questionId;

	@Column(name = "question_indic", length = 30)
	private String questionIndic;

	@Column(name = "question_level", length = 30)
	private String questionLevel;

	@Temporal(TemporalType.DATE)
	@Column(name = "question_since")
	private Date questionSince;

	@Column(name = "question_text", length = 30)
	private String questionText;

	// bi-directional many-to-one association to TQuestionnaire
	@ManyToOne
	@JoinColumn(name = "questionnaire_fk_id")
	private TQuestionnaire TQuestionnaire;

	// bi-directional many-to-one association to TReponse
	@OneToMany(mappedBy = "TQuestion", fetch = FetchType.EAGER)
	private List<TReponse> TReponses;

	public TQuestion() {
	}

	public Integer getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getQuestionIndic() {
		return this.questionIndic;
	}

	public void setQuestionIndic(String questionIndic) {
		this.questionIndic = questionIndic;
	}

	public String getQuestionLevel() {
		return this.questionLevel;
	}

	public void setQuestionLevel(String questionLevel) {
		this.questionLevel = questionLevel;
	}

	public Date getQuestionSince() {
		return this.questionSince;
	}

	public void setQuestionSince(Date questionSince) {
		this.questionSince = questionSince;
	}

	public String getQuestionText() {
		return this.questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public TQuestionnaire getTQuestionnaire() {
		return this.TQuestionnaire;
	}

	public void setTQuestionnaire(TQuestionnaire TQuestionnaire) {
		this.TQuestionnaire = TQuestionnaire;
	}

	public List<TReponse> getTReponses() {
		return this.TReponses;
	}

	public void setTReponses(List<TReponse> TReponses) {
		this.TReponses = TReponses;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (questionId != null ? questionId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof TQuestion)) {
			return false;
		}
		TQuestion other = (TQuestion) object;
		if ((this.questionId == null && other.questionId != null)
				|| (this.questionId != null && !this.questionId
						.equals(other.questionId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "TQuestion [questionId=" + questionId + ", questionIndic="
				+ questionIndic + ", questionLevel=" + questionLevel
				+ ", questionSince=" + questionSince + ", questionText="
				+ questionText + "]";
	}

}