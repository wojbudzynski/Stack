package pl.budzynski;

import pl.budzynski.stack.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        Stack<Integer> stack= new Stack<>();
        stack.push(2);
        stack.push(4);
        stack.push(1);
        stack.push(7);
        stack.push(3);
        stack.push(1);
        stack.push(8);
        System.out.println(stack.toString());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.toString());
    }
}
