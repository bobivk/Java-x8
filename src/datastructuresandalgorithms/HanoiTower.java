package helloworld;
import java.util.Stack;
public class HanoiTower {
	Stack<Integer> A = new Stack<Integer>();
	Stack<Integer> B = new Stack<Integer>();
	Stack<Integer> C = new Stack<Integer>();
	void HanoiTowerInit(int disks) {
		for(int i = disks; i >= 1; i--) {
			A.push(i);
		}
	}
	void HanoiTowerSolve(int disks) {
		if(disks %2 == 0) {
			while(C.size() != disks) {
				int first = A.peek();
				A.pop();
				B.add(first);
				System.out.println(first+ " moved from A to B");
				int second = A.peek();
				A.pop();
				C.add(second);
				System.out.println(second+ " moved from A to C");
				int third = B.peek();
				B.pop();
				C.add(third);
				System.out.println(third+ " moved from B to C");
			}
		}else {
			while(C.size() != disks) {
				int first = A.peek();
				A.pop();
				C.add(first);
				System.out.println(first+ " moved from A to C");
				int second = A.peek();
				A.pop();
				B.add(second);
				System.out.println(second+ " moved from A to B");
				int third = B.peek();
				B.pop();
				C.add(third);
				System.out.println(third+ " moved from B to C");
			}
		}
		System.out.println("ended");
	}
}
