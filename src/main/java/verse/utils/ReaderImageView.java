package verse.utils;

import java.io.ByteArrayInputStream;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import verse.entity.Reader;
import verse.reader.ReaderService;

@ManagedBean
@SessionScoped
public class ReaderImageView {

	private StreamedContent img;

	@EJB
	private ReaderService readerService;

	@PostConstruct
	public void init() {
		try {
//			File imageFile = new File("dynamichart");
//			img = new DefaultStreamedContent(new FileInputStream(imageFile), "image/jpg");
			Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = null;
			if (map.get("reader") != null) {
				id = map.get("reader");
				Reader reader = readerService.findReaderById(id);
				InputStream in = new ByteArrayInputStream(reader.getPic());
				img = new DefaultStreamedContent(in);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public StreamedContent getImg() {
		return img;
	}
}