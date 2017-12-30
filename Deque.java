package hw4_q2;


class DoublyLinkedList {
	private Deque front;
	private Deque back;

	public DoublyLinkedList() {
		front = null;
		back = null;
	}

	
	public void insertFirst(int val)
	{
		Deque newLink = new Deque(val);

		if (isEmpty())
			back = newLink;
		else
			front.previous = newLink;
		
		newLink.next = front;
		
		front = newLink;
	}

	public void insertLast(int val)
	{
		Deque newLink = new Deque(val);

		if (isEmpty())
			front = newLink;
		else {
			back.next = newLink;
			newLink.previous = back;
		}
		back = newLink;
	}

	public Deque deleteFirst() 
	{
		Deque temp = front;
		
		if (front.next == null)
			back = null;
		else
			front.next.previous = null;
		
		front = front.next;
		
		return temp;
	}

	public Deque deleteLast() 
	{
		Deque temp = back;
		if (back.previous == null)
			front = null;
		else
			back.previous.next = null;
		
		back = back.previous;
		
		return temp;
	}

	public boolean insertAfter(int key, int val)
	{
		Deque current = front;
		while (current.data != key)
		{
			current = current.next;
			if (current == null)
				return false;
		}
		Deque newLink = new Deque(val);

		if (current == back)
		{
			newLink.next = null;
			back = newLink;
		} else {
			newLink.next = current.next;
			current.next.previous = newLink;
		}
		current.next = newLink;
		newLink.previous = current;
		return true;
	}

	public Deque deleteKey(long value) {
		Deque current = front;
		while (current.data != value) {
			current = current.next;
			if (current == null) {
				System.out.println("Couldn't find " + value + ".");
				return null;
			}

		}
		if (current == front)
			front = current.next;
		else
			current.previous.next = current.next;
		if (current == back)
			back = current.previous;
		else
			current.next.previous = current.previous;
		return current;
	}

	public void displayForward() 
	{
		Deque current = front;
		System.out.print("List is: ");
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public void displayBackward()
	{
		Deque current = back;
		System.out.print("List is : ");
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.previous;
		}
		System.out.println();
	}
	
	public boolean isEmpty() {
		return (front == null);
	}

	public Deque peekFirst() {
		return front;
	}

	public Deque peekLast() {
		return back;
	}

}

class DequeLinkedList 
{
	private DoublyLinkedList list;

	public DequeLinkedList() {
		list = new DoublyLinkedList();
	}

	
	public void insertLeft(int value) {
		list.insertFirst(value);
	}

	public long removeLeft() {
		return list.deleteFirst().data;
	}

	public void insertRight(int value) {
		list.insertLast(value);
	}

	public long removeRight() {
		return list.deleteLast().data;
	}

	public void display()
	{
		list.displayForward();
	}
	public long peekLeft() 
	{
		return list.peekFirst().data;
	}

	public long peekRight() {
		return list.peekLast().data;
	}

	public boolean isEmpty()
	{
		return list.isEmpty();
	}

	
}

class DoublyLinkedListApp
{
	public static void main(String[] args)
	{
		DequeLinkedList deque = new DequeLinkedList();
		
		deque.insertLeft(1);
		deque.insertLeft(2);
		
		deque.insertRight(4);
		
		deque.insertRight(6);
		deque.display();

		System.out.println("left peek: " + deque.peekLeft());

		deque.removeLeft();
		System.out.println("left peek after removing: " + deque.peekLeft());

		System.out.println("modifying the list by removing right twice and inserting right once : ");
		deque.removeRight();
		
		deque.removeRight();
		
		deque.insertRight(555);
		
		deque.display();
	}
}
public class Deque 
{
	public int data;
	public Deque next;
	public Deque previous;

	public Deque(int val) {
		data = val;
	}

	public void showLink() 
	{
		System.out.print(data+" ");
	}
}
