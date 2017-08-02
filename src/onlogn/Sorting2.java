import java.lang.Math.*;
public class Sorting2{
	//this class has no instance
	private Sorting2(){};

	//Merge sort
	public static void mergeSort(Comparable[] data){
		mergeSortBody(data, 0, data.length-1);
	}

	private static void mergeSortBody(Comparable[] data, int l, int r){

		//when
		if(l<r){

			int mid = (l+r)/2; // mit = (l+r)/2 is not good enough. because when l and r are too large, l + r may larger than max int
			//System.out.println("mid is "+mid);

			//divide part
			mergeSortBody(data, l, mid);
			mergeSortBody(data, mid+1, r);

			//conquer part
			merge(data, l, mid, r);
		}
	}

	//in this place, we can use Comparable[] to replace generic type, because T[] temp = new T[n] is illegal
	private static void merge(Comparable[] data, int l, int mid, int r){
		Comparable[] temp = new Comparable[r-l+1]; 
		for(int i = l; i<=r; i++){
			temp[i-l] = data[i];
		}
		int i = l, j = mid +1;
		for(int k = l; k<=r; k++){
			if(i>mid){
				data[k] = temp[j-l];
				j++;
			}else if(j>r){
				data[k] = temp[i-l];
				i++;
			}else if(temp[i-l].compareTo(temp[j-l])>0){
				data[k] = temp[j-l];
				j++;
			}else{
				data[k] = temp[i-l];
				i++;
			}
		}
	}

	//mergeSort bottom up
	//doesn't use index to access element, so is suitable for link
	public static void mergeSortBU(Comparable[] data){
		for(int sz = 1; sz<data.length; sz+=sz){
			for(int i = 0; i+sz<data.length; i += sz+sz){
				//mid = i+sz-1 r = i+sz-1+sz
				merge(data, i, i+sz-1, Math.min(i+sz+sz-1, data.length-1));
			}
		}
	}

	//------------------------------------------------Quick Sort---------------------------------------------------------
	public static void quickSort(Comparable[] data){
		quickSortBody(data, 0, data.length-1);
	}

	private static void quickSortBody(Comparable[] data, int l, int r){
		if(l>r)
			return;
		int q = partition(data, l, r);
		mergeSortBody(data, l, q-1);
		mergeSortBody(data, q+1, r);
	}

	private static int partition(Comparable[] data, int l, int r){
		//random-partition---apply to nearly ordered situation
		int randomIndex = (int)(Math.random()*(r-l+1)+l);
		Helper.swap(data, l, randomIndex);
		//random-partition

		Comparable v = data[l];
		int j = l;
		for(int i = l+1; i<data.length; i++){
			if(v.compareTo(data[i])>0){
				Helper.swap(data, i, j+1);
				j++;
			}
		}
		Helper.swap(data, l, j);
		return j;
	}
}