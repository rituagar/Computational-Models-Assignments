package hw7_q1;

import java.io.*;
import java.util.*;

class AbcNode
{
	public String sData;			
	public AbcNode leftChild;
	public AbcNode rightChild;
	
	public void displayNode()
	{
		System.out.print("{" + sData + "}");
	}
}

class AbcTree
{
	private AbcNode root;			
	
	public AbcTree(String initString)
		{ 
			root = null;
			
			AbcNode[] nodeArray = new AbcNode[initString.length()];
			for(int i = 0; i < initString.length(); i++)
			{
				nodeArray[i] = new AbcNode();
				nodeArray[i].sData = String.valueOf(initString.charAt(i));
			}
			
			AbcNode plusNode = new AbcNode();
			plusNode.sData = "+";
			plusNode.leftChild = nodeArray[0];
			plusNode.rightChild = nodeArray[1];
			
			for(int j = 2; j < nodeArray.length; j++)
			{
				AbcNode newNode = new AbcNode();
				newNode.sData = "+";
				newNode.leftChild = plusNode;
				newNode.rightChild = nodeArray[j];
				plusNode = newNode;
			}
			root = plusNode;
		}
	
	public void traverse(int traverseType)
	{
		switch(traverseType)
		{
		case 1: System.out.print("\nPreorder traversal : ");
				preOrder(root);
				break;
		case 2: System.out.print("\nInorder traversal : ");
				inOrder(root);
				break;
		case 3: System.out.print("\nPostorder traversal : ");
				postOrder(root);
				break;
		}
		System.out.println("");
	}
	
	private void preOrder(AbcNode localRoot)
	{
		if(localRoot != null)
		{
			System.out.print(localRoot.sData + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}
	
	private void inOrder(AbcNode localRoot)
	{
		if(localRoot != null)
		{
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.sData + " ");
			inOrder(localRoot.rightChild);
		}
	}
	
	private void postOrder(AbcNode localRoot)
	{
		if(localRoot != null)
		{
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.print(localRoot.sData + " ");
		}
	}
	
	public void displayTree()
	{
		Stack<AbcNode> globalStack = new Stack<AbcNode>();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println(
		".......................................................");
		
		while(isRowEmpty==false)
		{
			Stack<AbcNode> localStack = new Stack<AbcNode>();
			isRowEmpty = true;
			
			for(int j = 0; j < nBlanks; j++)
				System.out.print(" ");
			
			while(globalStack.isEmpty() == false)
			{
				AbcNode temp = globalStack.pop();
				if(temp != null)
				{
					System.out.print(temp.sData);
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
		System.out.println(
		".......................................................");
	} 
} 

class AbcTreeApp
{
	public static void main(String[] args) throws IOException
	{
		String initStr="ABCDEFG";
		AbcTree theTree = new AbcTree(initStr);
		int value;
		
		while(true)
		{
			System.out.print("Enter 1st letter of 'show'"
					+ " or 'traverse': ");
			int choice = getChar();
			
			switch(choice)
			{
			case 's':
				theTree.displayTree();
				break;
			case 't':
				System.out.print("Enter number 1, 2, or 3: ");
				value = getInt();
				theTree.traverse(value);
				break;
			default:
				System.out.print("Invalid entry\n");
			} 
		}
	} 
	
	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	
	public static int getInt() throws IOException
	{
		String s = getString();
		return Integer.parseInt(s);
	}
	public static char getChar() throws IOException
	{
		String s = getString();
		return s.charAt(0);
	}
	
	
}
