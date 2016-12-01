package isti.cnr.sse.rest.data;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

public class SendRest {


	public List<Ditta> getDitte(String type){
		
		String result = sendGet("/ditte/"+type);
		Gson g = new Gson();
		Ditte d  = new Ditte();
		d = g.fromJson(result, Ditte.class);
		return d.getListaDitte();
	}

	public String sendGet(String path){
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:9090").path("/cnr/sse/testhw"+path);
		Response allID =  target.request().get();
		String res = allID.readEntity(String.class);
		return res;
	}


	public String post(String content, String path){

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:9090").path("/cnr/sse/testhw/ditte/test"+path);

		Entity<String> entity = Entity.entity(content,MediaType.APPLICATION_JSON);

		Response response =  target.request().post(entity);

		String reply = response.readEntity(String.class);

		return reply;
		//FacesContext context = FacesContext.getCurrentInstance();
		//context.getExternalContext().getRequestMap().put("rest", id);

	}
	
	public void  Stringgson(String str){
		Gson gson = new Gson();
	//	System.out.println(gson.toJson(LMF);
		
		
		
	}

}
