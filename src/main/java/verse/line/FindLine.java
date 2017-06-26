package verse.line;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import verse.entity.Line;
@ManagedBean
@RequestScoped
public class FindLine extends Line {
	@EJB
	private LineService service;
	
	public FindLine() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Line> getAllLines(){
		return service.findLines();
	}
	
	public String editLine(Line line) {
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("line", line);
		return "updataLine";
	}
}
