package verse.reader;

import javax.ejb.EJB;



import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

import verse.entity.Reader;

@ManagedBean
@ViewScoped
public class AddReader extends Reader{
	@EJB
	private ReaderService service;
	
	public AddReader() {
		// TODO Auto-generated constructor stub
	}
	public void addReader() {
//		if (getPic() == null) {
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "请上传图片", null));
//			return "addReader";
//			return;
//		}
		Reader reader = new Reader(getName(), getPlace(), getGender(), getLine(),getTel(),getNum());
		reader.setPic(getPic());
		service.addReader(reader);
		setName(null);
		setPlace(null);
		setGender(null);
		setLine(null);
		setTel(null);
		setNum(null);
		setPic(null);
//		return "adminPage";
	}
	public void handleFileUpload(FileUploadEvent event) {
		setPic(event.getFile().getContents());
        FacesMessage message = new FacesMessage("Succesful", "图像上传后无法更改");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
