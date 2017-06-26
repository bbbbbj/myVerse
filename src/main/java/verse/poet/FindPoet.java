package verse.poet;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import verse.entity.Poet;

@ManagedBean
@RequestScoped
public class FindPoet extends Poet {
	@EJB
	private PoetService service;
	
	public FindPoet() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Poet> getAllPoets(){
		return service.findPoets();
	}
	
	public String editPoet(Poet poet) {
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("poet", poet);
		return "updataPoet";
	}
}
