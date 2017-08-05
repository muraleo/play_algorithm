public class Components{
	Graph g;
	private boolean[] visited; //record this elements is visited or not
	private int count; //return the number of components
	private int [] id; //id[i] indicate this element belongs to component id[i]

	//constructor
	public Components(Graph graph){
		g = graph;
		visited = new boolean[g.V()]; //initiated visited array
		count = 0;
		id = new int[g.V()];

		for(int i = 0; i<g.V(); i++){
			visited[i] = false; //initialize visited array
			id[i] = -1; //initialize id array
		}

		for(int i=0; i< g.V(); i++){
			if(!visited[i]){
				dfs(i);
				count++;
			}
		}
	}

	//access method
	public int count(){
		return count;
	}

	//auxiliary method
	private void dfs(int v){
		visited[v] = true; //this vector has been visited
		id[v] = count; // this vector belongs to component count
		for(int i: g.adj(v)){
			if(!visited[i]) //if visited[i] is false
				dfs(i);
		}

	}
}