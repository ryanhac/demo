package acuk.corp.jsf.pagecode;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

@ManagedBean(name="chartView")
public class ChartView {

	private LineChartModel areaModel;
	 
	public ChartView(){
		System.out.println("constructor");
		createAreaModel();
	}
    public void init() {
    	System.out.println("init");
        createAreaModel();
    }
 
    public LineChartModel getAreaModel() {
    	System.out.println("getAreaModel");
        return areaModel;
    }
     
    private void createAreaModel() {
    	System.out.println("createAreaModel()");
        areaModel = new LineChartModel();
 
        LineChartSeries boys = new LineChartSeries();
        boys.setFill(true);
        boys.setLabel("Boys");
        boys.set("2004", 120);
        boys.set("2005", 100);
        boys.set("2006", 44);
        boys.set("2007", 150);
        boys.set("2008", 25);
 
        LineChartSeries girls = new LineChartSeries();
        girls.setFill(true);
        girls.setLabel("Girls");
        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 110);
        girls.set("2007", 90);
        girls.set("2008", 120);
 
        areaModel.addSeries(boys);
        areaModel.addSeries(girls);
         
        areaModel.setTitle("Area Chart");
        areaModel.setLegendPosition("ne");
        areaModel.setStacked(true);
        areaModel.setShowPointLabels(true);
         
        Axis xAxis = new CategoryAxis("Years");
        areaModel.getAxes().put(AxisType.X, xAxis);
        Axis yAxis = areaModel.getAxis(AxisType.Y);
        yAxis.setLabel("Births");
        yAxis.setMin(0);
        yAxis.setMax(300);
    }
}
