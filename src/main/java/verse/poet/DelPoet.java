package verse.poet;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import verse.entity.Poet;

@ManagedBean
@RequestScoped
public class DelPoet extends Poet {
	@EJB
	private PoetService service;
	
	public DelPoet() {
		// TODO Auto-generated constructor stub
	}
	
	public String delPoet(Poet poet) {
		service.delPoet(poet);
		return "adminPage";
	}
}
