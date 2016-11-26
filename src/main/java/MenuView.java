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
	
	private String pageName = "center.xhtml";
	
	
	
	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public void newDitta(ActionEvent actionEvent) {
		setPageName("InsertDitta.xhtml");
	//	addMessage("Data saved");
	}

	public void newModello(ActionEvent actionEvent) {
		setPageName("InsertMisuratoreFiscale.xhtml");
	//	addMessage("Data saved");
	}
	
	public void newProve(ActionEvent actionEvent) {
		setPageName("CreaProve.xhtml");
	//	addMessage("Data saved");
	}
	
	public void updateProva(ActionEvent actionEvent) {
		setPageName("selectProve.xhtml");
		//addMessage("Data ");
	}
	
	public void viewProva(ActionEvent actionEvent) {
		setPageName("viewProva.xhtml");
		addMessage("Data ");
	}
	
	public void statisticProve(ActionEvent actionEvent) {
		addMessage("Data ");
	}
	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public void navigateCenter(ActionEvent actionEvent) {
		setPageName("center.xhtml");
	}
	
	public String getNavigateCenter() {
		setPageName("center.xhtml");
		return pageName;
	}

	public void setNavigateCenter(String n) {
		setPageName("center.xhtml");
	}
}
