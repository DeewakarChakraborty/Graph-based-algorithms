class Graph<T>{
	private Map<T,List<T>> map=new HashMap<T,List<T>>();
	public void addVertex(T s){
	    map.put(s, new LinkedList<T>());
	}
	public void addEdge(T source, T destination, boolean bidirectional){
		if(!map.containsKey(source))
			addVertex(source);
	    if(!map.containsKey(destination))
			addVertex(destination);
	    map.get(source).add(destination);
		if(bidirectional==true)
			map.get(destination).add(source);
	}
	public String view(){
		StringBuilder str=new StringBuilder();
		for(T i :map.keySet()){
			str.append(i.toString()+"->");
			for(T j : map.get(i))
				str.append(j.toString()+" ");
			str.append("\n");
		}
		return (str.toString());
	}
}