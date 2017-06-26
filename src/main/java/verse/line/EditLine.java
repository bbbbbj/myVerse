package verse.line;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import verse.entity.Line;
@ManagedBean
@ViewScoped
public class EditLine extends Line {
	@EJB
	private LineService service;
	private Line line;
	
	public EditLine() {
		line = (Line)FacesContext.getCurrentInstance().getExternalContext().getFlash().get("line");
		setId(line.getId());
		setName(line.getName());
		setVerseLine(line.getVerseLine());
		//setPic(line.getPic());
	}
	
	public String updataLine() {
		line.setName(getName());
		line.setVerseLine(getVerseLine());
		service.updataLine(line);
		return "/adminPage";		
	}
}
