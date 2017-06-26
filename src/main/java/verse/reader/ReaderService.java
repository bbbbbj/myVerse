package verse.reader;

import java.util.List;


import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import verse.entity.Reader;

@Stateless
public class ReaderService {
	@PersistenceContext(unitName = "javaeelocal")
	private EntityManager em;
	
	public ReaderService() {
		// TODO Auto-generated constructor stub
	}
	
	public void addReader(Reader reader) {
		em.persist(reader);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "添加成功", null));
	}
	
	public void delReader(Reader reader) {
		reader = em.merge(reader);
		em.remove(reader);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "删除成功", null));
	}
	
	public List<Reader> findReaders() {
		TypedQuery<Reader> query = em.createQuery("select r from Reader r", Reader.class);
		return query.getResultList();
	}
	
	public void updataReader(Reader reader) {
		em.merge(reader);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "更新成功", null));
		
	}
	public Reader findReaderById(String id) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "id查询成功", null));
		return em.find(Reader.class, Integer.parseInt(id));
		
	}
}
