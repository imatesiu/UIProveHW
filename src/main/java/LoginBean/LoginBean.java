package LoginBean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import isti.cnr.sse.SessionUtils;

@ManagedBean
@SessionScoped
public class LoginBean {
	private String username;
	private String password;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String login() {
		if (username.equals("admin") && password.equals("admin")) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", username);
			return "index";
		} else{
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Incorrect Username and Passowrd",
							"Please enter correct username and Password"));

			return "login";
		
		}
	}

	//logout event, invalidate session
	public String logout(ActionEvent event) {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}

	public boolean getPermission(){
		HttpSession session = SessionUtils.getSession();
		String o = session.getAttribute("username").toString();
		return true;

	}
}
