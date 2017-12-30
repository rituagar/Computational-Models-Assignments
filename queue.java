package hw3_q1;

import java.util.Scanner;

//queue.java
//demonstrates queue
//to run this program: C>java QueueApp
////////////////////////////////////////////////////////////////
class Queue {
	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;
	private int nItems;

	// --------------------------------------------------------------
	public Queue(int s) // constructor
	{
		maxSize = s;
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	// --------------------------------------------------------------
	public void insert(long j) // put item at rear of queue
	{
		if (rear == maxSize - 1) // deal with wraparound
			rear = -1;
		queArray[++rear] = j; // increment rear and insert
		nItems++; // one more item
	}

	// --------------------------------------------------------------
	public long remove() // take item from front of queue
	{
		long temp = queArray[front++]; // get value and incr front
		if (front == maxSize) // deal with wraparound
			front = 0;
		nItems--; // one less item
		return temp;
	}

	// --------------------------------------------------------------
	public long peekFront() // peek at front of queue
	{
		return queArray[front];
	}

	// --------------------------------------------------------------
	public boolean isEmpty() // true if queue is empty
	{
		return (nItems == 0);
	}

	// --------------------------------------------------------------
	public boolean isFull() // true if queue is full
	{
		return (nItems == maxSize);
	}

	// --------------------------------------------------------------
	public int size() // number of items in queue
	{
		return nItems;
	}

	// --------------------------------------------------------------
	public void displayQueue() {
		int n = front;

		if (this.isEmpty()) {
			System.out.println("no elements in the queue");
		} else {
			for (int i = 0; i < size(); i++) {
				System.out.print(queArray[n] + " ");
				n++;
				if (n == size()) {
					n = 0;
				} else if (n == front)
					break;
			}
		}
	}
} // end class Queue
	////////////////////////////////////////////////////////////////

class QueueApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements in the queue : ");
		int n = sc.nextInt();
		Queue theQueue = new Queue(n); // queue holds 5 items
		if (n == 0)
			System.out.println("Queue is empty");
		else {
			System.out.println("Enter the elements : ");
			for (int i = 0; i < n; i++)
				theQueue.insert(sc.nextLong());
			System.out.println("removing 2 elements from front and inserting 6 and 7");
			
			theQueue.remove(); // removing 2 elements
			theQueue.remove();
			theQueue.insert(6);// adding 2 elements in wrap around
			theQueue.insert(7);
			System.out.println("The queue is : ");
			theQueue.displayQueue();
		}
		sc.close();
	} // end main()
} // end class QueueApp