package verse.reader;

import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import verse.entity.Reader;
@ManagedBean
@RequestScoped
public class DelReader extends Reader {
	@EJB
	private ReaderService service;
	
	public DelReader() {
		// TODO Auto-generated constructor stub
	}
	public String delReader(Reader reader) {
		service.delReader(reader);
		return "adminPage";
	}
}
