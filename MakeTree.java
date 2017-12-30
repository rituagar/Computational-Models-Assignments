package hw5_q2;

public class MakeTree
{
	public static String[] theTree;
	public static void makeBranches(int l, int r, int row)
	{
		if(l - r==0) return;
		int midpt=(l + r)/2;
		for(int i=l;i<r;i++)
		{
			theTree[row] += "-";
			if(i==midpt) 
				{
				theTree[row] += "X";
				}
		}
		
		makeBranches(l, midpt, row+1);
		
		makeBranches(midpt+1, r, row+1);
		
	}
	
	public static void displayTree(String[] tree)
	{
		for(int i=0;i<tree.length;i++)
		{
			System.out.println(tree[i]);
		}
	}
	
	public static void main(String[] args)
	{
		int sizeOfRow = 64;
		int numRows = (int)(Math.log(sizeOfRow)/Math.log(2)) + 1;
		theTree = new String[numRows];
		
		for(int i=0;i<theTree.length;i++) 
			{
			theTree[i] = "";
			if(i==theTree.length-1)
				{
				for(int j=0;j<sizeOfRow;j++)
					theTree[i]+="X";
				}
			}
		
		makeBranches(0, sizeOfRow-1, 0);
		displayTree(theTree);
	}
	
}