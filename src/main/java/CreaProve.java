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
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;

import org.primefaces.context.RequestContext;
import org.primefaces.event.DragDropEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import isti.cnr.sse.rest.data.Ditta;
import isti.cnr.sse.rest.data.Factory;
import isti.cnr.sse.rest.data.ModelloMF;
import isti.cnr.sse.rest.data.Prova;

import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CreaProve {

	private String nomeDitta;
	private String modelloMF;
	private String numeroRapportoProva;
	private Date date;
	
	@ManagedProperty(value="#{ditta}")
	private Ditta ditta;


	@ManagedProperty("#{proveService}")
	private ProveService service;

	private List<Prova> prove;

	private List<Prova> droppedProve;

	public Prova selected;

	private List<Ditta> ditte;
	
	@ManagedProperty(value="#{factory}")
	private Factory ds;
	
	
	


	@PostConstruct
	public void init() {
		prove = service.createProve();
		droppedProve = new ArrayList<Prova>();
		//ditte = Init.ini();
		ds = new Factory();
	}



	public Date getDate() {
		return date;
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
		
		RequestContext rc = RequestContext.getCurrentInstance();
	//	List<Ditta> r = new ArrayList<>();
	  //rc.execute("$(' PF('acmodello').val('')')");
		modelloMF = "";
		numeroRapportoProva = "";
		ditta = (Ditta)	event.getObject();
	}
	
	
	
	public void actionMF(SelectEvent  event){
		ModelloMF ModelloMF = (ModelloMF)	event.getObject();
		numeroRapportoProva = ModelloMF.getNumeroRapportoProva();
	
	}


	public void setService(ProveService service) {
		this.service = service;
	}

	public List<Prova> getProve() {
		return prove;
	}

	
	
	public Factory getDs() {
		return ds;
	}



	public void setDs(Factory ds) {
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

	public List<ModelloMF> completeModelloMF(String query) {
		return ditta.queryByName(query);
	}
	
	public List<String> completeModelloMF2(String query) {
		
		List<String> allThemes =  Factory.getNomeModello(ditte, getNomeDitta());;
		List<String> filteredThemes = new ArrayList<String>();

		for (int i = 0; i < allThemes.size(); i++) {
			String skin = allThemes.get(i);
			if(skin.toLowerCase().startsWith(query)) {
				filteredThemes.add(skin);
			}
		}

		return filteredThemes;
	}
	
	public List<Ditta> completeDitta(String query) {
		return ds.queryByName(query);
	}

	public List<String> completeDitta2(String query) {
		List<String> allThemes = Factory.getNomeDitta(ditte);
		List<String> filteredThemes = new ArrayList<String>();

		for (int i = 0; i < allThemes.size(); i++) {
			String skin = allThemes.get(i);
			if(skin.toLowerCase().startsWith(query)) {
				filteredThemes.add(skin);
			}
		}
		
		return filteredThemes;
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
		addMessage("Data saved"+numeroRapportoProva);
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




}
