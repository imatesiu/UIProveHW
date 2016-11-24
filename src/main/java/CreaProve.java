import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.primefaces.event.DragDropEvent;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CreaProve {

	private String nomeDitta;
	private String modelloMF;
	private String numeroRapportoProva;
	
	@ManagedProperty("#{carService}")
    private CarService service;

    private List<Prova> prove;
    
    private List<Prova> droppedProve;
    
    private Prova selectedProve;
    
    @PostConstruct
    public void init() {
        prove = service.createCars(9);
        droppedProve = new ArrayList<Prova>();
    }
    
    public void onProveDrop(DragDropEvent ddEvent) {
        Prova car = ((Prova) ddEvent.getData());
 
        droppedProve.add(car);
        prove.remove(car);
    }
    
    public void setService(CarService service) {
        this.service = service;
    }

    public List<Prova> getProve() {
        return prove;
    }

    public List<Prova> getDroppedProve() {
        return droppedProve;
    }    

    public Prova getSelectedProva() {
        return selectedProve;
    }

    public void setSelectedProve(Prova selectedProve) {
        this.selectedProve = selectedProve;
    }
	
	  public List<String> completeModelloMF(String query) {
	        List<String> allThemes =  new ArrayList<String>();
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
	        List<String> allThemes =  new ArrayList<String>();
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

	public void close(ActionEvent actionEvent) {
		addMessage("Data updated");
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	
	
	
}
