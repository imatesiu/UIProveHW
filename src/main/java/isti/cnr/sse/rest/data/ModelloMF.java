package isti.cnr.sse.rest.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelloMF {
	
	@SerializedName("nomeModello")
    @Expose
	private String nomeModello;
	
	@SerializedName("numeroRapportoProva")
    @Expose
	private String numeroRapportoProva;
	
	
	@SerializedName("nomeDitta")
	@Expose
	private String nomeDitta;

	public ModelloMF(){
		
	}
	public ModelloMF(String nomeModello, String numeroRapportoProva, String nomeDitta) {
		super();
		this.nomeModello = nomeModello;
		this.numeroRapportoProva = numeroRapportoProva;
		this.nomeDitta = nomeDitta;
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
	public String getNomeDitta() {
		return nomeDitta;
	}
	public void setNomeDitta(String nomeDitta) {
		this.nomeDitta = nomeDitta;
	}
	
	
	
	
	

}
