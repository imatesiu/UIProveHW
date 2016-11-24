import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


@ManagedBean
@RequestScoped
public class InsertDitta {
	
	private String nomeDitta;
	private String indirizzo;
	private String pIVA;
	
	
	
	
	
	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNomeDitta() {
		return nomeDitta;
	}

	public void setNomeDitta(String nomeDitta) {
		this.nomeDitta = nomeDitta;
	}

	public String getpIVA() {
		return pIVA;
	}

	public void setpIVA(String pIVA) {
		this.pIVA = pIVA;
	}

	public void save(ActionEvent actionEvent) {
        addMessage("Data saved ditta");
    }
     
    public void close(ActionEvent actionEvent) {
        addMessage("Data updated");
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
