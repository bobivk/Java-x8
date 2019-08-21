package helloworld;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack stack = new Stack<Character>();
        String in = scanner.nextLine();
        for(int i = 0; i < in.length(); i++){
            stack.push(in.charAt(i));
        }
        Brackets brackets = new Brackets(stack);
        boolean result = brackets.check();
        System.out.println(result);
    }
}
