package hw4_q1;

class NormalQueue 
{
	public NormalQueue nextNodeRef;
	public int data;
	
	public NormalQueue(int thisData) 
	{
		data = thisData;
	}

	public void showLinkData() 
	{
		System.out.print(data + " ");
	}
}

class SortedList 
{
	private NormalQueue element1;

	//getter 
	public int getElement1() {
		return element1.data;
	}
	public SortedList()
	{
		element1 = null;
	}

	public void insertElement(int dat) 
	{
		NormalQueue previous = null,current = element1,nextNode = new NormalQueue(dat);

		while (current!=null && dat>current.data) 
		{
			previous = current;
			current = current.nextNodeRef;
		}
		
		if (previous == null)
		{
			element1 = nextNode ;
		}
		else
		{
			previous.nextNodeRef = nextNode ;
		}
		nextNode.nextNodeRef = current;
	}

	public NormalQueue removeElement() 
	{
		NormalQueue temp = element1;
		
		element1 = element1.nextNodeRef;
		
		return temp;
	}

	public void showList() 
	{
		System.out.print("the list is : ");
		
		NormalQueue current = element1;
		
		while (current != null) 
		{
			current.showLinkData();
			current = current.nextNodeRef;
		}
		System.out.println();
	}

	public boolean isEmpty() 
	{
		return (element1 == null);
	}
	
	
}

class MainClass {
	SortedList myQueList;

	public MainClass() 
	{
		myQueList = new SortedList();
	}

	public void insert(int val) 
	{
		myQueList.insertElement(val);
	}

	public NormalQueue removeSmallest() 
	{
		if (myQueList.isEmpty()) 
		{
			System.out.println("empty queue");
		
			return null;
		}
		return myQueList.removeElement();
	}

	public int peekMin() {
		return myQueList.getElement1();
	}

	public boolean isEmpty() {
		return myQueList.isEmpty();
	}

	public void display() {
		myQueList.showList();
	}
}

class PQ {
	public static void main(String[] args) {
		MainClass sampleQ = new MainClass();
		
		sampleQ.insert(4);
		sampleQ.insert(9);
		sampleQ.insert(67);
		
		int min = sampleQ.peekMin();
		
		System.out.println("the min is " + min);

		sampleQ.removeSmallest();
		sampleQ.removeSmallest();
		sampleQ.display();

		sampleQ.insert(8);
		sampleQ.insert(785);
		sampleQ.insert(16);
		sampleQ.insert(17);
		sampleQ.display();

		NormalQueue small = sampleQ.removeSmallest();
		
		System.out.println("the first smalleest is :"+small.data);

		small = sampleQ.removeSmallest();
		
		System.out.println("the second smallest is : "+small.data);

		
	}
}
