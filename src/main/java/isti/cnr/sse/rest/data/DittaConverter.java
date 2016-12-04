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
public class DittaConverter implements Converter{
	
	

	@Override
	public Object getAsObject(FacesContext fc, UIComponent component,String value) {
		
		
		 if(value != null && value.trim().length() > 0) {
		       
		       FacesContext context = FacesContext.getCurrentInstance();
		       
	//	 SelectProve service2 = (SelectProve) context.getELContext().getELResolver().getValue(context.getELContext(), null,"selectProve");
	       
			 
			
		       FactoryLocal f2 = (FactoryLocal)  FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("factoryLocal");
			 
				//SelectProve service = (SelectProve) fc.getExternalContext().getRequestMap().get("selectProve");
		       SelectProve service = (SelectProve) fc.getApplication()
			    .getVariableResolver().resolveVariable(fc, "selectProve");
			 
				 


				
	            	if(service!=null)
	            		for(Ditta p : service.getDs().getList()){
	            			if(p.getNomeDitta().equals(value)){
	            				return p;
	            			}
	            		}
	            		return null;
	            
	            
		 }else {
	            return null;
	        }
		
		
		
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