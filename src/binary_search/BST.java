public class BST<Key extends Comparable<Key>, Value>{

	//inner node class
	private class Node{ 
		private Key key;
		private Value value;
		private Node left; //left child
		private Node right; //right child

		public Node(Key k, Value v){
			this.key = k;
			this.value = v;
			left = right = null;
		}
		public Key getKey(){
			return key;
		}

		public Node getLeft(){
			return left;
		}

		public Node getRight(){
			return right;
		}
	}

	private Node root; //root node
	private int size;

	//constructor
	public BST(){
		root = null;
		size = 0;
	}

	//access method
	public int size(){
		return size;
	}

	public boolean isEmpty(){
		return size == 0;
	}

	//update method
	public void add(Key k, Value v){
		insert(root, k, v);
	}

	private Node insert(Node n, Key k, Value v){
		//when n is null, we new a node and return it
		if(n == null){
			size++;
			return new Node(k, v);
		}
		//when k == n.key, we replace value by the new value
		if(k.compareTo(n.key)==0) //outer class can access private variable in inner class
			n.value= v;
		//when k<n.key, we insert it into n's left binary tree
		if(k.compareTo(n.key)<0)
			return insert(n.left, k, v);
		//when k>n.key, we insert it into n's right binary tree
		else{
			return insert(n.right, k, v);
		}
	}
}