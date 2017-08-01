/**
*Generic tips
*using generic at class definition: when class XXX<E>, a method can use E as a type
*using generic at method definition: when class is static, using public static <T extends Comparable<T>> void sort(T[] data)
*	public static <T extends Animal> void takeTaking(ArrayList<T> list) is not public void takeThing(ArrayList<Animal>), the last one can only pass in 
*	animal array, but the first one can pass in animal object and the subclass of animal class
*/
public class Sorting{ //there is no static in class definition
	//can not new a sorting object

/*----------------------------------------------------------------O(n^2) sorting algorithm--------------------------------------------------------------------*/
	private Sorting(){};

	public static <T extends Comparable<T>> void selectionSort(T[] data){ //here extends can means implements or extends
		for(int i = 0; i< data.length; i++){
			int minIndex = i;
			for(int j = i+1; j<data.length; j++){
				if(data[minIndex].compareTo(data[j])>0) //can custom compareTo() method
					minIndex = j;
			}
			Helper.swap(data, minIndex, i);
		}
	}
/**
*ways to compare
*way 1: implements Comparable<T> interface, then override compareTo() method
*way 2: create a inner class implements Comparator<T>, then in this class, override int compare(T t1, T t2) method, 
*	 then make an instance of compare inner class, then invoke method and pass in compare instance as second parameter.
*/


	//insertionSort
	public static <T extends Comparable<T>> void insertionSort(T[] data){
		for(int i = 1; i<data.length; i++){
			T temp = data[i];
			int j = i-1;
			while(j>=0 && temp.compareTo(data[j])<0){
				data[j+1] = data[j];
				j--;
			}
			data[j+1] = temp;
		}
	}

	//bubble sort
	public static <T extends Comparable<T>> void bubbleSort(T[] data){
		for(int i = data.length-1; i>0; i--){
			for(int j = 0; j<i;j++){
				if(data[j].compareTo(data[j+1])>0)
					Helper.swap(data, j, j+1);
			}
		}
	}

	//shell sort from wiki pedia
	public static void shell_sort(int[] arr) {
		int gap = 1, i, j, len = arr.length;
		int temp;
		while (gap < len / 3)
			gap = gap * 3 + 1; // <O(n^(3/2)) by Knuth,1973>: 1, 4, 13, 40, 121, ...
		for (; gap > 0; gap /= 3)
			for (i = gap; i < len; i++) {
				temp = arr[i];
				for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap)
					arr[j + gap] = arr[j];
				arr[j + gap] = temp;
			}
	}

}//end of class