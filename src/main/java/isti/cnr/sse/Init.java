package isti.cnr.sse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;


import isti.cnr.sse.rest.data.Ditta;
import isti.cnr.sse.rest.data.ModelloMF;

public class Init {
	
	public static List<SelectItem> init(){
		List<SelectItem> e = new ArrayList<SelectItem>();
		Ditta a = new Ditta("Custom", "Parma", "11");
		List<ModelloMF> misuratoriFiscali = new ArrayList<>();
		ModelloMF mf = new ModelloMF("TIPO1","14E","Custom");
		misuratoriFiscali.add(mf);
		a.setMisuratoriFiscali(misuratoriFiscali );
		e.add(getSelectItem(a));
		
		
		
		Ditta b = new Ditta("SHS", "Roma", "1213");
		misuratoriFiscali = new ArrayList<>();
		mf = new ModelloMF("TIPO2","15E","SHS");
		misuratoriFiscali.add(mf);
		b.setMisuratoriFiscali(misuratoriFiscali );
		e.add(getSelectItem(b));
		
		Ditta c = new Ditta("HP", "Pisa", "121");
		misuratoriFiscali = new ArrayList<>();
		mf = new ModelloMF("TIPO3","17E","HP");
		misuratoriFiscali.add(mf);
		c.setMisuratoriFiscali(misuratoriFiscali );
		e.add(getSelectItem(c));
		return e;
	}
	
	
	private static SelectItem getSelectItem(Ditta a) {
		return new SelectItem(a.getNomeDitta(),a.getNomeDitta());
	}


	public static List<Ditta> ini(){
		List<Ditta> e = new ArrayList<Ditta>();
		Ditta a = new Ditta("Custom", "Parma", "11");
		List<ModelloMF> misuratoriFiscali = new ArrayList<>();
		ModelloMF mf = new ModelloMF("TIPO1","14E","Custom");
		misuratoriFiscali.add(mf);
		a.setMisuratoriFiscali(misuratoriFiscali );
		e.add(a);
		
		
		
		Ditta b = new Ditta("SHS", "Roma", "1213");
		misuratoriFiscali = new ArrayList<>();
		mf = new ModelloMF("TIPO2","15E","SHS");
		misuratoriFiscali.add(mf);
		b.setMisuratoriFiscali(misuratoriFiscali );
		e.add(b);
		
		Ditta c = new Ditta("HP", "Pisa", "121");
		misuratoriFiscali = new ArrayList<>();
		mf = new ModelloMF("TIPO3","17E","HP");
		misuratoriFiscali.add(mf);
		c.setMisuratoriFiscali(misuratoriFiscali );
		e.add(c);
		return e;
	}
	
	public static Map<String, List<String>> getIni(){
		
		List<Ditta> element = ini();
		
		List<String> e = new ArrayList<String>();
		for (Ditta d : element) {
			e.add(d.getNomeDitta());
			List<String> t = new ArrayList<String>();
			for ( ModelloMF m : d.getMisuratoriFiscali()) {
				t.add(m.getNomeModello());
			}
		}
		
		
		
		
		return  null;
	}

}
