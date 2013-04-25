/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package streamfish;


/**
 *
 * @author NorC
 */

import java.util.ArrayList;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;


public class PieChart1 extends JFrame {

  private static final long serialVersionUID = 1L;
  private GUI gui;
  private ArrayList<String[]> tab;

  public PieChart1(String applicationTitle, String chartTitle, GUI gui, ArrayList<String[]> tab) {
        super(applicationTitle);
        this.gui = gui;
        this.tab = tab;
        // This will create the dataset 
        PieDataset dataset = createDataset();
        // based on the dataset we create the chart
        JFreeChart chart = createChart(dataset, chartTitle);
        // we put the chart into a panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // default size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        // add it to our application
        setContentPane(chartPanel);

    }
    
    
/**
     * Creates a sample dataset 
     */

    public PieDataset createDataset() {
        DefaultPieDataset result = new DefaultPieDataset();
        for (String[] s : tab) {
            int sold = Integer.parseInt(s[0]);
            String menuName = s[1];
            result.setValue(menuName, sold);
        }
        return result;
        
    }
    
    
/**
     * Creates a chart
     */

    private JFreeChart createChart(PieDataset dataset, String title) {
        
        JFreeChart chart = ChartFactory.createPieChart3D(title,          // chart title
            dataset,                // data
            true,                   // include legend
            true,
            false);

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return chart;
        
    }
} 
