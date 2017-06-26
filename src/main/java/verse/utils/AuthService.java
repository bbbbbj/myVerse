package verse.utils;

import java.util.List;


import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.primefaces.context.RequestContext;

import verse.entity.Uzer;

@Stateless
public class AuthService{
	@PersistenceContext(unitName = "javaeelocal")
	private EntityManager em;
	private boolean visitor;//是否是游客
	private Uzer user;
	private boolean admin;
	
	public AuthService() {
		// TODO Auto-generated constructor stub
	}
	
	public void addUser(Uzer user) {
		if (findUserByName(user.getUserName()) != null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "用户名被占用", null));
			return;
		}
		em.persist(user);		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "用户注册成功", null));
		
	}
	
	public Uzer findUserByName (String userName){
		TypedQuery<Uzer> query = em.createQuery("Select u from Uzer u where u.userName = :name",Uzer.class);
		query.setParameter("name", userName);
		List<Uzer> list = query.getResultList();
		if (list == null || list.isEmpty() || list.size() > 1) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "未查询到该用户名", null));
			return null;
		}	
		return list.get(0);
	}
	

}
