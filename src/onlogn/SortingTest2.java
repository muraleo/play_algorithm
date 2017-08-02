public class SortingTest2{
	public static void main(String[] args){
		Integer[] test = Helper.mathGenerateRandom(20, 100);
		Helper.printAll(test);
		long start = System.nanoTime();
		Sorting2.quickSort(test);
		long end = System.nanoTime();
		Helper.runTime(start, end);
		Helper.printAll(test);
	}
}