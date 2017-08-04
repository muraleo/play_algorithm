import java.util.*;
import java.lang.Math.*;

public class HeapSort{
	private MaxHeap<Integer> mh = new MaxHeap<>(); //primitive type can not be in the <>

	//heap sort 1, add each element into heap then poll them into original array
	public void heapSort1(Integer[] data){
		for(int i = 0; i<data.length; i++){
			mh.add(data[i]);
		}
		for(int i = data.length-1; i>=0; i--){
			data[i] = mh.poll();
		}
	}

	public void heapSort2(Integer[] data){
		MaxHeap<Integer> mh2 = new MaxHeap<>(data);
		for(int i=data.length-1; i>=0; i--){
			data[i] = mh2.poll();
		}
	}

	public void heapSort_onSite(Integer[] data){
		int n = data.length;
		//heapify
		for(int i = (n-1-1)/2; i>=0; i--){
			shiftDown(data, n, i);
		}
		Helper.printAll(data);
		for(int i = n-1; i>0;i--){
			System.out.println("i is: "+i);
			Helper.swap(data, i, 0);
			shiftDown(data, i, 0);
			Helper.printAll(data);
		}
	}

	private void shiftDown(Comparable[] data, int sz, int k){
		while(2*k+1<sz){
			int j = 2*k+1;
			if(j+1<sz && data[j+1].compareTo(data[j])>0)
				j++;
			if(data[k].compareTo(data[j])>=0) break;
			Helper.swap(data,k,j);
			k=j;
		}
	}

	public static void main(String[] args){
		HeapSort hs = new HeapSort();
		Integer[] test = Helper.mathGenerateRandom(10, 100);
		Helper.printAll(test);
		hs.heapSort_onSite(test);
		System.out.println();
		Helper.printAll(test);
	}
}