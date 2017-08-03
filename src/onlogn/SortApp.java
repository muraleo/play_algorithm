import java.lang.Math.*;
public class SortApp{
	public static Comparable FindNthMax(Comparable[] data, int n){
		return  FindNthMaxBody(data, n-1, 0, data.length-1); //because n start from 0, so use n-1
	}

	private static Comparable FindNthMaxBody(Comparable[] data, int n, int l, int r){
		if(l>=r) return data[l];
		int q = partition(data, l, r);
		Comparable result = null;
		if(n == q)
			result = data[q];
		else if(n>q)
			result = FindNthMaxBody(data, n, q+1, r);
		else
			result = FindNthMaxBody(data, n, l, q-1);
		return result;
	}

	private static int partition(Comparable[] data, int l, int r){
		int randomIndex = (int)(Math.random()*(r-l+1)+l);
		Helper.swap(data, l, randomIndex);

		Comparable v = data[l];
		int j = l;
		for(int i = l+1; i<data.length;i++){
			if(data[i].compareTo(v)<0){
				Helper.swap(data, i, j+1);
				j++;
			}
		}
		Helper.swap(data, l, j);
		return j;
	}

	public static void main(String[] args){
		Integer[] test = Helper.mathGenerateRandom(20, 100);
		Integer[] test2 = new Integer[20];
		for(int i = 0; i<test.length; i++){
			test2[i] = test[i];
		}
		Helper.printAll(test);
		//long start = System.nanoTime();
		Comparable v = FindNthMax(test2, 19);
		Sorting2.quickSort(test);
		//long end = System.nanoTime();
		//Helper.runTime(start, end);
		Helper.printAll(test);
		System.out.println("5th max number is:" +v);
	}
}