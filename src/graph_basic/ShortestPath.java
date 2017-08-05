import java.util.Vector;
import java.util.Stack;
import java.util.LinkedList;

public class ShortestPath{
	private Graph g;
	private int s;
	private boolean[] visited;
	private int[] from;
	private int[] ord;

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
	public ShortestPath(Graph graph, int s){
		g = graph;
		assert s>=0 && s<g.V();

		visited = new boolean[g.V()];
		from = new int[g.V()];
		ord = new int[g.V()];
		for(int i = 0; i<g.V(); i++){
			visited[i] = false;
			from[i] = -1;
			ord[i] = -1;
		}

		this.s = s;

		//start finding a path
		LinkedList<Integer> list = new LinkedList<Integer>();

		list.push(s);
		visited[s] = true;
		ord[s] = 0;
		while(!list.isEmpty()){
			int temp = list.pop();
			for(int i: g.adj(temp)){
				if(!visited[i]){
					list.push(i);
					visited[i] = true;
					from[i] = temp;
					ord[i] = ord[temp]+1;
				}
			}
		}
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

	public int length(int w){
		assert w>=0&&w<g.V();
		return ord[w];
	}
}