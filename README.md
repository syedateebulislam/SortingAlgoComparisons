# SortingAlgoComparisons
Time Complexity comparison of Insertion, Selection &amp; Bubble sort using JFreeChart AWT output graph

The time complexity in Worst Case Scenario of all three algorithms is O(n^2), but as the size of input data increases, insertion sort performs far better than bubble sort and slightly better than selection sort.

To Implement Worst case, i provided each algorithm an array of size n in reverse order.
If algorith is tend to sort the element in ascending order, then the given array is filled in descending order.

Also as we know, The time complexity in Best Case Scenario of bubble and selection sort algorithms is O(n^2), but for insertion sort algorithm it is O(n).
We can verify the adaptive nature of insertion sort.When data sets that are substantially sorted: The time complexity is O(n+d), where d is the number of inversions. 
It can be verified from Best Case Scenario graph.

To Implement Best case, i provided each algorithm an array of size n in already sorted order.
If algorith is tend to sort the element in ascending order, then the given array is already filled in ascending order.

Now comes the question that how to plot a graph using JFreeChart?
For that, we will be using a very simple utility called JFreeChart.
JFreeChart is a free 100% Java chart library that makes it easy for developers to display professional quality charts in their applications.

Note:In this comparison, x-y line chart AWT output approach is used.
Using JFreeChart we can also generate the same graph in .jpg format image.

1.	Setup JFreeChart-
Download the latest version of JFreeChart.zip from the link http://www.jfree.org/jfreechart/download/ 
Unzip the downloaded file at any location from where required libraries can be linked into your Java program.

2.	Add below jars in your java project Build Path- 
jfreechart-1.0.1\lib\jcommon-1.0.0.jar
jfreechart-1.0.1\lib\jfreechart-1.0.jar

Now All set!! Just run the analysis class and see the incrementally generated (x,y) co-ordinates for each algorithm.
In our case x is Array Size, & y is the time taken by that respective algorithm.

By default code will generate Worst case scenario graph, for Best case scenario comparison follow the comments mentioned in the code.
