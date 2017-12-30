package hw6_q1;

/*
public class Partition extends ArrayIns
{
	public Partition(int max)
	{
		super(max);
	}
	
	public int size() {return nElems;}
	
	public int partitionIt3(int left, int right)
	{
		int leftPtr = left - 1;
		int rightPtr = right;
		if(rightPtr - leftPtr <= 0)
		{
			System.out.println("Sub-array too small to sort");
			return -1;
		}
		long pivot = theArray[right];
		System.out.println("Pivot = " + pivot);
		
		
		while(true)
		{
			while(leftPtr < right && theArray[++leftPtr] < pivot)
				; //nop
			while(rightPtr > left && theArray[--rightPtr] > pivot)
				; //nop
			if(leftPtr >= rightPtr) break;
			else swap(leftPtr, rightPtr);
		}
		swap(leftPtr, right); //move pivot to partition
		return leftPtr;
	}
	
	public static void main(String[] args)
	{
		int maxSize = 51;
		Partition arr = new Partition(maxSize);
		for(int i = 0; i < maxSize; i++) arr.insert((long)(Math.random()*199));
		arr.display();
		arr.partitionIt3(0, maxSize-1);
		arr.display();
	}
}*/

class ArrayPar {
	private long[] theArray; // ref to array theArray
	private int nElems; // number of data items
	// --------------------------------------------------------------

	public ArrayPar(int max) // constructor
	{
		theArray = new long[max]; // create the array
		nElems = 0; // no items yet
	}

	// --------------------------------------------------------------
	public void insert(long value) // put element into array
	{
		theArray[nElems] = value; // insert it

		nElems++; // increment size
	}

	// --------------------------------------------------------------
	public int size() // return number of items
	{
		return nElems;
	}

	// --------------------------------------------------------------
	public void display() // displays array contents
	{
		System.out.print("A=");
		for (int j = 0; j < nElems; j++) // for each element,
			System.out.print(theArray[j] + " "); // display it
		System.out.println("");
	}

	// --------------------------------------------------------------
	public int partitionIt(int left, int right, long pivot) {
		int leftPtr = left - 1; // right of first elem
		int rightPtr = right + 1; // left of pivot
		while (true) {
			while (leftPtr < right && // find bigger item
					theArray[++leftPtr] < pivot)
				; // (nop)
			while (rightPtr > left && // find smaller item
					theArray[--rightPtr] > pivot)
				; // (nop)
			if (leftPtr >= rightPtr) // if pointers cross,
				break; // partition done
			else // not crossed, so
				swap(leftPtr, rightPtr); // swap elements
		} // end while(true)
		return leftPtr; // return partition
	} // end partitionIt()
		// --------------------------------------------------------------

	public int partitionIt2(int left, int right)
	{
		int leftPtr = left - 1;
		int rightPtr = right;
		if(rightPtr - leftPtr <= 0)
		{
			System.out.println("Sub-array too small to sort");
			return -1;
		}
		long pivot = theArray[right];
		System.out.println("Pivot = " + pivot);
		
		
		while(true)
		{
			while(leftPtr < right && theArray[++leftPtr] < pivot)
				; //nop
			while(rightPtr > left && theArray[--rightPtr] > pivot)
				; //nop
			if(leftPtr >= rightPtr) break;
			else swap(leftPtr, rightPtr);
		}
		swap(leftPtr, right); //move pivot to partition
		return leftPtr;
	}
	public void swap(int dex1, int dex2) // swap two elements
	{
		long temp;
		temp = theArray[dex1]; // A into temp
		theArray[dex1] = theArray[dex2]; // B into A
		theArray[dex2] = temp; // temp into B

	} // end swap()
		// --------------------------------------------------------------
} // end class ArrayPar
	////////////////////////////////////////////////////////////////

class PartitionApp {
	public static void main(String[] args) {
		int maxSize = 16; // array size
		ArrayPar arr; // reference to array
		arr = new ArrayPar(maxSize); // create the array
		for (int j = 0; j < maxSize; j++) // fill array with
		{ // random numbers
			long n = (int) (java.lang.Math.random() * 199);
			arr.insert(n);
		}
		arr.display(); // display unsorted array
		
		int size = arr.size();
		// partition array
		int partDex = arr.partitionIt2(0, size - 1);
		arr.display(); // display partitioned array
	}
}// end main()
