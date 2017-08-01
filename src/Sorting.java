/**
*Generic tips
*using generic at class definition: when class XXX<E>, a method can use E as a type
*using generic at method definition: when class is static, using public static <T extends Comparable<T>> void sort(T[] data)
*	public static <T extends Animal> void takeTaking(ArrayList<T> list) is not public void takeThing(ArrayList<Animal>), the last one can only pass in 
*	animal array, but the first one can pass in animal object and the subclass of animal class
*/
public class Sorting{ //there is no static in class definition
	//can not new a sorting object
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
}