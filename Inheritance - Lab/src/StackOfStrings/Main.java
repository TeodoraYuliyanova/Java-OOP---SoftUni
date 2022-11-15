package StackOfStrings;

public class Main {
    public static void main(String[] args) {


        StackOfStrings stack = new StackOfStrings();
        stack.push("Hello");
        stack.push("World");

        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());

    }
}
