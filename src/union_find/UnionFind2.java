public class UnionFind2{
	private int[] parent; //parent int array to store parent of each element
	private int size;

	//constructor
	//create a new unionfind with size n
	public UnionFind2(int n){
		this.parent = new int[n];
		this.size = n;
		for(int i = 0; i<n; i++){
			parent[i] = i;
		}
	}

	//return p's root
	public int find(int p) throws IndexOutOfBoundsException{
		if(p<0 || p>=size) throw new IndexOutOfBoundsException("p is out of bound");
		while(p!=parent[p]){
			p = parent[p]; //search p's parent
		}
		return p; //return p's parent
	}

	//check if p and q are connected
	public boolean isconnected(int p, int q){
		return find(p) == find(q);
	}

	//union p and q
	public void union(int p, int q){
		int pRoot = find(p); //remember to use variable to save operation
		int qRoot = find(q);
		if(pRoot == qRoot)
			return;
		parent[p]=qRoot; //now the union operation is O(1)
	}
}