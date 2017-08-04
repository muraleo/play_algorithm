import java.util.*;
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

	public boolean contain(Key k){
		return contain(root, k);
	}

	public Value search(Key k){
		return search(root, k);
	}
	//node, left, right
	public void preOrder(){
		preOreder(root);
	}
	//left, node, right
	public void inOrder(){
		inOrder(root);
	}
	//left, right, node
	public void postOrder(){
		postOrder(root);
	}
	public void BFT(){
		PriorityQueue<Node> q = new PriorityQueue();
		q.add(root);
		while(!q.isEmpty()){
			Node n = q.poll();
			System.out.print(" "+n.key);
			if(n.left!=null)
				q.add(n.left);
			if(n.right!=null)
				q.add(n.right);
		}
	}
	public Key findMin() throws IndexOutOfBoundsException{
		if(size <= 0) throw new IndexOutOfBoundsException("Tree is empty");
		Key result = findMin(root);
		return result;
	}

	public Key findMax() throws IndexOutOfBoundsException{
		if(size <= 0) throw new IndexOutOfBoundsException("Tree is empty");
		Key result = findMax(root);
		return result;
	}

	public void removeMin(){
		if(root!=null)
			root = removeMin(root);
	}

	public void removeMax(){
		if(root!=null)
			root =  removeMax(root);
	}

	//--------------------------------------------------------auxiliary method--------------------------------------------------------
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
	
	//check if a tree with root n contain key node
	private boolean contain(Node n, Key k){
		while(n!=null){
			if(k.compareTo(n.key)==0)
				return true;
			else if(k.compareTo(n.key)<0)
				n = n.left;
			else
				n = n.right;
		}
		return false;
	}

	//search some key and return this node or return null
	private Value search(Node n, Key k){
		while(n!=null){
			if(k.compareTo(n.key)==0)
				return n.value;
			else if(k.compareTo(n.key)<0)
				n = n.left;
			else
				n = n.right;
		}
		return null;
	}

	private void preOreder(Node n){
		if(n!=null){
			System.out.print(" "+n.key);
			preOreder(n.left);
			preOreder(n.right);
		}
	}

	private void inOrder(Node n){
		if(n!=null){
			inOrder(n.left);
			System.out.print(" "+n.key);
			inOrder(n.right);
		}
	}
	private void postOrder(Node n){
		if(n!=null){
			postOrder(n.left);
			postOrder(n.right);
			System.out.print(" "+n.key);
		}
	}

	private Key findMin(Node n){
		while(n.left!=null){ //if(n) is not valid in java
			n=n.left;
		}
		return n.key;
	}

	private Key findMax(Node n){
		while(n.right!=null){//if(n) is not valid in java
			n=n.right;
		}
		return n.key;
	}

	private Node removeMin(Node n){
		if(n.left==null){
			Node rightNode = n.right;
			n.right = null; //for garbage collection
			size--;
			return rightNode;
		}

		n.left = removeMin(n.left);
		return n.left;
	}

	private Node removeMax(Node n){
		if(n.right == null){
			Node leftNode = n.left;
			n.left = null;
			size--;
			return leftNode;
		}

		n.right = removeMax(n.right);
		return n.right;
	}
}