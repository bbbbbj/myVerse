package verse.poet;

import java.util.List;


import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import verse.entity.Poet;

@Stateless
public class PoetService {
	@PersistenceContext(unitName = "javaeelocal")
	private EntityManager em;
	
	public PoetService() {
		// TODO Auto-generated constructor stub
	}
	public void addPoet(Poet poet) {
		em.persist(poet);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "添加成功", null));
	}
	
	public void delPoet(Poet poet) {
		poet = em.merge(poet);//改变引用
		em.remove(poet);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "删除成功", null));
	}
	
	public List<Poet> findPoets(){
		TypedQuery<Poet> query = em.createNamedQuery("findAllPoets", Poet.class);
		return query.getResultList();
	}
	
	public void updataPoet(Poet poet) {
		em.merge(poet);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "更新成功", null));
	}
	public Poet findPoetById(String id) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "id查询成功", null));
		return em.find(Poet.class, Integer.parseInt(id));
	}
	
}
