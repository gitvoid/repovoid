package session;

import java.util.List;

import javax.ejb.Local;

import model.TQuestion;

@Local
public interface QuestionBusinessLocal {

	public void persist(TQuestion tQuestion);

	public void update(TQuestion tQuestion);

	public void delete(TQuestion tQuestion);

	public TQuestion getQuestionById(Integer QuestionId);

	public List<TQuestion> getAll();
	
}
