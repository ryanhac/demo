package acuk.corp.jsf.pagecode;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

@ManagedBean(name="loginBean")
@RequestScoped
public class LoginBean {

	private String userId;
	
	private String password;
	
	private static final String USER_ADMIN_ROLE="admin";

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String login(){
		System.out.println("Userid-"+getUserId());
		System.out.println("Password-"+getPassword());
		
		Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken userNamePasswordToken = new UsernamePasswordToken(userId, password);
		currentUser.login(userNamePasswordToken);
		
		System.out.println(currentUser.getPrincipal());
		if(currentUser.hasRole(USER_ADMIN_ROLE)){
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("adminHome.faces");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else{
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("403.faces");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
}
