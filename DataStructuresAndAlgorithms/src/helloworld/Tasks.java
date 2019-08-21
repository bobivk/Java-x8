package helloworld;
import java.lang.Math;
import java.util.ArrayList;
public class Tasks {
	static long pow(int base, int pow) {
		long result = base;
		for(int i = 1; i<pow; i++) {
			result*=base;
		}
		return result;
	}
	
	static long doublefac(int base) {
		long result = 1;
		for(int i = 1; i<= base; i++) {
			result *= i;
		}
		long resulttemp = result;
		System.out.println(resulttemp);
		for(int k = 1; k < resulttemp; k++) {
			result *= k;
		}
		return result;
	}
	static long kThFac(int base, int k) {
		long resulttemp = base;
		long result = 1;
		for(int m = 1; m <= k; m++) {
			result = 1;
			for(long i = 1; i <= resulttemp; i++) {
				result *= i;
				System.out.println(result);
			}
			resulttemp = result;
			System.out.println("restemp " + resulttemp);
		}
		return result;
	}
	static int[] vectorproduct(int[] vecA, int[] vecB){
		int[] vectorproduct = new int[3];
		vectorproduct[0] = vecA[1]*vecB[2] - vecA[2]*vecB[1];
		vectorproduct[1] = vecA[2]*vecB[0] - vecA[0]*vecB[2];
		vectorproduct[2] = vecA[0]*vecB[1] - vecA[1]*vecB[0];
		return vectorproduct;
	}
	static int scalarproduct(int[] vecA, int[] vecB) {
		int scalarproduct;
		scalarproduct = vecA[0]*vecB[0] + vecA[1]*vecB[1] + vecA[2]*vecB[2];
		return scalarproduct;
	}
	static int maxscalarproduct(int[] vecA, int[] vecB) {
		int maxscalarproduct = 0;
		int scalar, sum;
		for(int i = 0; i <= 2; i++) {
				scalar = scalarproduct(vecA, vecB);
				if(maxscalarproduct <= scalar) { maxscalarproduct = scalar;}
				//return Math.max();
					
			}
		return maxscalarproduct;
	}
	static int maxspan(ArrayList<Integer> numbers) {
		int maxspan = 0;
		for (int i = 0; i < numbers.size(); i++) {
			int currentNumber = numbers.get(i);
			for(int k = 0; k < numbers.size()-i; k++) {
				if(currentNumber == numbers.get(k)) {
					if(k - i > maxspan) {
						maxspan = k - i;
					}
				}
			}
		}
		return ++maxspan;
	}
}
