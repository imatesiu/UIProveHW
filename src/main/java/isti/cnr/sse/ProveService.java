package isti.cnr.sse;


import java.util.ArrayList;
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
		
	    list.add( new Prova ("Alimentazione Senza Vincolo Fiscale", Messages.getString("ProveService.Alimentazione.Desc"),TipoProve.AlimentazioneBatteriaSenzaVincoloFiscale ,  getRandomSoldState(),mF)); //$NON-NLS-1$ //$NON-NLS-2$
	    list.add( new Prova ("Batteria Sotto Protezione SF", Messages.getString("ProveService.BatteriaP.Desc"),TipoProve.BatteriaSottoProtezioneSF ,  getRandomSoldState(),mF)); //$NON-NLS-1$ //$NON-NLS-2$

	    list.add( new Prova ("Disturbi Condotti", Messages.getString("ProveService.DisturbiC.Desc"),TipoProve.DisturbiCondotti ,  getRandomSoldState(),mF)); //$NON-NLS-1$ //$NON-NLS-2$
	    list.add( new Prova ("Disturbi Elettromagnetici", Messages.getString("ProveService.DisturbiE.Desc"),TipoProve.DisturbiElettromagnetici ,  getRandomSoldState(),mF)); //$NON-NLS-1$ //$NON-NLS-2$

	    list.add( new Prova ("Impermeabilità", Messages.getString("ProveService.Impe.Desc"),TipoProve.Impermeabilita ,  getRandomSoldState(),mF)); //$NON-NLS-1$ //$NON-NLS-2$
	    list.add( new Prova ("Guasto e Malfunzionamento", Messages.getString("ProveService.Guasto.Desc"),TipoProve.Guastoemalfunzionamento ,  getRandomSoldState(),mF)); //$NON-NLS-1$ //$NON-NLS-2$


	    list.add( new Prova ("Termiche", Messages.getString("ProveService.Term.Desc"),TipoProve.Termiche ,  getRandomSoldState(),mF)); //$NON-NLS-1$ //$NON-NLS-2$
	    list.add( new Prova ("Vibrazione", Messages.getString("ProveService.Vib.Desc"),TipoProve.Vibrazione ,  getRandomSoldState(),mF)); //$NON-NLS-1$ //$NON-NLS-2$
	    
	    list.add( new Prova ("Scariche Elettrostatiche", Messages.getString("ProveService.Scariche.Desc"),TipoProve.ScaricheElettrostatiche ,  getRandomSoldState(),mF)); //$NON-NLS-1$ //$NON-NLS-2$
        
        return list;
    }
    
   
    
    private boolean getRandomSoldState() {
		return (Math.random() > 0.5) ? true: false;
	}
    
   
}
