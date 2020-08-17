/* Implemented as Edge List
    time complexity: O(E.V)
*/
import java.util.*;
class Graph{
	private int vertex;
	private double dist[];
	private ArrayList<Edge> list=new ArrayList<>();
	public static class Edge{
		int from,to;
		double weight;
		public Edge(int from,int to,double weight){
			this.from=from;
			this.to=to;
			this.weight=weight;
		}
	}
	Graph(int vertex){
		this.vertex=vertex;
	}
	public void addEdge(int from,int to,double weight){
		list.add(new Edge(from,to,weight));
	}
	public double[] bellmanFord(int source){
		dist=new double[vertex];
		Arrays.fill(dist,Double.POSITIVE_INFINITY);
		dist[source]=0;
		for(int i=0;i<vertex-1;i++){
			for(Edge e : list ){
				if(dist[e.to]>dist[e.from]+e.weight)
					dist[e.to]=dist[e.from]+e.weight;
			}
		}
		/* 	In order to detect negative edge cycle and al nodes connected to it */
		for(int i=0;i<vertex-1;i++){
			for(Edge e : list){
				if(dist[e.to]>dist[e.from]+e.weight)
					dist[e.to]=Double.NEGATIVE_INFINITY;
			}
		}
	    return dist;
	}
}
class Driver{
	public static void main(String[] args){
		int vertex=5;
		Graph g=new Graph(vertex);
		g.addEdge(0,1,6);
		g.addEdge(0,2,7);
		g.addEdge(1,2,8);
		g.addEdge(1,4,5);
		g.addEdge(1,3,-4);
		g.addEdge(4,1,-5);
		g.addEdge(2,3,9);
		g.addEdge(2,4,-3);
		g.addEdge(3,0,2);
		g.addEdge(3,4,7);
		for(double i : g.bellmanFord(0))
			System.out.print(i+" ");
	}
}