package data_structure.stack;

import java.util.Stack;

public class CustomStackMain {

    public static void main(String[] args) {
        CustomStack customStack = new CustomStack();
        customStack.push(1);
        System.out.println(customStack);
        customStack.push(2);
        System.out.println(customStack);
        customStack.push(3);
        System.out.println(customStack);
        customStack.push(4);
        System.out.println(customStack);
        customStack.pop();
        System.out.println(customStack);
        customStack.pop();
        System.out.println(customStack);
        customStack.pop();
        System.out.println(customStack);
        customStack.pop();
        System.out.println(customStack);
    }
}
