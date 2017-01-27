package isti.cnr.sse;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import isti.cnr.sse.rest.data.SendRest;

@ManagedBean
@RequestScoped
public class InsertMF {

	private List<SelectItem> ListDitta;
	private String nomeDispositivo;
	private String nomeDitta;
	private String numeroRapportoProva;
	private boolean value;
	private boolean esterno;
	private boolean moduloinvio;
	private boolean originale;

	@PostConstruct
	public void init() {
		
		SendRest s = new SendRest();
		ListDitta = s.getSelectedItemDitte();
		value = false;
	}

	
	
	public boolean isModuloinvio() {
		return moduloinvio;
	}



	public void setModuloinvio(boolean moduloinvio) {
		this.moduloinvio = moduloinvio;
	}



	



	public boolean isOriginale() {
		return originale;
	}



	public void setOriginale(boolean orginale) {
		this.originale = orginale;
	}



	public boolean isEsterno() {
		return esterno;
	}



	public void setEsterno(boolean esterno) {
		this.esterno = esterno;
	}



	public boolean isValue() {
		return value;
	}



	public void setValue(boolean value) {
		this.value = value;
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
	
	public String go() {
		return "/pages/CreaProve.xhtml";
	}
	
	 public void addMessage() {
	        String summary = value ? "Checked" : "Unchecked";
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
	    }
	 public void addMessageA() {
	        String summary = esterno ? "Checked" : "Unchecked";
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
	    }
	 
	 public void addMessagemodulo() {
	        String summary = moduloinvio ? "Checked" : "Unchecked";
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
	    }
	 
	 public void addMessageAgg() {
	        String summary = originale ? "Checked" : "Unchecked";
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
	    }
}
