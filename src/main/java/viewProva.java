import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import isti.cnr.sse.rest.data.Allegato;
import isti.cnr.sse.rest.data.Esito;
import isti.cnr.sse.rest.data.Prova;

@ManagedBean
@RequestScoped
public class viewProva {

	private Prova prova = new Prova();
	private Esito esito;
	private List<StreamedContent> allegati;
	private StreamedContent selecteda;
	private String note;

	public String nomeModello;
	public String numeroRapportoProva;


	@PostConstruct
	public void init() {
		allegati = new ArrayList<StreamedContent>();
	}

	public void action(ActionEvent actionEvent) {

	}


	public String getNomeModello() {
		return nomeModello;
	}

	public void setNomeModello(String nomeModello) {
		this.nomeModello = nomeModello;
	}

	public String getNumeroRapportoProva() {
		return numeroRapportoProva;
	}

	public void setNumeroRapportoProva(String numeroRapportoProva) {
		this.numeroRapportoProva = numeroRapportoProva;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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
		allegati = getDownladable(prova);

	}




	private List<StreamedContent> getDownladable(Prova prova) {
		List<StreamedContent> l = new ArrayList<>();
		for(Allegato a:prova.getListallegato()){

			String path = a.getUrl();
			String contentType = FacesContext.getCurrentInstance().getExternalContext().getMimeType(path);
			try {
				if(!path.contains("http")){
					l.add(new DefaultStreamedContent(new FileInputStream(path), contentType));
				}else{
					InputStream is = new URL(path).openStream();
					DefaultStreamedContent d = new DefaultStreamedContent( is ,contentType);
					d.setName(a.getNome());
					l.add(d);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return l;

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
