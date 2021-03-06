
import java.io.Serializable;

import isti.cnr.sse.rest.data.pojo.TipoProve;

public class Prova implements Serializable {
    
    public String nomeProva;
    public String descrizioneProva;
    public TipoProve tp;

    public boolean selezionabile;

    public Prova() {}
    
        
    public Prova(String nome, String desc, TipoProve tp, boolean sold) {
        this.nomeProva = nome;
        this.descrizioneProva = desc;
        this.selezionabile = sold;
        this.tp  = tp; 
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
}
