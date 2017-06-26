package verse.line;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import verse.entity.Line;

@Stateless
public class LineService {
	@PersistenceContext(unitName = "javaeelocal")
	private EntityManager em;
	
	public LineService() {
		// TODO Auto-generated constructor stub
	}
	public void addLine(Line line) {
		em.persist(line);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "添加成功", null));
	}
	
	public void delLine(Line line) {
		line = em.merge(line);//改变引用
		em.remove(line);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "删除成功", null));
	}
	
	public List<Line> findLines(){
		TypedQuery<Line> query = em.createNamedQuery("findAllLines", Line.class);
		return query.getResultList();
	}
	
	public void updataLine(Line line) {
		em.merge(line);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "更新成功", null));
	}
	public Line findLineById(String id) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "id查询成功", null));
		return em.find(Line.class, Integer.parseInt(id));		
	}
	
}
