import java.util.*;
import java.lang.Math.*;

public class Helper{
//Helper class can not be initialized
	private Helper(){};

//use Math.random() to generate random numbers
	public static Integer[] mathGenerateRandom(int size, int range){
		assert range > 1 && size > 0;
		//initialize a Integer array with length uses new Integer[n] without ()
		Integer[] temp = new Integer[size];
		for(int i = 0; i<size; i++){
			temp[i]=new Integer((int)(Math.random()*range));
		}
		return temp;
	}

//printAll method to print whole array
	public static void printAll(Object[] arr){
		for(Object o: arr){
			System.out.print(o.toString()+" ");
		}
		System.out.println();
	}

//calculate running time of program
//	use System.currentTimeMillis() or System.nanoTime()
	public static void runTime(long startTime, long endTime){
		double duration = (endTime - startTime)*1.0/1000000;
		System.out.println("This program's elapsed time is: "+duration+" ms.");
	}

//swap method
	public static void swap(Object[] data, int i, int j){
		Object temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
}