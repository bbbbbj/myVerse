package verse.user;

import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import verse.entity.Uzer;
import verse.utils.AuthService;
@ManagedBean
@RequestScoped
public class AddUser extends Uzer{
	@EJB
	private AuthService authService;
	
	public AddUser(){
		setType("普通用户");
	}
	
	public void addUser() {
		
		Uzer user = new Uzer(getUserName(), getPassword(), getType());
		authService.addUser(user);
		setUserName(null);
		setPassword(null);
		setType(null);
//		return "index";
	}
}
