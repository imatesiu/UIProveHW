package isti.cnr.sse;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.primefaces.event.SelectEvent;

import isti.cnr.sse.rest.data.ModelloMF;
import isti.cnr.sse.rest.data.Prova;
import isti.cnr.sse.rest.data.SendRest;

@ManagedBean
@ViewScoped
public class SearchMF {
	
	private String nomeDispositivo;
	private String nomeDitta;
	private String numeroRapportoProva;
	private String anno;
	private boolean value;
	private boolean esterno;
	private List<Prova> Prove = new ArrayList<>();
	
	
	private List<SelectItem> Ditte;
	private List<SelectItem> Modelli = new ArrayList<>();

	@PostConstruct
	public void init() {
		
		SendRest s = new SendRest();
		Ditte = s.getSelectedItemDitte();
		value = false;
		esterno = false;
	}
	
	
	
	public String getNomeDispositivo() {
		return nomeDispositivo;
	}
	public void setNomeDispositivo(String nomeDispositivo) {
		this.nomeDispositivo = nomeDispositivo;
	}
	public String getNomeDitta() {
		return nomeDitta;
	}
	public void setNomeDitta(String nomeDitta) {
		this.nomeDitta = nomeDitta;
	}
	public String getNumeroRapportoProva() {
		return numeroRapportoProva;
	}
	public void setNumeroRapportoProva(String numeroRapportoProva) {
		this.numeroRapportoProva = numeroRapportoProva;
	}
	public boolean isValue() {
		return value;
	}
	public void setValue(boolean value) {
		this.value = value;
	}
	public boolean isEsterno() {
		return esterno;
	}
	public void setEsterno(boolean esterno) {
		this.esterno = esterno;
	}
	public List<SelectItem> getDitte() {
		return Ditte;
	}
	public void setDitte(List<SelectItem> ditte) {
		Ditte = ditte;
	}
	public List<SelectItem> getModelli() {
		return Modelli;
	}
	public void setModelli(List<SelectItem> modelli) {
		Modelli = modelli;
	}
	public List<Prova> getProve() {
		return Prove;
	}
	public void setProve(List<Prova> prove) {
		Prove = prove;
	}
	
	public String getAnno() {
		return anno;
	}



	public void setAnno(String anno) {
		this.anno = anno;
	}

	public void actionModello(SelectEvent  event){
		String modello = (String)	event.getObject();
		SendRest s = new SendRest();
		ModelloMF MF = s.getModelloMF(nomeDitta,modello);
		nomeDispositivo = modello;
		numeroRapportoProva = MF.getNumeroRapportoProva();
		value = MF.isRT();
		esterno = MF.isAllaperto();
		Prove = MF.getProve(); 
	}


	public void actionDitta(SelectEvent  event){
		nomeDispositivo = "";
		numeroRapportoProva = "";
		Prove = new ArrayList<>();
		String d = (String)	event.getObject();
		SendRest s = new SendRest();
		nomeDitta = d;
		Modelli.addAll(s.getSelectedItemModelli(d,anno)); 
		System.out.println("");
	}
	
	
	

}
