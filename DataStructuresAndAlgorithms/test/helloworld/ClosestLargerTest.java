package helloworld;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class ClosestLargerTest {
	@Test
	public void testClosestLarger_ascendingSortedArray() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(5);
		ClosestLarger obj = new ClosestLarger();
		obj.fillClosestLarger(arr);
		assertEquals(new Integer(2), obj.closestLargerArr.get(0));
		assertEquals(new Integer(3), obj.closestLargerArr.get(1));
		assertEquals(new Integer(5), obj.closestLargerArr.get(2));
		assertEquals(new Integer(-1), obj.closestLargerArr.get(3));
	}
}