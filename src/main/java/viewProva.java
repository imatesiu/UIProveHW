import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import isti.cnr.sse.rest.data.Esito;
import isti.cnr.sse.rest.data.Prova;

@ManagedBean
@RequestScoped
public class viewProva {
	
	private Prova prova = new Prova();
	private Esito esito;
	private List<StreamedContent> allegati;
	private StreamedContent selecteda;
	

	@PostConstruct
	public void init() {
		allegati = new ArrayList<StreamedContent>();
	}
	
	public void action(ActionEvent actionEvent) {
		
	}

	
	public StreamedContent getSelecteda() {
		return selecteda;
	}

	public void setSelecteda(StreamedContent selecteda) {
		this.selecteda = selecteda;
	}

	public Prova getProva() {
		return prova;
	}

	
	public List<StreamedContent> getAllegati() {
		return allegati;
	}

	public void setAllegati(List<StreamedContent> allegati) {
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
	
	 public void handleFileUpload(FileUploadEvent event) throws IOException {
		 
		 	allegati.add(new DefaultStreamedContent(event.getFile().getInputstream(),
		 			event.getFile().getContentType(),event.getFile().getFileName()));
	        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
	        FacesContext.getCurrentInstance().addMessage(null, message);
	}
	 
	 public void remallegato() {
			allegati.remove(selecteda);
			
		}
	 
	 public StreamedContent  getDownload() {
		 return selecteda;
	 }
}
