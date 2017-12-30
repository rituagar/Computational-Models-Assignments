package hw3_q2;

import java.io.IOException;

//priorityQ.java
//demonstrates priority queue
//to run this program: C>java PriorityQApp
////////////////////////////////////////////////////////////////
class PriorityQ {
	// array in sorted order, from max at 0 to min at size-1
	private int maxSize;
	private long[] queArray;
	private int nItems;
	// -------------------------------------------------------------
	public PriorityQ(int s) // constructor
	{
		maxSize = s;
		queArray = new long[maxSize];
		nItems = 0;
	}
	// -------------------------------------------------------------
	public long removeNew() // remove minimum
	{
		for(int i=0;i<nItems-1;i++) //bring the minimum element at the end
		{
			if(queArray[i] < queArray[i+1])
			{
				long min = queArray[i];
				queArray[i] = queArray[i+1];
				queArray[i+1] = min;
			}
		}
		return queArray[--nItems];
	} 

	// --------------------------------------------------------------
	public void insertNew(long j) // insert item like in a regular queue 
	{
		if (nItems == maxSize)
			nItems = 0;
		queArray[nItems++] = j; // insert and increment

	}

	// -------------------------------------------------------------
	public long peekMin() // peek at minimum item
	{
		return queArray[nItems - 1];
	}

	// -------------------------------------------------------------
	public boolean isEmpty() // true if queue is empty
	{
		return (nItems == 0);
	}

	// -------------------------------------------------------------
	public boolean isFull() // true if queue is full
	{
		return (nItems == maxSize);
	}
	// -------------------------------------------------------------
} // end class PriorityQ
	////////////////////////////////////////////////////////////////

class PriorityQApp {
	public static void main(String[] args) throws IOException {
		PriorityQ thePQ = new PriorityQ(5);
		thePQ.insertNew(30);
		thePQ.insertNew(50);
		thePQ.insertNew(10);
		thePQ.insertNew(40);
		thePQ.insertNew(20);
		while (!thePQ.isEmpty()) {
			long item = thePQ.removeNew();
			System.out.print(item + " "); // 10, 20, 30, 40, 50
		} // end while
		System.out.println("");
	} // end main()
		// -------------------------------------------------------------
} // end class PriorityQApp