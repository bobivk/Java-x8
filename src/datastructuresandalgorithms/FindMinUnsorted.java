package datastructuresandalgorithms;

public class FindMinUnsorted {
	int findMinUnsorted(int[] array, int max) {
		boolean[] boolArr = new boolean[max+1];
		for(int i = 0; i < array.length; i++) {
			if(array[i] >= 0) {
				boolArr[array[i]] = true;
			}
		}
		int min = -1;
		for(int i = max; i > 0; i--) {
			if(!boolArr[i]) {
				min = i;
			}
		}
		return min;
	}
}