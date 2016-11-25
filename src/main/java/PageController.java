

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name="pageController")
@SessionScoped
public class PageController implements Serializable {
	private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(PageController.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 4554289279328839768L;

	
	
	public String navigateCenter() {
		log.info("Redirect to Page 2");
		
		return "center"; //?faces-redirect=true";
	}
	
	public String action() {
		log.info("Action Fired");
		
		return null;
	}
	
	public void actionListener(ActionEvent event) {
		log.info("ActionListener Fired");
	}
}