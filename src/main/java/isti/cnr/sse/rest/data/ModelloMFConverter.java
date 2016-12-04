package isti.cnr.sse.rest.data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import isti.cnr.sse.SelectProve;


//To be considered by the JavaServer Faces As Managed Bean
// & Make the converter Eligible for use @ManagedProperty
@ManagedBean
//@RequestScoped
//@FacesConverter
public class ModelloMFConverter implements Converter{



	@Override
	public Object getAsObject(FacesContext fc, UIComponent component,String value) {


		// SelectProve service = (SelectProve) fc.getELContext().getELResolver().getValue(fc.getELContext(), null,"selectProve");
	//	SelectProve service = (SelectProve) fc.getExternalContext().getApplicationMap().get("selectProve");
	//	Ditta ditta = (Ditta)  FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ditta");
		 SelectProve service = (SelectProve) fc.getApplication()
				    .getVariableResolver().resolveVariable(fc, "selectProve");

			Ditta ditta = service.getDitta();
			if(ditta!=null)
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
			//ditta.getMisuratoriFiscali().add(player);
			return player.getNomeModello();
		}
		return "";
	}

}