package verse.line;

import javax.ejb.EJB;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

import verse.entity.Line;
@ManagedBean
@ViewScoped//viewscope生命周期
public class AddLine extends Line {
	@EJB
	private LineService service;
	
	public AddLine() {
		// TODO Auto-generated constructor stub
	}
	
	public String addLine() {
		Line l = new Line(getName(), getVerseLine());
//		if (getPic() == null) {
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "请上传图片", null));
//			return "addLine";
//		}
//		food.setPic(getPic());
		service.addLine(l);
		setName(null);
		setVerseLine(null);
		setPic(null);
		return "/adminPage";
	}
	public void handleFileUpload(FileUploadEvent event) {
		setPic(event.getFile().getContents());
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
}
