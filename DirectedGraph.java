import java.util.*;
class Graph{
	private Map<Integer,List<Integer>> map=new HashMap<>();
	public void addVertex(int node){
		map.put(node,new LinkedList<Integer>());
	}
	public void addEdge(int source, int destination){
		if(!map.containsKey(source))
			addVertex(source);
		if(!map.containsKey(destination))
			addVertex(destination);
	    map.get(source).add(destination);
	}
//__________________________________________________________________________________
	public ArrayList<Integer> TopSort(){
		int n=map.keySet().size();
		boolean[] visited=new boolean[n];
		Stack<Integer> stack=new Stack<Integer>();
		for(int i=0;i<n;i++){
			if(!visited[i]){
				TopSortUtil(i,visited,stack);
			}
		}
		ArrayList<Integer> li=new ArrayList<>();
		while(stack.empty()==false)
			li.add(stack.pop());
		return li;
		
	}
	public void TopSortUtil(int node,boolean[] visited,Stack<Integer> stack){
		visited[node]=true;
		for(int i:map.get(node)){
			if(!visited[i])
				TopSortUtil(i,visited,stack);
		}
		stack.push(new Integer(node));
	}
}
//__________________________________________________________________________________
class Driver{
	public static void main(String[] args){
		Graph g=new Graph();
		g.addEdge(0,1);
		g.addEdge(1,2);
		g.addEdge(1,3);
		g.addEdge(1,5);
		g.addEdge(2,8);
		g.addEdge(8,10);
		g.addEdge(3,4);
		g.addEdge(4,6);
		g.addEdge(6,7);
		g.addEdge(5,9);
		for(Integer i : g.TopSort())
			System.out.print(i+" ");
	}
}