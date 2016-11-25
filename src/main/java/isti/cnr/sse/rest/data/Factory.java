package isti.cnr.sse.rest.data;

import java.util.ArrayList;
import java.util.List;

public class Factory {

	
	public static List<String> getNomeDitta(List<Ditta> d){
		List<String> r = new ArrayList<String>();
		for (Ditta e : d) {
			r.add(e.getNomeDitta());
		}
		
		return r;
	}
	
	public static List<String> getNomeModello(List<Ditta> d, String ditta){
		List<String> r = new ArrayList<String>();
		for (Ditta e : d) {
			if(e.getNomeDitta().equals(ditta)){
				
				return e.getInfoMF().getLeft();
			}else{
				r.addAll(e.getInfoMF().getLeft());
			}
			
		}
		
		
		
		return r;
		
	}
	
	
}
