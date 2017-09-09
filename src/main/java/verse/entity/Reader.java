package verse.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
@Entity
public class Reader implements Serializable{
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String place;
	private String gender;
	private String tel;
	private String line;
	private String num;
	@Lob
	private byte[] pic;
	
	public Reader() {
		// TODO Auto-generated constructor stub
	}

	public Reader(String name, String place, String gender, String line,String tel,String num) {
		super();
		this.name = name;
		this.place = place;
		this.gender = gender;
		this.line = line;
		this.tel=tel;
		this.num=num;
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

	public String getPlace() {
		return place;
	}

	public String getGender() {
		return gender;
	}

	public String getLine() {
		return line;
	}
	public String getTel(){
		return tel;
	}
	public String getNum(){
		return num;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setLine(String line) {
		this.line = line;
	}
	public void setTel(String tel){
		this.tel=tel;
	}
	public void setNum(String num){
		this.num=num;
	}
	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}
	
}
