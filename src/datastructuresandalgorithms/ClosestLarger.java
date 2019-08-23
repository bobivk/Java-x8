package helloworld;
import java.util.ArrayList;


public class ClosestLarger {
	ArrayList<Integer> arr;
	ArrayList<Integer> closestLargerArr;
	public ClosestLarger() {
	}
	public int findClosestLarger(int index) {
		int i = 0;
		while(i < arr.size()) {
			if(arr.get(index) < arr.get(i)) {
				return i;
			}
		}
		return -1;
	}
	public void fillClosestLarger(ArrayList<Integer> inputArray) {
		this.arr = inputArray;
		for(int i = 0; i < arr.size(); i++) {
			closestLargerArr.add(findClosestLarger(i));
		}

	}
}
