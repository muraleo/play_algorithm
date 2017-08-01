public class SortTest{
	public static void main(String[] args){
		Integer[] testArray = Helper.mathGenerateRandom(20, 100);
		//long start = System.currentTimeMillis();
		long start  = System.nanoTime();
		Sorting.selectionSort(testArray);
		//long end = System.currentTimeMillis();
		long end = System.nanoTime();
		Helper.printAll(testArray);
		Helper.runTime(start, end);
	}
}