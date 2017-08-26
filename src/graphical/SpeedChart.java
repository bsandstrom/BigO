package graphical;

import java.awt.Color;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class SpeedChart {
	ChartPanel chartPanel;
	
	public ChartPanel getChartPanel(){
		return this.chartPanel;
	}
	
	public SpeedChart(Map<Integer, Double> completionStats, String name){
		XYDataset dataset = this.createDataset(completionStats);
		JFreeChart chart = this.createChart(dataset, name);
		chartPanel = new ChartPanel(chart);
	}
	
	public XYDataset createDataset(Map<Integer, Double> completionStats){
		final XYSeries series = new XYSeries("Test");
		
		Iterator<Entry<Integer, Double>> it = completionStats.entrySet().iterator();
		
		while(it.hasNext()){
			Entry<Integer,Double> e = it.next();
			series.add(new XYDataItem(e.getKey(), e.getValue()));
		}
		final XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		return dataset;
	}
	
private JFreeChart createChart(final XYDataset dataset, String name) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createXYLineChart(
            name,      // chart title
            "Input(N)",                      // x axis label
            "Time",                      // y axis label
            dataset,                  // data
            PlotOrientation.VERTICAL,
            true,                     // include legend
            true,                     // tooltips
            false                     // urls
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        chart.setBackgroundPaint(Color.white);
        // final StandardLegend legend = (StandardLegend) chart.getLegend();
        // legend.setDisplaySeriesShapes(true);
        
        // get a reference to the plot for further customisation...
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
        // plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        
        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, false);
        renderer.setSeriesShapesVisible(1, false);
        plot.setRenderer(renderer);

        // OPTIONAL CUSTOMISATION COMPLETED.
                
        return chart;
        
    }
}
