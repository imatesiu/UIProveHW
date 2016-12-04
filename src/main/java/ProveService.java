

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import isti.cnr.sse.rest.data.ModelloMF;
import isti.cnr.sse.rest.data.Prova;
import isti.cnr.sse.rest.data.TipoProve;

@ManagedBean(name = "proveService")
@ApplicationScoped
public class ProveService {
    
    
    public List<Prova> createProve(ModelloMF mF) {
        List<Prova> list = new ArrayList<Prova>();
		
	    list.add( new Prova ("Alimentazione Senza Vincolo Fiscale", "desc",TipoProve.AlimentazioneBatteriaSenzaVincoloFiscale ,  getRandomSoldState(),mF));
	    list.add( new Prova ("Batteria Sotto Protezione SF", "desc",TipoProve.BatteriaSottoProtezioneSF ,  getRandomSoldState(),mF));

	    list.add( new Prova ("Disturbi Condotti", "desc",TipoProve.DisturbiCondotti ,  getRandomSoldState(),mF));
	    list.add( new Prova ("Disturbi Elettromagnetici", "desc",TipoProve.DisturbiElettromagnetici ,  getRandomSoldState(),mF));

	    list.add( new Prova ("Impermeabilità", "desc",TipoProve.Impermeabilita ,  getRandomSoldState(),mF));
	    list.add( new Prova ("Guasto e Malfunzionamento", "desc",TipoProve.Guastoemalfunzionamento ,  getRandomSoldState(),mF));


	    list.add( new Prova ("Termiche", "desc",TipoProve.Termiche ,  getRandomSoldState(),mF));
	    list.add( new Prova ("Vibrazione", "desc",TipoProve.Vibrazione ,  getRandomSoldState(),mF));
	    
	    list.add( new Prova ("Scariche Elettrostatiche", "desc",TipoProve.ScaricheElettrostatiche ,  getRandomSoldState(),mF));
        
        return list;
    }
    
   
    
    private boolean getRandomSoldState() {
		return (Math.random() > 0.5) ? true: false;
	}
    
   
}
