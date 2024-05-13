package data_structure.stack;

import java.util.Stack;

public class CustomStackMain {

    public static void main(String[] args) {
        CustomStack customStack = new CustomStack();
        customStack.push(1);
        customStack.push(2);
        customStack.push(3);
        customStack.push(4);
        Object pop1 = customStack.pop();
        System.out.println(pop1);
        Object pop2 = customStack.pop();
        System.out.println(pop2);
        Object pop3 = customStack.pop();
        System.out.println(pop3);
        Object pop4 = customStack.pop();
        System.out.println(pop4);
        System.out.println(customStack);
    }
}
