package session;

import java.util.List;

import javax.ejb.Local;

import model.TReponse;

@Local
public interface ReponseBusinessLocal {
	
	public void persist(TReponse tReponse);

	public void update(TReponse tReponse);

	public void delete(TReponse tReponse);

	public TReponse getReponseById(Integer ReponseId);

	public List<TReponse> getAll();

}
