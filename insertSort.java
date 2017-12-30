package hw2_q1;

import java.util.Scanner;

//insertSort.java
//demonstrates insertion sort
//to run this program: C>java InsertSortApp
//--------------------------------------------------------------
class ArrayIns {
	private long[] a; // ref to array a
	private int nElems; // number of data items
	// --------------------------------------------------------------

	public ArrayIns(int max) // constructor
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
	public void insertionSort() {
		int in, out;
		for (out = 1; out < nElems; out++) // out is dividing line
		{
			long temp = a[out]; // remove marked item
			in = out; // start shifts at out
			while (in > 0 && a[in - 1] >= temp) // until one is smaller,
			{
				a[in] = a[in - 1]; // shift item to right
				--in; // go left one position
			}
			a[in] = temp; // insert marked item
		} // end for
	} // end insertionSort()
		// --------------------------------------------------------------

	public void noDups() {   //to remove duplicates
		int uniqueElemIndex=0;      //unique element index
		for (int i=0; i < nElems-1; i++)
	    {
			if (a[i] != a[i+1])     
	            a[uniqueElemIndex++] = a[i];
	    }
	    a[uniqueElemIndex++] = a[nElems-1];	
	
		nElems = uniqueElemIndex; //resizing the array
	}
	
} // end class ArrayIns
	////////////////////////////////////////////////////////////////

class InsertSortApp {
	public static void main(String[] args) {
		int maxSize = 100; // array size
		ArrayIns arr; // reference to array
		arr = new ArrayIns(maxSize); // create the array
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements : ");
		int n=sc.nextInt();
		System.out.println("Enter the elements : ");
		for(int i=0;i<n;i++)
			arr.insert(sc.nextLong());
		System.out.println("The array is : ");
		arr.display(); // display items
		arr.insertionSort(); // insertion-sort them
		System.out.println("The sorted array is : ");
		arr.display(); // display them again
		arr.noDups();  
		System.out.println("The sorted array after removing duplicates : ");
		arr.display();
		sc.close();
		
	} // end main()
} // end class InsertSortApp
	////////////////////////////////////////////////////////////////
