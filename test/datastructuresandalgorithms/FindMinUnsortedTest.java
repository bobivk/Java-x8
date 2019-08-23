package datastructuresandalgorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindMinUnsortedTest {

	@Test
	public void testArrayFrom2to5() {
		FindMinUnsorted obj = new FindMinUnsorted();
		int[] arr = {2, 3, 4, 5};
		assertEquals(new Integer(1),
				new Integer(obj.findMinUnsorted(arr, 5)));
	}
	@Test
	public void testArrayNegativeNumbers() {
		FindMinUnsorted obj = new FindMinUnsorted();
		int[] arr = {-1, -3, -5, 5};
		assertEquals(new Integer(1),
				new Integer(obj.findMinUnsorted(arr, 5)));
	}
	@Test
	public void testArrayNegativeNumbersAndZero() {
		FindMinUnsorted obj = new FindMinUnsorted();
		int[] arr = {-1, -3, -5, 0};
		assertEquals(new Integer(-1),
				new Integer(obj.findMinUnsorted(arr, 0)));
	}
	@Test
	public void testArrayNegativeNumbersAndBigNumbers() {
		FindMinUnsorted obj = new FindMinUnsorted();
		int[] arr = {-1, -3, -5, 5, 32198421, 321321321, 1, 2};
		assertEquals(new Integer(3),
				new Integer(obj.findMinUnsorted(arr, 321321321)));
	}
}
