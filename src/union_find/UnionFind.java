public class UnionFind{
	private int[] id; //id of each element, if two element have same id, they are in the same set
	private int size; //how many elements in this unionfind

	//constructor
	public UnionFind(int n){
		id = new int[n];
		for(int i = 0; i<n; i++){
			id[i] = i;
		}
		size = n;
	}

	//return p's set
	public int find(int p) throws IndexOutOfBoundsException{// find element p's id
		if(p<0 || p>size) throw new IndexOutOfBoundsException("p is out of bound");
		return id[p];
	}

	boolean isConnected(int p, int q){
		return find(p) == find(q);
	}

	public void union(int p, int q){ //make p set and q set have the same id number
		int pId = find(p);
		int qId = find(q);

		if(pId == qId) //if p and q are in the same set, return nothing
			return;

		for(int i = 0; i<size; i++){ // union p set with q set
			if(id[i] == pId)
				id[i]=qId;
		}
	}


}