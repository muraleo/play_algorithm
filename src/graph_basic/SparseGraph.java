import java.util.Vector;

public class SparseGraph{
	private int n;
	private int m;
	private boolean directed;
	private Vector<Integer>[] g; //graph

	//constructor
	public SparseGraph(int n, boolean direc){
		assert (n>0);
		this.n = n;
		this.m = 0;
		this.directed = direc;
		g = (Vector<Integer>[]) new Vector[n]; // how to initialize vector<Integer>[] array
		for(int i = 0; i<n; i++){
			g[i] = new Vector<Integer>();
		}
	}

	public int V(){return n;}
	public int E(){return m;}

	//update method
	public void add(int v, int w){
		assert (v<=0||v>n);
		assert (w<=0||w>m);
		g[v].add(w);
		if(v!=w&&!directed)
			g[w].add(v);
		m++;
	}

	public boolean hasEdge(int v, int w){
		assert (v<=0||v>n);
		assert (w<=0||w>m);
		return g[v].contains(w);
	}
}