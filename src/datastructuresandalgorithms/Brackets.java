package datastructuresandalgorithms;

import java.util.Stack;

public class Brackets {
    Stack<Character> stack;
    public Brackets(Stack stack){
    	this.stack = new Stack<Character>();
    }
    public Character opposite(Character bracket) {
    	if(bracket.equals(')')) return '(';
    	if(bracket.equals(']')) return '[';
    	if(bracket.equals('}')) return '{';
    	else return null;
    }
    public void addBracket(Character bracket) {
    	if(bracket.equals(')') || bracket.equals('(') || bracket.equals('{') ||
    			bracket.equals('}') || bracket.equals('[') || bracket.equals(']')) {
    		if(!(this.stack.isEmpty())) {
    			if(this.stack.peek().equals(opposite(bracket))) {
    				stack.pop();
    			}
    			else this.stack.push(bracket);
    		}
    		else {
    			this.stack.push(bracket);
    		}
    	}
    }
    public boolean parseBrackets(String in) {
    	for (int i = 0; i < in.length(); i++) {
    		addBracket(in.charAt(i));
    	}
    	return this.stack.isEmpty();
    }
    public boolean check() {
    	return false;
    }
    
    
    
    
    
   // first implementation working for normal brackets "()"

//    public boolean check(){
//        int close = 0;
//        int open = 0;
//        while(!stack.isEmpty()){
//            if(stack.peek().equals(')')){
//                close++;
//                stack.pop();
//            } else {
//                open++;
//                close--;
//                stack.pop();
//            }
//        }
//        if(close == 0 && open == 0) return true;
//        else return false;
//    }
}

