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


public class PieChart extends JFrame {

  private static final long serialVersionUID = 1L;
  private GUI gui;
  private ArrayList<String[]> tab;

  public PieChart(String applicationTitle, String chartTitle, GUI gui, ArrayList<String[]> tab) {
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
        chartPanel.setPreferredSize(new java.awt.Dimension(720, 480));
        // add it to our application
        setContentPane(chartPanel);
		this.pack();
		this.setVisible(true);

    }
    
    
/**
     * Creates a sample dataset 
     */

    public PieDataset createDataset() {
        DefaultPieDataset result = new DefaultPieDataset();
        for (String[] s : tab) {
            int sold = Integer.parseInt(s[1]);
            String menuName = s[0];
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
    
    public static void main(String[] args) {
        GUI gui = new GUI();
        ArrayList<String[]> tab = gui.getMenuSalesStats("2013-01-01", "2013-04-30", 5, true);
        PieChart pi = new PieChart("StreamFish™", "Top 5 selling menus for interval 2013-01-01 - 2013-04-30", gui, tab);
        PieDataset dataset = pi.createDataset();
        JFreeChart chart = pi.createChart(dataset, "title");
        pi.pack();
        pi.setVisible(true);
    }
} 
