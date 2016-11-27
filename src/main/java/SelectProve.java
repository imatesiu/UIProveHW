import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import isti.cnr.sse.rest.data.Ditta;
import isti.cnr.sse.rest.data.Factory;
import isti.cnr.sse.rest.data.ModelloMF;
import isti.cnr.sse.rest.data.Prova;

@ManagedBean
@ViewScoped
public class SelectProve {

	private String nomeDitta;
	private String modelloMF;
	private String numeroRapportoProva;


	@ManagedProperty(value="#{ditta}")
	private Ditta ditta;

	//@ManagedProperty(value="#{modelloMF}")
	private ModelloMF modello;

	@ManagedProperty(value="#{factory}")
	private Factory ds;

	//@ManagedProperty(value="#{prove}")
	private List<Prova> prove;

	@PostConstruct
	public void init() {
		
		ds = new Factory();
		prove = new ArrayList<>();
	}

	public String getNomeDitta() {
		return nomeDitta;
	}

	public void setNomeDitta(String nomeDitta) {
		this.nomeDitta = nomeDitta;
	}

	public String getModelloMF() {
		return modelloMF;
	}

	public void setModelloMF(String modelloMF) {
		this.modelloMF = modelloMF;
	}

	public String getNumeroRapportoProva() {
		return numeroRapportoProva;
	}

	public void setNumeroRapportoProva(String numeroRapportoProva) {
		this.numeroRapportoProva = numeroRapportoProva;
	}

	public Ditta getDitta() {
		return ditta;
	}

	public void setDitta(Ditta ditta) {
		this.ditta = ditta;
	}


	public Factory getDs() {
		return ds;
	}

	public void setDs(Factory ds) {
		this.ds = ds;
	}

	public List<Prova> getProve() {
		
		return prove;
	}

	public void setProve(List<Prova> prove) {
		this.prove = prove;
	}

	public void action(SelectEvent  event){
		modelloMF = "";
		numeroRapportoProva = "";
		prove = null;
		ditta = (Ditta)	event.getObject();
	}

	public List<ModelloMF> completeModelloMF(String query) {
		return ditta.queryByName(query);
	}
	
	
	public List<Ditta> completeDitta(String query) {
		return ds.queryByName(query);
	}


	public void actionMF(SelectEvent  event){
		 modello = (ModelloMF)	event.getObject();
		numeroRapportoProva = modello.getNumeroRapportoProva();
		prove = modello.getProve();
	}
	
	

	public void save(ActionEvent actionEvent) {
		addMessage("Data saved"+numeroRapportoProva);
	}
	
	

	public void reset(ActionEvent actionEvent) {
		
		nomeDitta = new String();
		modelloMF = new String();
		ditta = new Ditta();
		prove = new ArrayList<>();
		numeroRapportoProva  = new String();

		addMessage("Data reset");
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public String go() {
		return "/pages/viewProva.xhtml";
	}


}
