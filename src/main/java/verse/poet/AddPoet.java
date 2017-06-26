package verse.poet;

import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

import verse.entity.Poet;

@ManagedBean
@ViewScoped
public class AddPoet extends Poet {
	@EJB
	private PoetService service;
	
	public AddPoet() {
		// TODO Auto-generated constructor stub
	}
	
	public String addPoet() {
		Poet p = new Poet(getName(), getDynasty(), getTitle(), getHobby());
//		if (getPic() == null) {
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "请上传图片", null));
//			return "addPoet";
//		}
//		p.setPic(getPic());
		service.addPoet(p);
		setName(null);
		setDynasty(null);
		setTitle(null);
		setHobby(null);
		setPic(null);
		return "/adminPage";
	}
	public void handleFileUpload(FileUploadEvent event) {
		setPic(event.getFile().getContents());
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
}
