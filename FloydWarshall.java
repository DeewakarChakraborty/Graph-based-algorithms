/*
  Graph implemented using adjacency matrix.
  Implemented using Dynamic Programming approach
  time complexity : O(V^3)
 */
import java.util.*;
class Graph{
	private int vertex;
	private int dp[][];// Stores the distance.
	public Graph(int vertex, int[][] g){
		this.vertex=vertex;
		 dp=new int[vertex][vertex];
		 for(int i=0;i<vertex;i++)
			 for(int j=0;j<vertex;j++)
				 dp[i][j]=g[i][j];
	}
	public int[][] floydWarshall(){
		for(int k=0;k<vertex;k++)
		   for(int i=0;i<vertex;i++)
			  for(int j=0;j<vertex;j++)
				  if(dp[i][k]+dp[k][j]<dp[i][j])
					  dp[i][j]=dp[i][k]+dp[k][i];
	    //In order to detect negative edged cycles
		for(int k=0;k<vertex;k++)
		   for(int i=0;i<vertex;i++)
			  for(int j=0;j<vertex;j++)
				  if(dp[i][k]+dp[k][j]<dp[i][j])
					  dp[i][j]=-1; // -1 means negative infinity.
		return dp;
	}
}
class Driver{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no. of vertices :");
		int vertex=sc.nextInt();
		int[][] g=new int[vertex][vertex];
		System.out.println("Enter the elements of the graph:\n");
		for(int i=0;i<vertex;i++)
			for(int j=0;j<vertex;j++)
				g[i][j]=sc.nextInt();
		System.out.println("The shortest paths are:\n");
		Graph graph=new Graph(vertex,g);
		int[][] path= graph.floydWarshall();
		for(int i=0;i<vertex;i++){
			for(int j=0;j<vertex;j++)
				System.out.print(path[i][j]+" ");
		    System.out.print("\n");
		}
	}
}

