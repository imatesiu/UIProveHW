package isti.cnr.sse.rest.data;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


//To be considered by the JavaServer Faces As Managed Bean
// & Make the converter Eligible for use @ManagedProperty
@ManagedBean
@RequestScoped
@FacesConverter
public class DittaConverter implements Converter{
	
	@ManagedProperty(value="#{dittaDataSource}")
	private Factory ds;

	public Factory getDs() {
		return ds;
	}

	public void setDs(Factory ds) {
		this.ds = ds;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,String value) {
		for(Ditta p : Init.ini()){
			if(p.getNomeDitta().equals(value)){
				return p;
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,Object value) {
		if(value instanceof Ditta){
			Ditta player = (Ditta)value;
			return player.getNomeDitta();
		}
		return "";
	}

}