package isti.cnr.sse.rest.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import isti.cnr.sse.rest.data.pojo.TipoProve;

@ManagedBean
@SessionScoped
@Generated("org.jsonschema2pojo")
public class Prova implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SerializedName("nomeProva")
    @Expose
	public String nomeProva = new String();
	@SerializedName("DescProva")
    @Expose
	public String descrizioneProva = new String();
	
	public TipoProve tp;
	
	public Esito stato = Esito.Incorso;
	
	
    
	public ModelloMF mf = new ModelloMF();
	
	@SerializedName("allegati")
    @Expose
	public List<Allegato> listallegato = new ArrayList<>();

	@SerializedName("editated")
	public boolean selezionabile;

	public Prova() {}


	public Prova(String nome, String desc, TipoProve tp, boolean sold, ModelloMF mf) {
		this.nomeProva = nome;
		this.descrizioneProva = desc;
		this.selezionabile = sold;
		this.tp  = tp; 
		this.stato = Esito.Incorso;
		this.mf = mf;
	}






	public ModelloMF getMf() {
		return mf;
	}


	public void setMf(ModelloMF mf) {
		this.mf = mf;
	}


	public Esito getStato() {
		return stato;
	}


	public void setStato(Esito state) {
		this.stato = state;
	}


	public TipoProve getTp() {
		return tp;
	}


	public void setTp(TipoProve tp) {
		this.tp = tp;
	}


	public String getNomeProva() {
		return nomeProva;
	}


	public void setNomeProva(String nomeProva) {
		this.nomeProva = nomeProva;
	}


	public String getDescrizioneProva() {
		return descrizioneProva;
	}


	public void setDescrizioneProva(String descrizioneProva) {
		this.descrizioneProva = descrizioneProva;
	}


	public boolean isSelezionabile() {
		return selezionabile;
	}
	public void setSelezionabile(boolean sold) {
		this.selezionabile = sold;
	}


	@Override
	public String toString() {
		return nomeProva;
	}


	@Override
	public int hashCode() {
		int hash = 7;
		hash = 59 * hash + (this.nomeProva != null ? this.nomeProva.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Prova other = (Prova) obj;
		if ((this.nomeProva == null) ? (other.nomeProva != null) : !this.nomeProva.equals(other.nomeProva)) {
			return false;
		}
		return true;
	}

	public List<StreamedContent> getDownladable(){
		List<StreamedContent> l = new ArrayList<>();
		for(Allegato a:listallegato){
			
			String path = a.getUrl();
			String contentType = FacesContext.getCurrentInstance().getExternalContext().getMimeType(path);
			try {
				l.add(new DefaultStreamedContent(new FileInputStream(path), contentType));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return l;
	}


}
