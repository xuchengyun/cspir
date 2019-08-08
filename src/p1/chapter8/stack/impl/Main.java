package p1.chapter8.stack.impl;

public class Main {

    public static void main(String[] args) {
        LinkedListStackImpl<Integer> stack = new LinkedListStackImpl<>();
        stack.push(1);
        stack.print();
        System.out.println();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(stack.peek());
        stack.print();
        stack.pop();
        stack.print();
    }
}
