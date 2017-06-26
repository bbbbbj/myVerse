package verse.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
@Entity
@NamedQuery(name = "findAllPoets", query = "select p from Poet p")
public class Poet implements Serializable{
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String dynasty;
	private String title;
	private String hobby;
	@Lob
	private byte[] pic;
	
	public Poet() {
		// TODO Auto-generated constructor stub
	}

	public Poet(String name, String dynasty, String title, String hobby) {
		super();
		this.name = name;
		this.dynasty = dynasty;
		this.title = title;
		this.hobby = hobby;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDynasty() {
		return dynasty;
	}

	public String getTitle() {
		return title;
	}

	public String getHobby() {
		return hobby;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDynasty(String dynasty) {
		this.dynasty = dynasty;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}	

	
}
