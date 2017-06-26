package verse.reader;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import verse.entity.Reader;

@ManagedBean
@ViewScoped
public class FindReader extends Reader {
	@EJB
	private ReaderService service;
	
	public FindReader() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Reader> getAllReaders(){
		return service.findReaders();
	}
	
	public String editReader(Reader reader) {
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("reader", reader);
		return "updataReader";//本目录下的相对目录
	}
}
