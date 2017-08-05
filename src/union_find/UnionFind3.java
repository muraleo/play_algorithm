public class UnionFind3{
	private int[] parent; //parent int array to store parent of each element
	private int[] count; //store how many element in each element
	private int size;

	//constructor
	//create a new unionfind with size n
	public UnionFind3(int n){
		this.parent = new int[n];
		this.count = new int[n];
		this.size = n;
		for(int i = 0; i<n; i++){
			parent[i] = i;
			count[i] = 1; //because at first, each tree just has one element, just itself
		}
	}

	//return p's root
	public int find(int p) throws IndexOutOfBoundsException{
		//optimization 4: path compression
		// if(p<0 || p>=size) throw new IndexOutOfBoundsException("p is out of bound");
		// while(p!=parent[p]){
		// 	parent[p] = parent[parent[p]];
		// 	p = parent[p]; //search p's parent
		// }
		// return p; //return p's parent

		//optimization 5; compress path into 2 level
		if(p!=parent[p])
			parent[p] = find(parent[p]);
		return parent[p];
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
		//parent[p]=qRoot; //now the union operation is O(1)
		//quick union
		if(count[p]<=count[q]){ //when p tree is shorter tree
			parent[q] = pRoot; //q point to p
			count[p] += count[q]; //renew p count
		}else{
			parent[p] = qRoot;
			count[q] += count[p];
		}
	}
}