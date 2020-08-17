/* Implemented as Adjacency List */
// complexity:O(E.log(V))
import java.util.*;
class Graph{
	private double dist[];  //stores distance
	private int prev[];     //stores previous node for current node
	private Map<Integer, List<Edge>> map=new HashMap<>();
    public static class Edge{
		int to;
		double weight;
		public Edge(int to,double weight){
			this.to=to;
			this.weight=weight;
		}
	}
	public static class Node implements Comparable<Node>{
		int id;
		double weight;
		public Node(int id,double weight){
			this.id=id;
			this.weight=weight;
		}
		public int compareTo(Node n){
			return Double.compare(this.weight,n.weight);
		}
	}
	public void addVertex(int node){
		map.put(node, new ArrayList<Edge>());
	}
	public void addEdge(int from,int to,double weight){
		if(!map.containsKey(from))
			addVertex(from);
		if(!map.containsKey(to))
			addVertex(to);
		map.get(from).add(new Edge(to,weight));
	}
	public double[] dijkstra(int source){
		int n=map.keySet().size();
		dist=new double[n];
		prev=new int[n];
		Arrays.fill(dist, Double.POSITIVE_INFINITY);
		dist[source]=0;
		boolean[] visited=new boolean[n];
		/*
		  Extract min in prioroty queue is O(log n)
		  decrease key operation is not important.
		 */
		PriorityQueue<Node> pq=new PriorityQueue<>();
		pq.add(new Node(source,0));
		while(pq.size()!=0){
			Node node=pq.poll();
			visited[node.id]=true;
			if(dist[node.id]<node.weight) continue; // we are ignoring aditional nodes added as  we did not use decrease key operation.
			for(Edge i: map.get(node.id)){
				if(visited[i.to]) continue;
				else{
					double newDist=dist[node.id]+i.weight;
					if(newDist<dist[i.to]){
						dist[i.to]=newDist;
						prev[i.to]=node.id;
						pq.add(new Node(i.to,newDist));
					}
				}
			}
		}
		return dist;
	}
}
class Driver {
	public static void main(String[] args){
		Graph g=new Graph();
		g.addEdge(0,1,2);
		g.addEdge(0,4,-3);
		g.addEdge(1,2,3);
		g.addEdge(1,7,-5);
		g.addEdge(2,3,2);
		g.addEdge(2,6,2);
		g.addEdge(3,0,1);
		g.addEdge(7,4,1);
		g.addEdge(6,7,2);
		g.addEdge(6,4,1);
		g.addEdge(4,5,2);
		g.addEdge(5,6,3);
		for(double i : g.dijkstra(0))
			System.out.print(i+" ");
		
	}
}