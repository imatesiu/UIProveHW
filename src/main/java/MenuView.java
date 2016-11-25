import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.primefaces.event.DragDropEvent;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
@SessionScoped
public class MenuView {
	
	private String pageName = "InsertMisuratoreFiscale";
	
	
	
	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public void newDitta(ActionEvent actionEvent) {
		setPageName("InsertDitta");
	//	addMessage("Data saved");
	}

	public void newModello(ActionEvent actionEvent) {
		setPageName("InsertMisuratoreFiscale");
	//	addMessage("Data saved");
	}
	
	public void newProve(ActionEvent actionEvent) {
		setPageName("CreaProve");
	//	addMessage("Data saved");
	}
	
	public void updateProva(ActionEvent actionEvent) {
		addMessage("Data ");
	}
	
	public void statisticProve(ActionEvent actionEvent) {
		addMessage("Data ");
	}
	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
