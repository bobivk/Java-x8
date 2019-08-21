package helloworld;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ExpandBracketsTest {

	@Test
	public void testPrint() {
		ExpandBrackets test = new ExpandBrackets();
		test.numbers.push(3);
		test.numbers.push(2);
		test.numbers.push(1);
		ArrayList<Character> testArr1 = new ArrayList<Character>();
		ArrayList<Character> testArr2 = new ArrayList<Character>();
		ArrayList<Character> testArr3 = new ArrayList<Character>();
		testArr1.add('A');
		testArr1.add('B');
		testArr1.add('C');
		testArr2.add('X');
		testArr2.add('Y');
		testArr2.add('Z');
		testArr3.add('L');
		testArr3.add('M');
		testArr3.add('N');	
		test.expressions.push(testArr1);
		test.expressions.push(testArr2);
		test.expressions.push(testArr3);
		test.printExpressions(test.expressions, test.numbers);
	}

}
