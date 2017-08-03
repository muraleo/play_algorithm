import java.util.*;
import java.lang.Math.*;

public class MaxHeap<E extends Comparable>{
	private static final int CAPACITY = 1000; //default capacity
	public E[] data; //inner array
	private int sz = 0; //indicate the amount of element in heap

	//Constructor
	MaxHeap(){this(CAPACITY+1);} //default constructor, have 1000 capacity, invoke next constructor
	MaxHeap(int n){		 //parameter constructor, have custom capacity
		data = (E[]) new Comparable[n+1]; //remember + 1!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	}

	//access method
	public int size(){
		return sz;
	}
	public boolean isEmpty(){
		return sz == 0;
	}

	public void printAll(){
		for(int i=1; i<=sz;i++){
			System.out.print(" "+data[i]);
		}
		System.out.println("");
	}

	public E peek() throws IndexOutOfBoundsException{ //retrieve but not remove the top one
		if(sz<0) throw new IndexOutOfBoundsException();
		return data[1];

	}

	//update method
	public void add(E e) throws IllegalStateException{
		if(sz == CAPACITY) throw new IllegalStateException("Queue is full!"); //throw new!
		int index = ++sz;
		data[index] = e;
		shiftUp(index);
	}

	//common java exception
	public E poll() throws IndexOutOfBoundsException{
		if(sz<1) throw new IndexOutOfBoundsException("queue is empty");
		E result = data[1];
		data[1] = data[--sz];
		shiftDown(1);	
		return result;	
	}

	//auxiliary method
	private void shiftUp(int k){
		while(k>1&&(data[k].compareTo(data[k/2])>0)){
			Helper.swap(data, k, k/2);
			k /= 2;
		}
	}

	private void shiftDown(int i){
		while(sz>1&&2*i<=sz){ //hava to make sure i, 2i and 2i+1 are all exist at the same time!
			if(data[2*i].compareTo(data[2*i+1])>0){
				if(data[i].compareTo(data[2*i])<0){
					Helper.swap(data, i, 2*i);
					i+=i;
				}
			}else{
				if(data[i].compareTo(data[2*i+1])<0){
					Helper.swap(data, i, 2*i+1);
					i=2*i+1;
				}
			}
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