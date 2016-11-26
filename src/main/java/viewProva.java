import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import isti.cnr.sse.rest.data.Esito;
import isti.cnr.sse.rest.data.Prova;

@ManagedBean
@ViewScoped
public class viewProva {
	
	private Prova prova;
	private Esito esito;
	

	/*@PostConstruct
	public void init() {
		esito = prova.getStato();
	}*/
	
	public void action(ActionEvent actionEvent) {
		
	}

	public Prova getProva() {
		return prova;
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
	
}
