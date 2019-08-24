package datastructuresandalgorithms;
import java.util.ArrayList;
import java.util.Stack;

public class ExpandBrackets {
	ArrayList<Character> currentExpression = new ArrayList<Character>();
	Stack<ArrayList<Character>> expressions = new Stack<ArrayList<Character>>();
	Stack<Integer> numbers = new Stack<Integer>();
	public void parseExpression(String input) {
		for(int i = 0; i < input.length(); i++) {
			char current = input.charAt(i);
			// when current is a number
			if(current > 48 && current < 58) {
				numbers.push((int) current);
			}
			//when current is a character a-z
			if(current >= 97 && current <= 122) {
				currentExpression.add(current);
			}
			if(current == '(') {
				//if there were any characters a-z before (
				//add them to stack and clear currentExpression
				if(!currentExpression.isEmpty()) {
					expressions.add(currentExpression);
					currentExpression.clear();
				}
				//cycle through expression in parentheses
				for(int j = i+1; j <= input.length(); j++) {
					char currentChar = input.charAt(j);
					if(currentChar == '(') {
						//TODO what happens
					}
					if(currentChar != ')') {
						currentExpression.add(currentChar);
					}
					else {
						expressions.push(currentExpression);
					}
				}
			}
		}
	}
	public void printExpressions(Stack<ArrayList<Character>> expressions, Stack<Integer> numbers) {
		while(!expressions.isEmpty()) {
			for(int j = 0; j < expressions.size(); j++) {	
				if(!numbers.isEmpty()) {
					int times = numbers.peek();
					for(int i = 0; i < times; i++) {
						for(int k = 0; k < expressions.peek().size(); k++) {
							System.out.print(expressions.peek().get(k));
						}
					}
					expressions.pop();
					numbers.pop();
				}
			}
		}
	}
}