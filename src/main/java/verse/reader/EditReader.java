package verse.reader;

import javax.ejb.EJB;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

import verse.entity.Reader;
@ManagedBean
@ViewScoped//使用这个视图有效不会出现空指针异常
public class EditReader extends Reader {
	@EJB
	private ReaderService service;
	private Reader reader;
	
	public EditReader() {
		reader = (Reader)FacesContext.getCurrentInstance().getExternalContext().getFlash().get("reader");
		setId(reader.getId());
		setName(reader.getName());
		setPlace(reader.getPlace());
		setGender(reader.getGender());
		setLine(reader.getLine());
		setTel(reader.getTel());
		setNum(reader.getNum());
		setPic(reader.getPic());
	}
	
	public String updataReader() {
		reader.setName(getName());
		reader.setPlace(getPlace());
		reader.setGender(getGender());
		reader.setLine(getLine());
		reader.setTel(getTel());
		reader.setNum(getNum());
		reader.setPic(getPic());
		service.updataReader(reader);
		return "/adminPage";//webapp为根目录
	}
	public void handleFileUpload(FileUploadEvent event) {
		setPic(event.getFile().getContents());
        FacesMessage message = new FacesMessage("Succesful", "图像上传成功");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
