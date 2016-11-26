import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import isti.cnr.sse.rest.data.Esito;
import isti.cnr.sse.rest.data.Prova;

@ManagedBean
@ViewScoped
public class viewProva {
	
	private Prova prova;
	private Esito esito;
	private List<UploadedFile> allegati;
	private UploadedFile selecteda;
	

	@PostConstruct
	public void init() {
		allegati = new ArrayList<UploadedFile>();
	}
	
	public void action(ActionEvent actionEvent) {
		
	}

	
	public UploadedFile getSelecteda() {
		return selecteda;
	}

	public void setSelecteda(UploadedFile selecteda) {
		this.selecteda = selecteda;
	}

	public Prova getProva() {
		return prova;
	}

	
	public List<UploadedFile> getAllegati() {
		return allegati;
	}

	public void setAllegati(List<UploadedFile> allegati) {
		this.allegati = allegati;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}
	
	
	
	
	public Esito getEsito() {
		return esito;
	}

	public void setEsito(Esito esito) {
		this.esito = esito;
	}

	public void optionEsito(ActionEvent actionEvent) {
		
	}
	

	public List<Esito> getOptionEsiti(){
		esito = prova.getStato();
		return Esito.getListEsiti();
	}
	
	 public void handleFileUpload(FileUploadEvent event) {
		 	allegati.add(event.getFile());
	        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
	        FacesContext.getCurrentInstance().addMessage(null, message);
	}
	 
	 public void remallegato() {
			allegati.remove(selecteda);
			
		}
}
