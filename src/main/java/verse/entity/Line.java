package verse.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
@Entity
@NamedQuery(name = "findAllLines", query = "select l from Line l")
public class Line implements Serializable{
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String verseLine;
	@Lob
	private byte[] pic;
	
	public Line() {
		// TODO Auto-generated constructor stub
	}

	public Line(String name, String verseLine) {
		super();
		this.name = name;
		this.verseLine = verseLine;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public String getVerseLine() {
		return verseLine;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setVerseLine(String verseLine) {
		this.verseLine = verseLine;
	}
	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}	
	
}
