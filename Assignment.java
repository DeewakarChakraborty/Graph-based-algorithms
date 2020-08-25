import java.lang.*; 
import java.util.*;
//----------------------------------STACK---------------------------------------------------
class StackUsingLinkedlist { 
	private class Node { 
		int data; 
		Node link; 
	}  
	Node top; 
	StackUsingLinkedlist() 
	{ 
		this.top = null; 
	} 
	public void push(int x)  
	{ 
		Node temp = new Node(); 
		if (temp == null) { 
			System.out.print("\nHeap Overflow"); 
			return; 
		} 
		temp.data = x; 
		temp.link = top; 
		top = temp; 
	}  
	public boolean isEmpty() 
	{ 
		return top == null; 
	} 
	public int peek() 
	{ 
		if (!isEmpty()) { 
			return top.data; 
		} 
		else { 
			System.out.println("Stack is empty"); 
			return -1; 
		} 
	} 
	public void pop() 
	{ 
		if (top == null) { 
			System.out.print("\nStack Underflow"); 
			return; 
		} 
		top = (top).link; 
	} 

	public void display() 
	{ 
		if (top == null) { 
			System.out.printf("\nStack Underflow"); 
		} 
		else { 
			Node temp = top; 
			while (temp != null) { 
				System.out.printf("%d->", temp.data); 
				temp = temp.link; 
			} 
		} 
	} 
}
//-------------------------------------APPLICATION------------------------------------------------
class Graph{
	int V;
    LinkedList<Integer>[] adj;
    Graph(int V){ 
            this.V = V; 
            adj = new LinkedList[V]; 
            for (int i = 0; i < adj.length; i++) 
                adj[i] = new LinkedList<Integer>(); 
              
        } 
    void addEdge(int v, int w){ 
            adj[v].add(w); 
        }
    public int findConnectingComponents(){
		boolean visited[]=new boolean[V];
		Arrays.fill(visited,false);
		int count=0;
		for(int i=0;i<V;i++){
			if(!visited[i]){
				count++;
				DfsUtility(i,visited);
			}
		}
		return count;
	}
    void DfsUtility(int s, boolean[] visited){ 
            StackUsingLinkedlist stack=new StackUsingLinkedlist();
            stack.push(s); 
            while(stack.isEmpty() == false) 
            { 
                s = stack.peek(); 
                stack.pop(); 
                if(visited[s] == false) 
                {  
                    visited[s]=true; 
                } 
                Iterator<Integer> itr = adj[s].iterator(); 
                  
                while (itr.hasNext())  
                { 
                    int v = itr.next(); 
                    if(!visited[v]) 
                        stack.push(v); 
                } 
                  
            } 
        } 	
}
//-------------------------------------------------------------------------------------
public class Assignment{ 
	public static void main(String[] args) 
	{ 
        Graph g = new Graph(5);
        g.addEdge(1, 0);  
        g.addEdge(2, 3);  
        g.addEdge(3, 4); 
		System.out.println(g.findConnectingComponents());
	} 
} 
//-------------------------------------------------------------------------------------
