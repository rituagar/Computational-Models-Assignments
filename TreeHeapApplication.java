import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class TreeHeapNode
{			
	public TreeHeapNode leftChild;
	boolean isLeftChild = false;
	public TreeHeapNode rightChild;
	public TreeHeapNode parent;
	public int iDat;
	
	public void showKey()
	{ 
		System.out.print(get() + " ");
	}
	
	public void set(int i) 
	{
		iDat = i;
	}
	
	public int get() 
	{
		return iDat;
	}
	
}

class TreeHeap
{
	private int numNodes;
	private TreeHeapNode treeHeapNodeRoot;
	
	
	public boolean isEmpty() 
	{
		return numNodes==0;
		
	}
	
	
	public TreeHeap()
	{
		numNodes = 0;
		treeHeapNodeRoot = new TreeHeapNode();
	}
	public void trickleUp(TreeHeapNode newNode)
	{
		int bottom = newNode.get();
		TreeHeapNode current = newNode;
		while( current.parent != null && current.parent.get() < bottom )
		{
			current.set(current.parent.get());
			current = current.parent;
		}
		current.set(bottom);
	}
	
	public void insert(int key)
	{
		TreeHeapNode newTreeNode = new TreeHeapNode();
		newTreeNode.set(key);
		if(numNodes == 0) treeHeapNodeRoot = newTreeNode;
		else
		{
			TreeHeapNode current = treeHeapNodeRoot;
			int n = numNodes+1;
			int k;
			int[] path = new int[n];
			int i = 0;
			
			while(n>=1)
			{
				path[i] = n % 2;
				n/=2;
				i++;
			}
			
			for(k = i-2; k > 0; k--)
			{
				if(path[k] == 1)
				{
					current = current.rightChild;
				}
				else
				{
					current = current.leftChild;
				}
			}
			
			if(current.leftChild != null)
			{
				current.rightChild = newTreeNode;
				newTreeNode.isLeftChild = false;
			}
			else
			{
				current.leftChild = newTreeNode;
				newTreeNode.isLeftChild = true;
			}
			
			newTreeNode.parent = current;
			
			trickleUp(newTreeNode);
		}
		numNodes++;
	}
	
	

	public TreeHeapNode remove()
	{
		TreeHeapNode removedNode = treeHeapNodeRoot;
		if(numNodes==0) return null;
		
		if(numNodes==1)
		{
			treeHeapNodeRoot = null;
			numNodes--;
			return removedNode;
		}
		
		TreeHeapNode current = treeHeapNodeRoot;
		int n = numNodes;
		int k;
		int[] path = new int[n];
		int j = 0;
		while(n >= 1)
		{
			path[j] = n % 2;
			n /= 2;
			j++;
		}
		
		for(k = j-2; k >= 0; k--)
		{
			if(path[k] == 1)
				current = current.rightChild;
			else
				current = current.leftChild;
		}
		treeHeapNodeRoot.set(current.get());
		
		if(current.isLeftChild)
		{
			current.parent.leftChild = null;
		}
		else
		{
			current.parent.rightChild = null;
		}
		
		trickleDown(treeHeapNodeRoot);				
		numNodes--;
		
		return removedNode;
	}
	
	
	public void trickleDown(TreeHeapNode newNode)
	{
		TreeHeapNode current = newNode;
		int top = newNode.get();
		TreeHeapNode largerChild;
		while(current.leftChild != null || current.rightChild != null) 
		{
			if(current.rightChild != null && current.leftChild.get() < current.rightChild.get() )
			{
				largerChild = current.rightChild;
			}
			else
			{
				largerChild = current.leftChild;
			}
			if(top >= largerChild.get() )
			{
				break;
			}
			
			current.set(largerChild.get());
			current = largerChild;
		}
		current.set(top);
	}
	
	public void display()
	{
		Stack<TreeHeapNode> globalStack = new Stack<TreeHeapNode>();
		globalStack.push(treeHeapNodeRoot);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println(".......................................................");
		
		while(isRowEmpty==false)
		{
			Stack<TreeHeapNode> localStack = new Stack<TreeHeapNode>();
			isRowEmpty = true;
			
			for(int j = 0; j < nBlanks; j++)
				System.out.print(" ");
			
			while(globalStack.isEmpty() == false)
			{
				TreeHeapNode temp = globalStack.pop();
				if(temp != null)
				{
					System.out.print(temp.iDat);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					
					if(temp.leftChild != null ||
							temp.rightChild != null)
						isRowEmpty = false;
				}
				else
				{
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for(int j = 0; j < nBlanks*2 - 2; j++)
					System.out.print(" ");
			} 
			System.out.println();
			nBlanks /= 2;
			while(localStack.isEmpty() == false)
				globalStack.push( localStack.pop() );
		} 
		System.out.println(".......................................................");
	} 
	public boolean change(int index, int newValue)
	{
		if(index<0 || index>numNodes)
			return false;
		
		TreeHeapNode current = treeHeapNodeRoot;
		int n = index;
		int k;
		int[] path = new int[n];
		int j = 0;
		while(n >= 1)
		{
			path[j] = n % 2;
			n /= 2;
			j++;
		}
		
		for(k = j-2; k >= 0; k--)
		{
			if(path[k] == 1)
				current = current.rightChild;
			else
				current = current.leftChild;
		}
		
		int oldValue = current.get();
		current.set(newValue);
		
		if(oldValue < newValue)
			trickleUp(current);
		else
			trickleDown(current);
		return true;
	}
	
	
} 

class TreeHeapApplication
{
	public static void main(String[] args) throws IOException
	{
		
		TreeHeap theTreeHeap = new TreeHeap();
		boolean success;
		int value1, value2;
		
		theTreeHeap.insert(70);
		theTreeHeap.insert(40);
		theTreeHeap.insert(50);
		theTreeHeap.insert(25);
		
		theTreeHeap.insert(66);
		theTreeHeap.insert(100);
		theTreeHeap.insert(80);
		
		theTreeHeap.insert(33);
		theTreeHeap.insert(10);
		theTreeHeap.insert(90);
		
		while(true)
		{
			System.out.print("Enter first letter of ");
			System.out.print("show, insert, remove, change: ");
			int choice = getChar();
			switch(choice)
			{
			case 's':
				
				theTreeHeap.display();
				break;
			case 'i':
				
				System.out.print("Enter value to insert: ");
				value1 = getInt();
				theTreeHeap.insert(value1);
				break;
			case 'r':
				
				if(!theTreeHeap.isEmpty())
					theTreeHeap.remove();
				else
					System.out.println("Can't remove; heap empty");
				break;
			case 'c':
				
				System.out.print("Enter current index of item: ");
				value1 = getInt();
				System.out.print("Enter new key: ");
				value2 = getInt();
				success = theTreeHeap.change(value1, value2);
				if(!success)
					System.out.println("Invalid index\n");
				break;
			default:
				System.out.println("Invalid entry!\n");
			} 
		} 
	} 
	
	public static char getChar() throws IOException
	{
		return getString().charAt(0);
	}
	
	public static String getString() throws IOException
	{
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);
		return br.readLine();
	}
	
	
	public static int getInt() throws IOException
	{
		return Integer.parseInt(getString());
	}
} 