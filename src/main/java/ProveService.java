

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import isti.cnr.sse.rest.data.Prova;
import isti.cnr.sse.rest.data.pojo.TipoProve;

@ManagedBean(name = "proveService")
@ApplicationScoped
public class ProveService {
    
    private final static String[] colors;
	
	private final static String[] brands;
    
    static {
		colors = new String[10];
		colors[0] = "Black";
		colors[1] = "White";
		colors[2] = "Green";
		colors[3] = "Red";
		colors[4] = "Blue";
		colors[5] = "Orange";
		colors[6] = "Silver";
		colors[7] = "Yellow";
		colors[8] = "Brown";
		colors[9] = "Maroon";
		
		brands = new String[10];
		brands[0] = "BMW";
		brands[1] = "Mercedes";
		brands[2] = "Volvo";
		brands[3] = "Audi";
		brands[4] = "Renault";
		brands[5] = "Fiat";
		brands[6] = "Volkswagen";
		brands[7] = "Honda";
		brands[8] = "Jaguar";
		brands[9] = "Ford";
	}
    
    public List<Prova> createProve() {
        List<Prova> list = new ArrayList<Prova>();
		
	    list.add( new Prova ("Alimentazione Senza Vincolo Fiscale", "desc",TipoProve.AlimentazioneBatteriaSenzaVincoloFiscale ,  getRandomSoldState()));
	    list.add( new Prova ("Batteria Sotto Protezione SF", "desc",TipoProve.BatteriaSottoProtezioneSF ,  getRandomSoldState()));

	    list.add( new Prova ("Disturbi Condotti", "desc",TipoProve.DisturbiCondotti ,  getRandomSoldState()));
	    list.add( new Prova ("Disturbi Elettromagnetici", "desc",TipoProve.DisturbiElettromagnetici ,  getRandomSoldState()));

	    list.add( new Prova ("Impermeabilità", "desc",TipoProve.Impermeabilita ,  getRandomSoldState()));
	    list.add( new Prova ("Guasto e Malfunzionamento", "desc",TipoProve.Guastoemalfunzionamento ,  getRandomSoldState()));


	    list.add( new Prova ("Termiche", "desc",TipoProve.Termiche ,  getRandomSoldState()));
	    list.add( new Prova ("Vibrazione", "desc",TipoProve.Vibrazione ,  getRandomSoldState()));
	    
	    list.add( new Prova ("Scariche Elettrostatiche", "desc",TipoProve.ScaricheElettrostatiche ,  getRandomSoldState()));
        
        return list;
    }
    
   
    
    private boolean getRandomSoldState() {
		return (Math.random() > 0.5) ? true: false;
	}
    
    public List<String> getColors() {
        return Arrays.asList(colors);
    }
    
    public List<String> getBrands() {
        return Arrays.asList(brands);
    }
}
