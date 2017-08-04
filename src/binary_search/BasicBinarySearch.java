import java.util.*;

public class BasicBinarySearch<E extends Comparable>{
	public Comparable basicBinarySearch(E[] data, E target){
		//arr[mid,n-1] > target
		int r = data.length-1;
		//arr[i,mid] < target
		int l = 0;
		while(l<=r){
			int mid = l + (r-l)/2; //this way is better than (r+l)/2, the latter may overflow
			if(data[mid].compareTo(target)==0)
				return data[mid];
			else if(data[mid].compareTo(target)>0){
				r = mid-1;
			}else{
				l = mid +1;
			}
		}
		return null;
	}

	public static void main(String[] args){
		BasicBinarySearch<Integer> bbs = new BasicBinarySearch<>();
		Integer[] test = new Integer[100];
		for(int i = 0;i<100;i++){
			test[i] = i;
		}
		Helper.printAll(test);
		Integer target = (int)(Math.random()*100);
		Comparable e = bbs.basicBinarySearch(test, 101);
		System.out.println("target is "+target+"e is :"+e);
	}
}