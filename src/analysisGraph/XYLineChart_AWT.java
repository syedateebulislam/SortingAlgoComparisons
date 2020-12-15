package analysisGraph;

import java.awt.Color; 
import java.awt.BasicStroke; 
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.xy.XYDataset; 
import org.jfree.data.xy.XYSeries; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 
import org.jfree.chart.plot.XYPlot; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.xy.XYSeriesCollection; 
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

public class XYLineChart_AWT extends ApplicationFrame {

   public XYLineChart_AWT( String applicationTitle, String chartTitle, double[] selectionX,double[] selectionY,double[] bubbleX,double[] bubbleY,double[] insertionX,double[] insertionY) {
      super(applicationTitle);
      JFreeChart xylineChart = ChartFactory.createXYLineChart(
         chartTitle ,
         "Number of Elements(array size)",
         "Time(in miliseconds)",
         createDataset(selectionX,selectionY,bubbleX,bubbleY,insertionX,insertionY) ,
         PlotOrientation.VERTICAL ,
         true , true , false);
         
      ChartPanel chartPanel = new ChartPanel( xylineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      final XYPlot plot = xylineChart.getXYPlot( );
      
      XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
      renderer.setSeriesPaint( 0 , Color.RED );
      renderer.setSeriesPaint( 1 , Color.GREEN );
      renderer.setSeriesPaint( 2 , Color.BLUE );
      renderer.setSeriesStroke( 0 , new BasicStroke( 3.0f ) );
      renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
      renderer.setSeriesStroke( 2 , new BasicStroke( 3.0f ) );
      plot.setRenderer( renderer ); 
      setContentPane( chartPanel ); 
   }
   
   public XYDataset createDataset(double[] selectionX,double[] selectionY,double[] bubbleX,double[] bubbleY,double[] insertionX,double[] insertionY) {
      final XYSeries selection = new XYSeries( "Selection Sort" );               
      for(int i=0;i<selectionX.length;i++) {
    	  selection.add( selectionX[i] , selectionY[i] );
      }
      
      final XYSeries bubble = new XYSeries( "Bubble Sort" );              
      for(int i=0;i<bubbleX.length;i++) {
    	  bubble.add( bubbleX[i] , bubbleY[i] );
      }
      
      final XYSeries insertion = new XYSeries( "Insertion Sort" );                   
      for(int i=0;i<insertionX.length;i++) {
    	  insertion.add( insertionX[i] , insertionY[i] );
      }
    
      final XYSeriesCollection dataset = new XYSeriesCollection( );          
      dataset.addSeries( selection );          
      dataset.addSeries( bubble );
      dataset.addSeries( insertion );  
      return dataset;
   }
   
   public static void createGraph(double[] selectionX,double[] selectionY,double[] bubbleX,double[] bubbleY,double[] insertionX,double[] insertionY) {
	   XYLineChart_AWT chart = new XYLineChart_AWT("Algorithms analysis window",
		         "Sorting Algorithms comparison(Worst Case Scenario)",selectionX,selectionY,bubbleX,bubbleY,insertionX,insertionY);
		      chart.pack( );     //change second argument string here for best case scenario graph heading     
		      RefineryUtilities.centerFrameOnScreen( chart );          
		      chart.setVisible( true );
   }
}