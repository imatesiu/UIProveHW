package isti.cnr.sse.rest.data;



import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;


//To be considered by the JavaServer Faces As Managed Bean
// & Make the converter Eligible for use @ManagedProperty
@ManagedBean
@RequestScoped
//@FacesConverter
public class ModelloMFConverter implements Converter{
	
	  @ManagedProperty(value="#{ditta}")
		private Ditta ditta;


	public Ditta getDitta() {
		return ditta;
	}

	public void setDitta(Ditta ditta) {
		this.ditta = ditta;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,String value) {
		for(ModelloMF p : ditta.getMisuratoriFiscali()){
			if(p.getNomeModello().equals(value)){
				return p;
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,Object value) {
		if(value instanceof ModelloMF){
			ModelloMF player = (ModelloMF)value;
			ditta.getMisuratoriFiscali().add(player);
			return player.getNomeModello();
		}
		return "";
	}

}