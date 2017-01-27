package isti.cnr.sse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;
import org.primefaces.event.DragDropEvent;
import org.primefaces.event.SelectEvent;

import isti.cnr.sse.rest.data.Ditta;
import isti.cnr.sse.rest.data.FactoryLocal;
import isti.cnr.sse.rest.data.ModelloMF;
import isti.cnr.sse.rest.data.Prova;
import isti.cnr.sse.rest.data.SendRest;

@ManagedBean
@SessionScoped
public class CreaProve {

	private String nomeDitta;
	private String modelloMF;
	private String numeroRapportoProva;
	private boolean value;
	private Date date;
	private boolean esterno;
	private boolean moduloinvio;
	private boolean originale;
	private Ditta ditta = new Ditta();


	@ManagedProperty("#{proveService}")
	private ProveService service;

	private List<Prova> prove = new ArrayList<>();

	private List<Prova> droppedProve = new ArrayList<>();

	public Prova selected = new Prova();

	private List<Ditta> ditte= new ArrayList<>();
	
	@ManagedProperty(value="#{factory}")
	private FactoryLocal ds;
	
	
	


	@PostConstruct
	public void init() {
		
		droppedProve = new ArrayList<Prova>();
		//ditte = Init.ini();
		//ds = new FactoryLocal("new");
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




	public void setOriginale(boolean originale) {
		this.originale = originale;
	}




	public boolean isEsterno() {
		return esterno;
	}




	public void setEsterno(boolean esterno) {
		this.esterno = esterno;
	}




	public Date getDate() {
		return date;
	}


	

	public boolean isValue() {
		return value;
	}



	public void setValue(boolean value) {
		this.value = value;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public void onProveDrop(DragDropEvent ddEvent) {
		Prova p = ((Prova) ddEvent.getData());

		droppedProve.add(p);
		prove.remove(p);
	}
	
	 public void reset() {
	        RequestContext.getCurrentInstance().reset("ProveForm:panel");
	    }
	
	
	public void action(SelectEvent  event){
	//	reset();
		
	//	RequestContext rc = RequestContext.getCurrentInstance();
	//	List<Ditta> r = new ArrayList<>();
	  //rc.execute("$(' PF('acmodello').val('')')");
		modelloMF = "";
		numeroRapportoProva = "";
		ditta = (Ditta)	event.getObject();
	}
	
	
	



	public void setService(ProveService service) {
		this.service = service;
	}

	public List<Prova> getProve() {
		return prove;
	}

	
	
	public FactoryLocal getDs() {
		return ds;
	}



	public void setDs(FactoryLocal ds) {
		this.ds = ds;
	}



	public Ditta getDitta() {
		return ditta;
	}



	public void setDitta(Ditta ditta) {
		this.ditta = ditta;
	}



	public List<Prova> getDroppedProve() {
		return droppedProve;
	}    
	public void remprova() {
		droppedProve.remove(selected);
		prove.add(selected);

	}

	public Prova getSelected() {
		return selected;
	}



	public void setSelected(Prova selectedProve) {
		this.selected = selectedProve;
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


	public void save(ActionEvent actionEvent) {
		ModelloMF MF = new ModelloMF(getModelloMF(), getNumeroRapportoProva(), getNomeDitta(),getDate());
		MF.setRT(value);
		MF.setProve(droppedProve);
		SendRest s = new SendRest();
		String resutl = s.saveNewModello(MF);
		addMessage(resutl);
	}

	public void reset(ActionEvent actionEvent) {
		init();
		nomeDitta = new String();
		modelloMF = new String();
		ditta = null;
		date  = new Date();
		numeroRapportoProva  = new String();
		
		addMessage("Data reset");
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}


	public String go() {
		return "/index.xhtml";
	}

	public String goprove() {
		ModelloMF MF = new ModelloMF(getModelloMF(), getNumeroRapportoProva(), getNomeDitta(),new Date());
		prove = service.createProve(MF);
		droppedProve = new ArrayList<Prova>();
		return "/pages/CreaProve.xhtml";
	}

}
