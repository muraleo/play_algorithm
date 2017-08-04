import java.util.*;
import java.lang.Math.*;

public class MaxHeap<E extends Comparable>{
	private static final int CAPACITY = 1000; //default capacity
	private E[] data; //inner array
	private int sz = 0; //indicate the amount of element in heap

	//use in indexHeap
	private int[] heapIndex;
	private int[] reverseIndex;

	//Constructor
	MaxHeap(){this(CAPACITY);} //default constructor, have 1000 capacity, invoke next constructor
	MaxHeap(int n){		 //parameter constructor, have custom capacity
		data = (E[]) new Comparable[n]; //remember + 1!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	}
	MaxHeap(E[] arr){
		int n = arr.length;
		data = (E[]) new Comparable[n];
		for(int i = 0; i < arr.length; i++){
			data[i] = arr[i];
		}
		sz = n;
		for(int i = (n-1)/2; i>=0;i--){
			shiftDown(i);
		}
	}

	//access method
	public int size(){
		return sz;
	}
	public boolean isEmpty(){
		return sz == 0;
	}

	public void printAll(){
		for(int i=0; i<sz;i++){
			System.out.print(" "+data[i]);
		}
		System.out.println("");
	}

	public E peek() throws IndexOutOfBoundsException{ //retrieve but not remove the top one
		if(sz<0) throw new IndexOutOfBoundsException();
		return data[0];
	}

	public boolean contain(E e){
	}

	//update method
	public void add(E e) throws IllegalStateException{
		if(sz == CAPACITY) throw new IllegalStateException("Queue is full!"); //throw new!
		int index = sz;
		data[index] = e;
		sz++;
		shiftUp(index);
	}

	//common java exception
	public E poll() throws IndexOutOfBoundsException{
		if(sz<1) throw new IndexOutOfBoundsException("queue is empty");
		E result = data[0];
		data[0] = data[sz-1];
		sz--;
		shiftDown(0);	
		return result;	
	}

	//auxiliary method
	private void shiftUp(int k){
		while(k>0&&(data[k].compareTo(data[(k-1)/2])>0)){
			Helper.swap(data, k, (k-1)/2);
			k /= 2;
		}
	}

	private void shiftDown(int k){
		// while(2*i<=sz){ //hava to make sure i, 2i and 2i+1 are all exist at the same time!
		// 	System.out.println("1");
		// 	if(2*i+1<=sz&&(data[2*i].compareTo(data[2*i+1])>0)){
		// 		if(data[i].compareTo(data[2*i])<0){
		// 			Helper.swap(data, i, 2*i);
		// 			i=2*i;
		// 		}
		// 		System.out.println("2");
		// 	}else{
		// 		if(2*i+1<=sz&&(data[i].compareTo(data[2*i+1])<0)){
		// 			Helper.swap(data, i, 2*i+1);
		// 			i=2*i+1;
		// 		}
		// 		System.out.println("3");
		// 	}
		// }
		while(2*k+1<sz){
			int j = 2*k+1;
			if(j+1<sz && data[j+1].compareTo(data[j])>0)
				j++;
			if(data[k].compareTo(data[j])>0) break;
			Helper.swap(data,k,j);
			k=j;
		}
	}

	public static void main(String[] args){
		MaxHeap mh = new MaxHeap();
		for(int i = 0; i<15; i++){
			mh.add(i);
		}
		mh.printAll();
		Comparable e = mh.poll();
		mh.printAll();
		e = mh.poll();
		mh.printAll();
	}
}