package session;

import java.util.List;

import javax.ejb.Local;

import model.TQuestionnaire;

@Local
public interface QuestionnaireBusinessLocal {
    public void persist(TQuestionnaire tQuestionnaire);
    public void update(TQuestionnaire tQuestionnaire);
    public void delete(TQuestionnaire tQuestionnaire);
    public TQuestionnaire getQuestionnaireById(Integer QuestionnaireId);
    public List<TQuestionnaire> getAll();

}
