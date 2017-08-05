public class DenseGraph{
	private int n; // number of nodes
	private int m; // number of edges
	private boolean directed; // mark whether a directed graph
	private boolean[][] g; //graph

	//constructor
	public DenseGraph(int n, boolean direct){
		assert n>0;
		this.n = n;
		this.m = 0;
		this.directed = direct;
		g = new boolean[n][n];
	}

	//access method
	public int V(){return n;} //get number of node
	public int E(){return m;} //get number of edge

	//update method
	public void addEdge(int v, int w){
		assert (v>=0&&v<n);
		assert (w>=0&&w<m);
		if(hasEdge(v, w))
			return;
		g[v][w] = true;
		if(directed==false)
			g[w][v] = true;
		m++;
	}

	public boolean hasEdge(int v, int w){
		assert (v>=0&&v<n);
		assert (w>=0&&w<m);
		return g[v][w];
	}

	//step 3
	//return all the adjacent node around node v
	public Iterable<Integer> adj(int v){
		assert (v>=0&&v<n);
		Vector<Integer> adjv = new Vector<>();
		for(int i =0;i<n; i++){
			if(g[v][i])
				adjv.add(i);
		}
		return adjv;
	}
}