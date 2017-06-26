package verse.user;

import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import verse.entity.Uzer;
import verse.utils.AuthService;

@ManagedBean
@SessionScoped
public class UserBean extends Uzer{

	private boolean login;//是否登录
	private boolean admin;//是否是管理员
	private Uzer user;//登录的用户
	@EJB
	private AuthService authService;
	
	public UserBean() {
		login = false;
		admin = false;
	}	

	public boolean isLogin() {
		return login;
	}

	public boolean isAdmin() {
		return admin;
	}

	public Uzer getUser() {
		return user;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public void setUser(Uzer user) {
		this.user = user;
	}

	public void checkUser() {
		Uzer user = authService.findUserByName(getUserName());
		
		if (user != null && user.getPassword().equals(getPassword())) {//字符串值比较不用“==”
			login = true;//设置登录状态
			setType(user.getType());//设置登录的用户的类型
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "用户登录成功", null));
		}
		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "用户登录失败  ", null));
			return ;
		}
		if (user.getType().equals("管理员") ) {//字符串值比较不用“==”!!!
			admin = true;
		}
	}
	
	public void logout(){
		setUserName(null);
		user = null;
		login = false;
		setType(null);
		admin = false;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "用户注销成功  ", null));
	}
	
}
