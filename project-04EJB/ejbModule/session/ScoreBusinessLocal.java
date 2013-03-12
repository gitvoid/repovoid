package session;

import java.util.List;

import javax.ejb.Local;

import model.TScore;

@Local
public interface ScoreBusinessLocal {
	public void persist(TScore tScore);

	public void update(TScore tScore);

	public void delete(TScore tScore);

	public TScore getScoreById(Integer scoreId);

	public List<TScore> getAll();

}
