package helloworld;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

import helloworld.Brackets;

public class BracketsTest {
	Stack stack = new Stack<Character>();
	Brackets brackets = new Brackets(stack);
	@Test
	public void bracketsCorrectnessTest() {
		assertTrue(brackets.parseBrackets("()()"));	
	}
	@Test
	public void bracketCorrectness_EmptyString_True() {
	        assertTrue(brackets.parseBrackets(""));
	    }

	    @Test
	public void bracketCorrectness_OneOpeningBracket_False(){

	       assertFalse(brackets.parseBrackets("("));
	    }

	    @Test
	public void bracketCorrectness_OneClosingBracket_False(){

	        assertFalse(brackets.parseBrackets(")"));
	    }

	    @Test
	public void bracketCorrectness_WrongString_False(){

	        assertFalse(brackets.parseBrackets("(x+1)[x+2)]"));
	    }

	    @Test
	public void bracketCorrectness_CorrectString_True(){

	        assertTrue(brackets.parseBrackets("([{x+1}]) + (x + 1)[]"));
	    }

	    @Test
	public void bracketCorrectness_FuckedUpString_True(){
	        assertTrue(brackets.parseBrackets("asidjasoidh21873981273!@#&^!@%&*%&@!$_(*&#@+!@_+_)#@&\n[]"));
	    }
}
