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

	public static void main(String[] args){
		HeapSort hs = new HeapSort();
		Integer[] test = Helper.mathGenerateRandom(10, 100);
		Helper.printAll(test);
		hs.heapSort2(test);
		System.out.println();
		Helper.printAll(test);
	}
}