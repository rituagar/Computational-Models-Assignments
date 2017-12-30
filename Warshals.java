class W1StackX
{private int[] st1;
	private final int SIZE = 20;
	
	private int top1;

	
	public boolean isEmpty() 
	{
		return (top1 == -1);
	}
	
	public W1StackX() 
	{
		st1 = new int[SIZE];
		
		top1 = -1;
	}

	public int peek() 
	{
		return st1[top1]; 
	}
	
	public void push(int i) 
	{ 
		
		++top1;
		st1[top1] = i; 
	}

	public int pop() 
	{
		return st1[top1--];
		
	}
	
	

	
} 

class WVertex
{
	public boolean wasVisited;
	
	public char label; 
	

	public WVertex(char lab1) 
	{
		label = lab1;
		wasVisited = false;
	}
} 

class WarshallGraph
{
	private int nVerts;
	
	private final int MAX_VERTS = 20;
	
	
	private W1StackX theStack;
	
	private WVertex vertexList[]; 
	
	private int adjMat[][]; 
	 
	public WarshallGraph()
	{
		vertexList = new WVertex[MAX_VERTS];
		
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		
		nVerts = 0;
		
		for(int i = 0; i < MAX_VERTS; i++) 
		{
			for(int j = 0; j < MAX_VERTS; j++) 
			{
				adjMat[i][j] = 0;
			}
		}
		
		theStack = new W1StackX();
	}

	public void addVertex(char Lab1)
	{
		vertexList[nVerts++] = new WVertex(Lab1);
	}

	public void dfs(int start) 
	{ 
		vertexList[start].wasVisited = true; 
		
		displayVertex(start); 
		
		theStack.push(start); 
		while(!theStack.isEmpty()) 
		{
			int vi = getAdjUnvisitedVertex(theStack.peek());
			
			if(vi==-1) 
			{
				theStack.pop();
				
			}
			else 
			{
				vertexList[vi].wasVisited = true; 
				
				displayVertex(vi); 
				
				theStack.push(vi); 
			}
		} 
		
		
		for(int j=0; j<nVerts; j++) 
		{
			vertexList[j].wasVisited = false;
		}
	} 
	
	public void addEdge(int str, int end)
	{
		adjMat[str][end] = 1;
	}

	public void displayVertex(int v)
	{
		System.out.print(vertexList[v].label);
	}

	public int[][] warshall()
	{
		int[][] newAdjMat = new int[MAX_VERTS][MAX_VERTS];
		
		
		for(int i=0; i<nVerts; i++)
		{
			for(int j=0; j<nVerts; j++)
			{
				
				newAdjMat[i][j] = adjMat[i][j];
			}
		}
		
		for(int y=0; y<nVerts; y++)
		{
			
			for(int x = 0; x < nVerts; x++)
			{
				if(adjMat[y][x] == 1)
			
				{
					for(int z = 0; z < nVerts; z++)
					{
						if(adjMat[z][y] == 1)
						{
							newAdjMat[z][x] = 1;
						}
					}
				}
			}
		}
		System.out.println("\nIntermediate step : ");
		displayMatrix(newAdjMat);

		System.out.println();
		return newAdjMat;
	}
	

	public int getAdjUnvisitedVertex(int v)
	{
		for(int j=0; j<nVerts; j++)
		if(adjMat[v][j]==1 && vertexList[j].wasVisited==false)
		return j;
		return -1;
	}
	
	public void displayConnectTable()
	{
		for(int j = 0; j < nVerts; j++)
		{
			dfs(j);
			System.out.println();
		}
	}
	
	public void displayMatrix(int[][] matrix)
	{
		for(int i=0; i<nVerts; i++)
		{
			for(int j=0; j<nVerts; j++)
				System.out.print(matrix[i][j]);
			System.out.println();
		}
	}
	public int[][] getAdjMat()
	{ 
		return adjMat; 
	}
	
} 

class Warshals
{
	public static void main(String[] args)
	{
		WarshallGraph theGraph = new WarshallGraph();
		
		theGraph.addVertex('A'); 
		 theGraph.addVertex('B'); 
		 theGraph.addVertex('C');
		theGraph.addVertex('D'); 
		 theGraph.addVertex('E');
		
		theGraph.addEdge(0, 2); 
		
		theGraph.addEdge(1, 0);
		 theGraph.addEdge(1, 4);
		
		theGraph.addEdge(3, 4);
		 theGraph.addEdge(4, 2);
		
		theGraph.displayConnectTable();
		
		System.out.println("\nOriginal : ");
		theGraph.displayMatrix(theGraph.getAdjMat());
		
		int[][] newAdjMat = theGraph.warshall();
		
		System.out.println("\nFinal : ");
		theGraph.displayMatrix(newAdjMat);
	} 
}
