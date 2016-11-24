import javax.faces.bean.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
public class InsertDitta {
	
	
	
	public void save(ActionEvent actionEvent) {
        addMessage("Data saved");
    }
     
    public void close(ActionEvent actionEvent) {
        addMessage("Data updated");
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
