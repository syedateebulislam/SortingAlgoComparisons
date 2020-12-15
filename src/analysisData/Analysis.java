package analysisData;

import java.sql.Timestamp;
import analysisGraph.XYLineChart_AWT;

public class Analysis {
	public static void main(String[] args) {
		System.out.println("Analysis start ---");
		Analysis();		
		System.out.println("Analysis ends ---");
	}
	
	public static void Analysis() {
		double[] selectionX=new double[50];
		double[] selectionY=new double[50];
		int selectionIndex = 0;
		
		double[] bubbleX=new double[50];
		double[] bubbleY=new double[50];
		int bubbleIndex = 0;

		double[] insertionX=new double[50];
		double[] insertionY=new double[50];
		int insertionIndex = 0;

		for(int n=1000;n<50000;n=n+1000) {
			//Insertion Sort Analysis
			int[] insertionarray = arrayDescendFill(n);
//			int[] insertionarray = arrayAscendFill(n);	//Uncomment this and comment upper line to apply Best Case Scenario
			java.util.Date insertionDate1 = new java.util.Date();
			Timestamp insertionTimestamp1 = new Timestamp(insertionDate1.getTime());		
			insertionSort(insertionarray);
			java.util.Date insertionDate2 = new java.util.Date();
			Timestamp insertionTimestamp2 = new Timestamp(insertionDate2.getTime());
			long insertionMilliseconds = insertionTimestamp2.getTime() - insertionTimestamp1.getTime();			
			insertionX[insertionIndex]=n;
			insertionY[insertionIndex]=insertionMilliseconds;
			System.out.println("Insertion(X"+insertionIndex+",Y"+insertionIndex+")-"+"("+insertionX[insertionIndex]+","+insertionY[insertionIndex]+")");
			insertionIndex++;
			
			//Selection Sort Analysis
			int[] selectionarray = arrayAscendFill(n);
//			int[] selectionarray = arrayDescendFill(n);		//Uncomment this and comment upper line to apply Best Case Scenario
			java.util.Date selectionDate1 = new java.util.Date();
			Timestamp selectionTimestamp1 = new Timestamp(selectionDate1.getTime());		
			selectionSort(selectionarray);
			java.util.Date selectionDate2 = new java.util.Date();
			Timestamp selectionTimestamp2 = new Timestamp(selectionDate2.getTime());
			long selectionMilliseconds = selectionTimestamp2.getTime() - selectionTimestamp1.getTime();			
			selectionX[selectionIndex]=n;
			selectionY[selectionIndex]=selectionMilliseconds;
			System.out.println("Selection(X"+selectionIndex+",Y"+selectionIndex+")-"+"("+selectionX[selectionIndex]+","+selectionY[selectionIndex]+")");
			selectionIndex++;
				
			//Bubble Sort Analysis
			int[] bubblearray = arrayAscendFill(n);
//			int[] bubblearray = arrayDescendFill(n);	//Uncomment this and comment upper line to apply Best Case Scenario
			java.util.Date bubbleDate1 = new java.util.Date();
			Timestamp bubbleTimestamp1 = new Timestamp(bubbleDate1.getTime());		
			bubbleSort(bubblearray);
			java.util.Date bubbleDate2 = new java.util.Date();
			Timestamp bubbleTimestamp2 = new Timestamp(bubbleDate2.getTime());
			long bubbleMilliseconds = bubbleTimestamp2.getTime() - bubbleTimestamp1.getTime();			
			bubbleX[bubbleIndex]=n;
			bubbleY[bubbleIndex]=bubbleMilliseconds;
			System.out.println("Bubble(X"+bubbleIndex+",Y"+bubbleIndex+")-"+"("+bubbleX[bubbleIndex]+","+bubbleY[bubbleIndex]+")\n");
			bubbleIndex++;
		}	
		XYLineChart_AWT.createGraph(selectionX,selectionY,bubbleX,bubbleY,insertionX,insertionY);
	}

	static int[] insertionSort(int[] a)
	{
	int i=0;
	int j=0;
	int k=0;
	int n=a.length;	
	 for(j=1;j<n;j++)
	 {
		k=a[j];
		i=j-1;	
		while(i>=0&&a[i]>k)
		{
			a[i+1]=a[i];
			i=i-1;
		}
		a[i+1]=k;
	 }
	return a;
	}

	static int[] bubbleSort(int[] a)
	{
	int i=0;
	int j=0;
	int n=a.length;
	int temp=0;
		for(i=0;i<n;i++)
		{
		 for(j=0;j<(n-1);j++)
		   {
			if(a[j]<a[j+1])
			 {
			  temp=a[j];
			  a[j]=a[j+1];
			  a[j+1]=temp;
			 }
		   }
		}
		return a;
	}
	
	static int[] selectionSort(int[] a)
	{
	int temp=0;
	int n=a.length;
	for(int i=0;i<n-1;i++)
	 {
	  for(int j=i+1;j<n;j++)
	   {
	    if(a[i]<a[j])
	     {
	      temp=a[i];
	      a[i]=a[j];
	      a[j]=temp;
	     }
	   }
	 }
	return a;
	}
	
	static int[]  arrayAscendFill(int n)
	{
	int[] a=new int[n];
	for(int i=0;i<a.length;i++)
		{
		 a[i]=i+1;
		}
	return a;
	}
	
	static int[]  arrayDescendFill(int n)
	{
	int[] a=new int[n];
	int j=1;
	for(int i=n;i>0;i--)
		{
			a[i-1]=j;
			j++;
			if(j>n) {
				break;
			} 
		}
	return a;
	}
}