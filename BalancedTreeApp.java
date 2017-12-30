package hw7_q2;

import java.io.*;
import java.util.*;

class AbcNode 
{
	public String sData; 
	public AbcNode leftChild;
	public AbcNode rightChild;
	public void displayNode() 
	{
		System.out.print("{"+sData+"}");
	}
}

class BalancedTree 
{
	private AbcNode root;
	public BalancedTree(String initStr) 
	{
		root = null;
		int nElems = 0;
		AbcNode[] nodeArray = new AbcNode[initStr.length()];
		for (int i = 0; i < initStr.length(); i++) 
		{
			nodeArray[i] = new AbcNode();
			nodeArray[i].sData = String.valueOf(initStr.charAt(i));
			nElems++;
		}

		while (nElems > 1) 
		{
			int fillCount = 0;
			for (int i = 0; i < nElems; i++) 
			{
				if (i % 2 == 1) 
				{
					AbcNode tmpNode = new AbcNode();
					tmpNode.sData = "+";
					tmpNode.leftChild = nodeArray[i - 1];
					tmpNode.rightChild = nodeArray[i];
					nodeArray[fillCount] = tmpNode;
					fillCount++;
				}
				if (i % 2 == 0 && i == nElems - 1) 
				{
					nodeArray[fillCount] = nodeArray[i];
				}
			}
			
			nElems -= fillCount;
		}
		root = nodeArray[0];
	}

	public void traverse(int traverseType) 
	{
		switch (traverseType) 
		{
		case 1:
			System.out.print("\nPreorder traversal : ");
			preOrder(root);
			break;
		case 2:
			System.out.print("\nInorder traversal : ");
			inOrder(root);
			break;
		case 3:
			System.out.print("\nPostorder traversal : ");
			postOrder(root);
			break;
		}
		System.out.println("");
	}

	private void preOrder(AbcNode lclRoot) 
	{
		if (lclRoot != null) 
		{
			System.out.print(lclRoot.sData + " ");
			preOrder(lclRoot.leftChild);
			preOrder(lclRoot.rightChild);
		}
	}

	private void inOrder(AbcNode localRoot) 
	{
		if (localRoot != null) {
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.sData + " ");
			inOrder(localRoot.rightChild);
		}
	}

	private void postOrder(AbcNode localRoot) 
	{
		if (localRoot != null) {
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.print(localRoot.sData + " ");
		}
	}

	public void displayTree() 
	{
		Stack<AbcNode> globalStack = new Stack<AbcNode>();
		globalStack.push(root);
		int nBlnks = 32;
		boolean isRowEmpty = false;
		System.out.println(".......................................................");
		
		while (isRowEmpty == false) 
		{
			Stack<AbcNode> localStk = new Stack<AbcNode>();
			isRowEmpty = true;

			for (int i = 0; i < nBlnks; i++)
			{
				System.out.print(" ");
			}
			while (globalStack.isEmpty() != true) 
			{
				AbcNode temp = globalStack.pop();
				
				if (temp != null) 
				{
					System.out.print(temp.sData);
					localStk.push(temp.leftChild);
					localStk.push(temp.rightChild);

					if (temp.leftChild != null || temp.rightChild != null)
						isRowEmpty = false;
				} else 
				{
					System.out.print("--");
					localStk.push(null);
					localStk.push(null);
				}
				
				for (int i=0;i<nBlnks*2-2;i++)
				{
					System.out.print(" ");

				}
			}
			System.out.println();
			nBlnks /= 2;
			while (localStk.isEmpty() == false)
			{
				globalStack.push(localStk.pop());
			}
		}
		System.out.println(".......................................................");
	}
} 

class BalancedTreeApp 
{
	public static void main(String[] args) throws IOException 
	{
		int value;
		String initString = "ABCDEFGHIJKLMNOP";
		BalancedTree theTree = new BalancedTree(initString);

		while (true) {
			System.out.print("Enter 1st letter of 'show'" + " or 'traverse' : ");
			int choice = getChar();
			switch (choice) {
			case 's':
				theTree.displayTree();
				break;
			case 't':
				System.out.print("Enter the number 1, 2, or 3 : ");
				value = getInt();
				theTree.traverse(value);
				break;
			default:
				System.out.print("Invalid entry...\n");
			} 
		} 
	} 

	public static String getString() throws IOException 
	{
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		String str = br.readLine();
		return str;
	}

	public static int getInt() throws IOException 
	{
		String s1 = getString();
		return Integer.parseInt(s1);
	}
	
	public static char getChar() throws IOException 
	{
		String s1 = getString();
		return s1.charAt(0);
	}
}
