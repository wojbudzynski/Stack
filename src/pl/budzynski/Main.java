package pl.budzynski;

import pl.budzynski.stack.Stack;

import java.util.EmptyStackException;

public class Main {
    public static void main(String[] args) throws Exception {
        test();
    }
    /**
     * Sample method to test the stack
     */
    public static void test(){
        Stack<Integer> stack= new Stack<>();
        stack.push(2);
        stack.push(4);
        stack.push(1);
        stack.push(7);
        stack.push(-3);
        stack.push(1);
        stack.push(8);
        System.out.println(stack.peekMin());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.peekMin());
    }
}
