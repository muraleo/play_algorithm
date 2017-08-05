//Graph interface
public interface Graph{
	public int V(); //return number of vectors in graph
	public int E(); //return number of edges in graph
	public void addEdge(int v, int w); //add edge vw in graph
	public boolean hasEdge(int v, int w); //add whether edge vw is exist
	public void show(); //print whole graph
}