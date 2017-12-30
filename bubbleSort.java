package hw2_q2;

import java.util.Scanner;

//bubbleSort.java
//demonstrates bubble sort
//to run this program: C>java BubbleSortApp
////////////////////////////////////////////////////////////////
class ArrayBub {
	private long[] a; // ref to array a
	private int nElems; // number of data items
	// --------------------------------------------------------------

	public ArrayBub(int max) // constructor
	{
		a = new long[max]; // create the array
		nElems = 0; // no items yet
	}

	// --------------------------------------------------------------
	public void insert(long value) // put element into array
	{
		a[nElems] = value; // insert it
		nElems++; // increment size
	}

	// --------------------------------------------------------------
	public void display() // displays array contents
	{
		for (int j = 0; j < nElems; j++) // for each element,
			System.out.print(a[j] + " "); // display it
		System.out.println(" ");
	}

	// --------------------------------------------------------------
	// public void bubbleSort() {
	// int out, in;
	// for (out = nElems - 1; out > 1; out--) // outer loop (backward)
	// for (in = 0; in < out; in++) // inner loop (forward)
	// if (a[in] > a[in + 1]) // out of order?
	// swap(in, in + 1); // swap them
	// } // end bubbleSort()
	// --------------------------------------------------------------
	public void oddEvenSort() {
		int j = 0;
		while (!isArrSorted()) { //continue odd-even comparisons until the array is sorted
			j = (j==0) ? 1 : 0;   //alternatively start with odd or even indices
			for (int i = j; i < nElems-1; i += 2) {
				if (a[i] >= a[i + 1])
					swap(i, i + 1);
			}
		}
	}
	
	private boolean isArrSorted() //to check if the array has been sorted
	{
		for (int i = 0; i < nElems-1; i++) 
		{
	        if (a[i] > a[i + 1]) 
	        {
	            return false; 
	        }
	    }

	    return true;
	}

	private void swap(int one, int two) {
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
	// --------------------------------------------------------------
} // end class ArrayBub
	////////////////////////////////////////////////////////////////

class BubbleSortApp {
	public static void main(String[] args) {
		int maxSize = 100; // array size
		ArrayBub arr; // reference to array
		arr = new ArrayBub(maxSize); // create the array
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the number of elements in the array : ");
		int n=sc.nextInt();
		System.out.println("Enter the elements : ");
		for(int i=0;i<n;i++)
			arr.insert(sc.nextLong());
		System.out.println("The entered array is : ");
		arr.display(); // display items
		arr.oddEvenSort(); //perform odd even sort
		System.out.println("The sorted array is : ");
		arr.display(); // display them again
		sc.close();
	} // end main()
} // end class BubbleSortApp