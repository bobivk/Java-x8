package helloworld;
import java.util.Scanner;
import java.util.ArrayList;

public class HelloWorld {
	public static void main(String[] args) {
		int a;

		Scanner in = new Scanner(System.in);
		FindMinUnsorted baba = new FindMinUnsorted();
		int max = 0;
		int length = in.nextInt();
		int[] array = new int[length];
		for(int i = 0; i < length; i++) {
			array[i] =  in.nextInt();
			if (array[i] > max) max = array[i];
			
		}
		System.out.println(baba.findMinUnsorted(array, max));
		in.close();
		
		
		
		
		
//		int disks;
//		disks = in.nextInt();
//		HanoiTower hanoi = new HanoiTower();
//		hanoi.HanoiTowerInit(disks);
//		hanoi.HanoiTowerSolve(disks);
//		
		//a = in.nextInt();
		//int b = in.nextInt();
		//ArrayList<Integer> numbers = new ArrayList();
		//String input = in.nextLine();
//		String[] inputArray = input.split(" ");
//		for(int i = 0; i < inputArray.length; i++) {
//			int c = Integer.parseInt(inputArray[i]);
//			numbers.add(c);
//		}
//		long result = Tasks.maxspan(numbers);
//		System.out.println(result);
	}
}
