import java.util.Stack;
import java.util.Vector;

public class Path{
	private Graph g;
	private int s; // start vector
	private boolean[] visited; //whether be visited
	private int[] from; //record path, from[i] means last vector from i;

	private void dfs(int v){
		visited[v] = true;
		for(int i:g.adj(v)){
			if(!visited[i]){
				from[i] = v; // i's last vector is v
				dfs(v);
			}
		}
	}

	//constructor and find path
	public Path(Graph graph, int s){
		g = graph;
		assert s>=0 && s<g.V();

		visited = new boolean[g.V()];
		from = new int[g.V()];
		for(int i = 0; i<g.V(); i++){
			visited[i] = false;
			from[i] = -1;
		}

		this.s = s;

		//start finding a path
		dfs(s);
	}

	public boolean hasPath(int w){
		assert w >= 0 && w < g.V();
		return visited[w];
	}

	public Vector<Integer> path(int w){
		assert hasPath(w);

		Stack<Integer> stack = new Stack<Integer>();
		while(w!=-1){
			stack.push(w);
			w = from[w];
		}

		Vector<Integer> result = new Vector<Integer>();
		while(!stack.isEmpty()){
			result.add(stack.pop());
		}

		return result;
	}

	public void showPath(int w){
		assert w>=0&&w<g.V();

		Vector<Integer> p = path(w);
		for(int i = 0; i<p.size(); i++){
			System.out.print(p.elementAt(i));
			if(i == p.size()-1)
				System.out.println();
			else
				System.out.print("->");
		}
	}
}