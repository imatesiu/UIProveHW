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

import isti.cnr.sse.rest.data.Ditta;
import isti.cnr.sse.rest.data.Factory;

import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
@SessionScoped
public class CreaProve {

	private String nomeDitta;
	private String modelloMF;
	private String numeroRapportoProva;
	private Date date;


	@ManagedProperty("#{proveService}")
	private ProveService service;

	private List<Prova> prove;

	private List<Prova> droppedProve;

	public Prova selected;

	private List<Ditta> ditte;

	@PostConstruct
	public void init() {
		prove = service.createProve();
		droppedProve = new ArrayList<Prova>();
		ditte = Init.ini();
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

	public void setService(ProveService service) {
		this.service = service;
	}

	public List<Prova> getProve() {
		return prove;
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

	public List<String> completeModelloMF(String query) {
		
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

	public List<String> completeDitta(String query) {
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
		numeroRapportoProva = new String();
		addMessage("Data reset");
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}




}
