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
		
		/*step 1 -
		*initialization of size 50 array(x,y) values for each sorting algo
		*/
		double[] selectionX=new double[50];
		double[] selectionY=new double[50];
		int selectionIndex = 0;

		double[] bubbleX=new double[50];
		double[] bubbleY=new double[50];
		int bubbleIndex = 0;

		double[] insertionX=new double[50];
		double[] insertionY=new double[50];
		int insertionIndex = 0;

		/*Step 2 -
		*A for loop int (n=1000;n<50000;n=n+1000)
		*to run 1000 increased values 50 times
		*/
		for(int n=1000;n<=50000;n=n+1000) {
			
			//Insertion Sort Analysis part-----------------------------------------
			
			/*Step 3 for Insertion Sort-
			 *filling array via ascending/descending method with n elements;
			 *where n(array size) is defined different in each for loop iteration.
			 *initially it's 1000, in last iteration it will be 50000.
			 */
			//int[] insertionarray = arrayAscendFill(n);		//Best Case Scenario
			int[] insertionarray = arrayDescendFill(n);	//Wost case scenario
			
			/*Step 4 for Insertion Sort-
			 *Initializing a date to find system time 'before' calling sorting algo
			*/
			java.util.Date insertionDate1 = new java.util.Date();
			Timestamp insertionTimestamp1 = new Timestamp(insertionDate1.getTime());		
			
			/*Step 5 for Insertion Sort-
			 *passing array to our sorting algo for sorting function
			*/
			insertionSort(insertionarray);
			
			/*Step 6 for Insertion Sort-
			 *Initializing a date to find system time 'after' calling sorting algo
			*/
			java.util.Date insertionDate2 = new java.util.Date();
			Timestamp insertionTimestamp2 = new Timestamp(insertionDate2.getTime());
			
			/*Step 7 for Insertion Sort-
			 *Finiding both time difference
			*/
			long insertionMilliseconds = insertionTimestamp2.getTime() - insertionTimestamp1.getTime();	
			
			/*Step 8 for Insertion Sort-
			 *storing n(array size) value in earlier initialized 50 size arr at place 0 for X axis
			 *storing time difference(in miliseconds) value in earlier initialized 50 size arr at place 0 for Y axis
			*/
			insertionX[insertionIndex]=n;
			insertionY[insertionIndex]=insertionMilliseconds;
			
			System.out.println("Insertion(Size_X"+(insertionIndex+1)+",Time_Y"+(insertionIndex+1)+")-"+"("+insertionX[insertionIndex]+","+insertionY[insertionIndex]+")");
			insertionIndex++;
			//--------------------------------------------------------------------------
			
			//Doing Step 3 to 8 for Selection Sort Below
			//Selection Sort Analysis---------------------------------------------------
			//int[] selectionarray = arrayAscendFill(n);		//Best Case Scenario
			int[] selectionarray = arrayDescendFill(n);	//Wost case scenario
			
			java.util.Date selectionDate1 = new java.util.Date();
			Timestamp selectionTimestamp1 = new Timestamp(selectionDate1.getTime());		
			
			selectionSort(selectionarray);
			
			java.util.Date selectionDate2 = new java.util.Date();
			Timestamp selectionTimestamp2 = new Timestamp(selectionDate2.getTime());
			
			long selectionMilliseconds = selectionTimestamp2.getTime() - selectionTimestamp1.getTime();			
			selectionX[selectionIndex]=n;
			selectionY[selectionIndex]=selectionMilliseconds;
			
			System.out.println("Selection(Size_X"+(selectionIndex+1)+",Time_Y"+(selectionIndex+1)+")-"+"("+selectionX[selectionIndex]+","+selectionY[selectionIndex]+")");
			selectionIndex++;
			//--------------------------------------------------------------------------
			
			//Doing Step 3 to 8 for Bubble Sort Below
			//Bubble Sort Analysis------------------------------------------------------
			//int[] bubblearray = arrayAscendFill(n);		//Best Case Scenario
			int[] bubblearray = arrayDescendFill(n);	//Wost case scenario
			
			java.util.Date bubbleDate1 = new java.util.Date();
			Timestamp bubbleTimestamp1 = new Timestamp(bubbleDate1.getTime());		
			
			bubbleSort(bubblearray);
			
			java.util.Date bubbleDate2 = new java.util.Date();
			Timestamp bubbleTimestamp2 = new Timestamp(bubbleDate2.getTime());
			
			long bubbleMilliseconds = bubbleTimestamp2.getTime() - bubbleTimestamp1.getTime();			
			bubbleX[bubbleIndex]=n;
			bubbleY[bubbleIndex]=bubbleMilliseconds;
			
			System.out.println("Bubble(Size_X"+(bubbleIndex+1)+",Time_Y"+(bubbleIndex+1)+")-"+"("+bubbleX[bubbleIndex]+","+bubbleY[bubbleIndex]+")\n");
			bubbleIndex++;
			//--------------------------------------------------------------------------
			
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
			if(a[j]>a[j+1])
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
	    if(a[i]>a[j])
	     {
	      temp=a[i];
	      a[i]=a[j];
	      a[j]=temp;
	     }
	   }
	 }
	return a;
	}
	
	//will fill array in 1,2,3 format
	static int[]  arrayAscendFill(int n)
	{
	int[] a=new int[n];
	for(int i=0;i<a.length;i++)
		{
		 a[i]=i+1;
		}
	return a;
	}

	//will fill array in 3,2,1 format
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