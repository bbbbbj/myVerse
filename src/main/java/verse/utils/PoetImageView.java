package verse.utils;

import java.io.ByteArrayInputStream;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import verse.entity.Poet;
import verse.poet.PoetService;

@ManagedBean
public class PoetImageView {
	private StreamedContent img;
	@EJB
	private PoetService poetService;

	@PostConstruct
	public void init() {
		try {
			File imageFile = new File("dynamichart");
			img = new DefaultStreamedContent(new FileInputStream(imageFile), "image/jpg");
			Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String id = null;
			if (map.get("poet") != null) {
				id = map.get("poet");
				Poet poet = poetService.findPoetById(id);
				InputStream in = new ByteArrayInputStream(poet.getPic());
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
