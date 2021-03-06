import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;

import org.apache.commons.lang3.tuple.Pair;

import isti.cnr.sse.rest.data.Ditta;
import isti.cnr.sse.rest.data.ModelloMF;

public class Init {
	
	public static List<SelectItem> init(){
		List<SelectItem> e = new ArrayList<SelectItem>();
		Ditta a = new Ditta("Custom", "Parma", "11");
		List<ModelloMF> misuratoriFiscali = new ArrayList<>();
		ModelloMF mf = new ModelloMF("TIPO1","14E","Custom");
		a.setMisuratoriFiscali(misuratoriFiscali );
		e.add(a.getSelectItem());
		
		
		
		Ditta b = new Ditta("SHS", "Roma", "1213");
		misuratoriFiscali = new ArrayList<>();
		mf = new ModelloMF("TIPO2","15E","SHS");
		b.setMisuratoriFiscali(misuratoriFiscali );
		e.add(b.getSelectItem());
		
		Ditta c = new Ditta("HP", "Pisa", "121");
		misuratoriFiscali = new ArrayList<>();
		mf = new ModelloMF("TIPO3","17E","HP");
		c.setMisuratoriFiscali(misuratoriFiscali );
		e.add(c.getSelectItem());
		return e;
	}
	
	
	public static List<Ditta> ini(){
		List<Ditta> e = new ArrayList<Ditta>();
		Ditta a = new Ditta("Custom", "Parma", "11");
		List<ModelloMF> misuratoriFiscali = new ArrayList<>();
		ModelloMF mf = new ModelloMF("TIPO1","14E","Custom");
		a.setMisuratoriFiscali(misuratoriFiscali );
		e.add(a);
		
		
		
		Ditta b = new Ditta("SHS", "Roma", "1213");
		misuratoriFiscali = new ArrayList<>();
		mf = new ModelloMF("TIPO2","15E","SHS");
		b.setMisuratoriFiscali(misuratoriFiscali );
		e.add(b);
		
		Ditta c = new Ditta("HP", "Pisa", "121");
		misuratoriFiscali = new ArrayList<>();
		mf = new ModelloMF("TIPO3","17E","HP");
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
