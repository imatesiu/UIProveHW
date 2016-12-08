package isti.cnr.sse;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.tuple.Pair;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BubbleChartModel;
import org.primefaces.model.chart.BubbleChartSeries;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;

import isti.cnr.sse.rest.data.SendRest;

@ManagedBean
@ViewScoped
public class Statistics {

	private BubbleChartModel bubbleModel;
	private BarChartModel barModel;
	private HorizontalBarChartModel horizontalBarModel;



	@PostConstruct
	public void init() {

		SendRest e = new SendRest();
		
		Pair<List<Pair<String, String>>,Map<String, Integer>> data = e.getStat();
		List<Pair<String, String>> ldittanumc = data.getLeft();
		Map<String, Integer> annoxncert = data.getRight();
		createBubbleModels(ldittanumc);
		createBarModels(annoxncert);
	}

	public BubbleChartModel getBubbleModel() {
		return bubbleModel;
	}


	private void createBubbleModels(List<Pair<String, String>> ldittanumc){
		bubbleModel = initBubbleModel(ldittanumc);
		bubbleModel.setTitle("Bubble Chart");
		//bubbleModel.getAxis(AxisType.X).setLabel("Price");
		Axis yAxis = bubbleModel.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(50);
		yAxis.setLabel("Numero di Certificazioni");


	}

	private BubbleChartModel initBubbleModel(List<Pair<String, String>> ldittanumc) {
		BubbleChartModel model = new BubbleChartModel();
		int x = 10;
		try{
			for(Pair<String, String> pair : ldittanumc){
				String nome = pair.getLeft();
				Integer num = Integer.getInteger(pair.getRight());
				model.add(new BubbleChartSeries(nome, x, num,num*10));
				x = x + 10 + (num*10);
			}
		}catch (Exception e) {

		}


		return model;
	}

	private BubbleChartModel initBubbleModel(){
		BubbleChartModel model = new BubbleChartModel();

		model.add(new BubbleChartSeries("Acura", 70, 183,55));
		model.add(new BubbleChartSeries("AP.esse", 45, 92, 36));
		model.add(new BubbleChartSeries("Olivetti", 24, 104, 40));
		model.add(new BubbleChartSeries("RCH", 50, 123, 60));
		model.add(new BubbleChartSeries("HP", 15, 89, 25));
		model.add(new BubbleChartSeries("Custom", 40, 180, 80));
		model.add(new BubbleChartSeries("Epson", 70, 70, 48));

		return model;
	}





	public BarChartModel getBarModel() {
		return barModel;
	}

	public HorizontalBarChartModel getHorizontalBarModel() {
		return horizontalBarModel;
	}

	private BarChartModel initBarModel() {
		BarChartModel model = new BarChartModel();

		ChartSeries boys = new ChartSeries();
		boys.setLabel("Misuratori Fiscali");
		boys.set("2004", 120);
		boys.set("2005", 100);
		boys.set("2006", 44);
		boys.set("2007", 150);
		boys.set("2008", 25);

		ChartSeries girls = new ChartSeries();
		girls.setLabel("Registratori Telematici");
		girls.set("2004", 52);
		girls.set("2005", 60);
		girls.set("2006", 110);
		girls.set("2007", 135);
		girls.set("2008", 120);

		model.addSeries(boys);
		model.addSeries(girls);

		return model;
	}

	private void createBarModels(Map<String, Integer> annoxncert) {
		createBarModel(annoxncert);
		createHorizontalBarModel();
	}

	private void createBarModel(Map<String, Integer> annoxncert) {
		barModel = initBarModel(annoxncert);

		barModel.setTitle("Bar Chart");
		barModel.setLegendPosition("ne");

		Axis xAxis = barModel.getAxis(AxisType.X);
		xAxis.setLabel("Anno");

		Axis yAxis = barModel.getAxis(AxisType.Y);
		yAxis.setLabel("Tipo Modello");
		yAxis.setMin(0);
		yAxis.setMax(200);
	}

	private BarChartModel initBarModel(Map<String, Integer> annoxncert) {
		BarChartModel model = new BarChartModel();

		ChartSeries boys = new ChartSeries();
		boys.setLabel("Misuratori Fiscali");
		for(String key :annoxncert.keySet()){
			boys.set(key, annoxncert.get(key));

		}



		model.addSeries(boys);


		return model;
	}

	private void createHorizontalBarModel() {
		horizontalBarModel = new HorizontalBarChartModel();

		ChartSeries boys = new ChartSeries();
		boys.setLabel("Misuratori Fiscali");
		boys.set("2004", 50);
		boys.set("2005", 96);
		boys.set("2006", 44);
		boys.set("2007", 55);
		boys.set("2008", 25);

		ChartSeries girls = new ChartSeries();
		girls.setLabel("Registratori Telematici");
		girls.set("2004", 52);
		girls.set("2005", 60);
		girls.set("2006", 82);
		girls.set("2007", 35);
		girls.set("2008", 120);

		horizontalBarModel.addSeries(boys);
		horizontalBarModel.addSeries(girls);

		horizontalBarModel.setTitle("Horizontal and Stacked");
		horizontalBarModel.setLegendPosition("e");
		horizontalBarModel.setStacked(true);

		Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
		xAxis.setLabel("Tipo Modello");
		xAxis.setMin(0);
		xAxis.setMax(200);

		Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
		yAxis.setLabel("Anno");        
	}

}
