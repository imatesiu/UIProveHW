import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import isti.cnr.sse.rest.data.Prova;

@ManagedBean
@ViewScoped
public class viewProva {
	
	private Prova prova;
	
	public void action(ActionEvent actionEvent) {
		
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}
	

	
}
