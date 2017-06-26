package verse.poet;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import verse.entity.Poet;


@ManagedBean
@ViewScoped//使用这个视图有效不会出现空指针异常
public class EditPoet extends Poet {
	@EJB
	private PoetService service;
	private Poet poet;
	
	public EditPoet() {
		super();
		poet = (Poet)FacesContext.getCurrentInstance().getExternalContext().getFlash().get("poet");
		setName(poet.getName());
		setDynasty(poet.getDynasty());
		setTitle(poet.getTitle());
		setHobby(poet.getHobby());
		setPic(poet.getPic());
	}
	
	public String updataPoet() {
		poet.setName(getName());
		poet.setDynasty(getDynasty());
		poet.setTitle(getTitle());
		poet.setHobby(getHobby());
		service.updataPoet(poet);
		return "/adminPage";//webapp为根目录
	}
}
