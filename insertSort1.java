package hw2_q3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
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
		int noOfDups = 0;
		for (out = 1; out < nElems; out++) // out is dividing line
		{
			long temp = a[out]; // remove marked item
			in = out; // start shifts at out
			while (in > 0 && a[in - 1] >= temp) // until one is smaller,
			{
				if(a[in-1] == temp)    //checking for duplicates and making them -1
				{
					temp = -1;
				}
				a[in] = a[in - 1]; // shift item to right
				--in; // go left one position
			}
			a[in] = temp; // insert marked item
			
			if(a[in]==-1) //keeping a track of the number of duplicates
				noOfDups++;
		} // end for
		
		
		for(int i = 0,j=noOfDups ; i < nElems ; i++,j++) //left shifting the array to remove all the -1s 
		{
			a[i] = a[j];
		}
		nElems-=noOfDups; //resizing the array
		
	} // end insertionSort()
		// --------------------------------------------------------------
} // end class ArrayIns
	////////////////////////////////////////////////////////////////

class InsertSortApp {
	public static void main(String[] args) {
		int maxSize = 100; // array size
		ArrayIns arr; // reference to array
		Scanner sc= new Scanner(System.in);
		arr = new ArrayIns(maxSize); // create the array
		System.out.println("Enter the number of elements in the array : ");
		int n=sc.nextInt();
		System.out.println("Enter the elements : ");
		for(int i=0;i<n;i++)
			arr.insert(sc.nextLong());
		System.out.println("The entered array is : ");
		arr.display(); // display items
		arr.insertionSort(); // insertion-sort them
		System.out.println("The sorted array without duplicates is : ");
		arr.display(); // display them again
		sc.close();
	} // end main()
} // end class InsertSortApp
	////////////////////////////////////////////////////////////////
