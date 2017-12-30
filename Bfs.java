class Queue {
	private final int SIZE = 20;
	private int[] queArray;
	private int front;
	private int rear;

	
	public Queue()

	{
		queArray = new int[SIZE];
		front = 0;
		rear = -1;
	}
	public void insert(int j) 
	{
		if (rear == SIZE - 1)
			rear = -1;
		queArray[++rear] = j;
	}


	public int remove()

	{
		int temp = queArray[front++];
		if (front == SIZE)
			front = 0;
		return temp;
	}

	
	public boolean isEmpty() 
	{
		return (rear + 1 == front || (front + SIZE - 1 == rear));
	}
	
} 
class Vertex {
	public char label;
	
	public boolean wasVisited;

	
	public Vertex(char lab)
	{
		label = lab;
		wasVisited = false;
	}
}

class BFSGraph {
	private final int MAX_VERTS = 20;
	private Vertex vertexList[]; 
	private int adjMat[][];
	private int nVerts;
	private Queue theQueue;

	public BFSGraph()
	{
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for (int j = 0; j < MAX_VERTS; j++)
		{
			for (int k = 0; k < MAX_VERTS; k++)
			{
				adjMat[j][k] = 0;
			}
		}
		theQueue = new Queue();
	} 

	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}

	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}

	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}

	
	public void bfs()
	{	
		vertexList[0].wasVisited = true; 
		displayVertex(0);
		
		theQueue.insert(0);
		
		int v2;
		while (!theQueue.isEmpty())
		{
			int v1 = theQueue.remove();
			
			while ((v2 = getAdjUnvisitedVertex(v1)) != -1) 
			{	
				vertexList[v2].wasVisited = true; // mark it
				displayVertex(v2);	
				theQueue.insert(v2);
			}
			
		}
		for (int j = 0; j < nVerts; j++)
		{
			
			vertexList[j].wasVisited = false;
		}
	} 

	public int getAdjUnvisitedVertex(int v) 
	{
		for (int j = 0; j < nVerts; j++)
		{
			if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false)
			{
				return j;
			}
		}
		return -1;
	} 
	
	public void bfMinSpanTree()
	{
		vertexList[0].wasVisited = true;
		
		theQueue.insert(0);
		
		int V2;
		
		while(!theQueue.isEmpty())
		{
			int v1 = theQueue.remove();
			while( (V2=getAdjUnvisitedVertex(v1)) != -1)
			{
				vertexList[V2].wasVisited = true;
				
				displayVertex(v1);
				
				displayVertex(V2);
				
				System.out.print("|");
				
				theQueue.insert(V2);
			}
		}
		
		for(int j = 0; j < nVerts; j++)
		{
			vertexList[j].wasVisited = false;
		}
	} 
} 

class Bfs
{
	public static void main(String[] args) 
	{
		
		BFSGraph theGraph = new BFSGraph();
		theGraph.addVertex('A');	
		theGraph.addVertex('B');
		 
		theGraph.addVertex('C');
		 
		theGraph.addVertex('D');
		 theGraph.addVertex('E');
		theGraph.addVertex('F');
		
		 theGraph.addVertex('G');
		theGraph.addVertex('H');
		 theGraph.addVertex('I');
		
		theGraph.addEdge(0, 1);
		theGraph.addEdge(1, 7);
		 theGraph.addEdge(7, 8);
		theGraph.addEdge(1, 8);
		 theGraph.addEdge(1, 2);
		
		 theGraph.addEdge(0, 2);
		theGraph.addEdge(2, 3);
		theGraph.addEdge(3, 4);
		 theGraph.addEdge(3, 5);
		 
		 theGraph.addEdge(3, 6);
		theGraph.addEdge(4, 5);
		
		theGraph.addEdge(5, 6);
		
		System.out.print("Visits: ");
		theGraph.bfs();
		System.out.println();
		
		System.out.println("Minimum Spanning Tree of Graph");
		theGraph.bfMinSpanTree();
System.out.println();
	} 
}