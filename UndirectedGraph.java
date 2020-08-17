import java.util.*;
class Graph{
	private Map<Integer, List<Integer>> map=new HashMap<>();
	public void addVertex(int node){
		map.put(node,new LinkedList<Integer>());
	}
	public void addEdge(int source,int destination){
		if(!map.containsKey(source))
			addVertex(source);
		if(!map.containsKey(destination))
			addVertex(destination);
		map.get(source).add(destination);
		map.get(destination).add(source);
	}
//_____________________________________________________________________
	public void DFS(int source){
		int nodes=map.keySet().size();
		boolean visited[]=new boolean[nodes];
		DfsUtility(source, visited);
	}
	public void DfsUtility(int v, boolean[] visited){
		visited[v]=true;
		//System.out.print(v+" ");
		for(int i: map.get(v)){
			if(!visited[i])
				DfsUtility(i,visited);
		}
	}
//______________________________________________________________________
    public void BFS(int s){
		int nodes=map.keySet().size();
		boolean visited[]=new boolean[nodes];
		LinkedList<Integer> queue=new LinkedList<>();
		visited[s]=true;
		queue.add(s);
		while(queue.size()!=0){
			s=queue.poll();
			//System.out.print(s+" ");
			for(int i: map.get(s)){
				if(!visited[i]){
					visited[i]=true;
					queue.add(i);
				}
			}
		}
	}
//_______________________________________________________________________
   public boolean DetectCycle(){
	   int n=map.keySet().size();
	   boolean[] visited=new boolean[n];
	   for(int i=0;i<n;i++)
		  visited[i]=false;
	   for(int i=0;i<n;i++){
		   if(!visited[i]){
			   if(isCycle(i,visited,-1))
				   return true;
		   }
	   }
	   return false;
   }
   public boolean isCycle(int node,boolean[] visited,int parent){
	   visited[node]=true;
	   for(int i: map.get(node)){
		   if(!visited[i])
			   if(isCycle(i,visited,node))
				   return true;
			else if(i!=parent)
				  return true;
	   }
	   return false;
   }
//_______________________________________________________________________
    public int findConnectingComponents(){
		int n=map.keySet().size();
		boolean visited[]=new boolean[n];
		int count=0;
		for(int i=0;i<n;i++){
			if(!visited[i]){
				count++;
				DfsUtility(i,visited);
			}
		}
		return count;
	}
//________________________________________________________________________
}
class Driver{
	public static void main(String[] args){
		Graph g=new Graph();
		g.addEdge(0, 1); 
        g.addEdge(0, 4); 
        g.addEdge(1, 2); 
        g.addEdge(1, 3); 
        g.addEdge(1, 4); 
        g.addEdge(2, 3); 
        g.addEdge(3, 4); 
	//	  g.DFS(0);
	//	  g.BFS(0);
	//    int n=g.findConnectingComponents();
	//   	System.out.println(n);
	//    System.out.print(g.DetectCycle());
	}
}