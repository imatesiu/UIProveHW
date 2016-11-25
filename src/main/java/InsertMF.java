import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

@ManagedBean
@RequestScoped
public class InsertMF {

	private List<SelectItem> ListDitta;
	private String nomeDispositivo;
	private String nomeDitta;
	private String numeroRapportoProva;


	@PostConstruct
	public void init() {
		
		//TODO read list DITTa from rest
		ListDitta = Init.init();
		
	}

	
	public String getNomeDitta() {
		return nomeDitta;
	}


	public void setNomeDitta(String nomeDitta) {
		this.nomeDitta = nomeDitta;
	}


	public String getNomeDispositivo() {
		return nomeDispositivo;
	}

	public void setNomeDispositivo(String nomeDispositivo) {
		this.nomeDispositivo = nomeDispositivo;
	}

	public String getNumeroRapportoProva() {
		return numeroRapportoProva;
	}

	public void setNumeroRapportoProva(String numeroRapportoProva) {
		this.numeroRapportoProva = numeroRapportoProva;
	}

	public List<SelectItem> getDitta() {
		return ListDitta;
	}

	public void save(ActionEvent actionEvent) {
		addMessage("Data saved"+numeroRapportoProva);
	}

	 public void reset(ActionEvent actionEvent) {
		 	init();
	    	nomeDitta = new String();
	    	nomeDispositivo = new String();
	    	numeroRapportoProva = new String();
	        addMessage("Data reset");
	 }

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
