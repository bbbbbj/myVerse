package verse.line;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import verse.entity.Line;
@ManagedBean
@RequestScoped
public class DelLine extends Line {
	@EJB
	private LineService service;
	
	public DelLine() {
		// TODO Auto-generated constructor stub
	}
	
	public String delLine(Line line) {
		service.delLine(line);
		return "adminPage";
	}
}
