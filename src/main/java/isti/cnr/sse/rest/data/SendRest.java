package isti.cnr.sse.rest.data;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.tuple.Pair;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SendRest {


	public List<Ditta> getDitte(String type){

		String result = sendGet("/ditte/"+type);
		Gson g = new Gson();
		Ditte d  = new Ditte();
		d = g.fromJson(result, Ditte.class);
		return d.getListaDitte();
	}
	
	public Pair<List<Pair<String, String>>,Map<String, Integer>> getStat(){
		Type listType = new TypeToken<Pair<List<Pair<String, String>>,Map<String, Integer>>>(){}.getType();
		String result = sendGet("/stat/");
		Gson g = new Gson();
		
		Pair<List<Pair<String, String>>,Map<String, Integer>> d = g.fromJson(result, listType);
		return d;
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
		WebTarget target = client.target("http://localhost:9090").path("/cnr/sse/testhw"+path);

		Entity<String> entity = Entity.entity(content,MediaType.APPLICATION_JSON);

		Response response =  target.request().post(entity);

		String reply = response.readEntity(String.class);

		return reply;
		//FacesContext context = FacesContext.getCurrentInstance();
		//context.getExternalContext().getRequestMap().put("rest", id);

	}


	public String saveNewDitta(Ditta d){
		try{
			Gson g = new Gson();
			String res = post(g.toJson(d),"/ditta/");
			if(res.equals("OK")){
				return "Data saved";
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "Problem data unsaved";
	}

	public String saveNewModello(ModelloMF MF){		
		try{
			Gson g = new Gson();
			String res = post(g.toJson(MF),"/modello/");
			if(res.equals("OK")){
				return "Data saved";
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "Problem data unsaved";
	}


	/*public void  Stringgson(String str){
		Gson gson = new Gson();
		//	System.out.println(gson.toJson(LMF);



	}*/

	public List<SelectItem> getSelectedItemDitte() {
		String result = sendGet("/dittestring");
		Type listType = new TypeToken<ArrayList<String>>(){}.getType();
		Gson g = new Gson();
		List<String> le = g.fromJson(result, listType);
		List<SelectItem> e = new ArrayList<>();
		for (String se : le) {
			e.add(new SelectItem(se, se));
		}
		return e;
	}

	public String updateProvaHW(Prova prova) {
		try{
			Gson g = new Gson();
			String res = post(g.toJson(prova),"/provaupdated/");
			if(res.equals("OK")){
				return "Data saved";
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "Problem data unsaved";
	}

}
