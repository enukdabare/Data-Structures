package DataStructures;

import java.util.ArrayDeque;
import java.util.Deque;

class StackUsingDeque {
    Deque<Integer> stack = new ArrayDeque<>();;

    public void push(int element) {
        stack.addFirst(element); 
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        }
        return stack.removeFirst();
    }

    public int top() {
        if (isEmpty()) {
        	System.out.println("Stack is empty");
        }
        return stack.peek(); 
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public static void main(String[] args) {
        StackUsingDeque stack = new StackUsingDeque();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack size: " + stack.size());
        System.out.println("Top element: " + stack.top());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack size after popping: " + stack.size());
        System.out.println("Top element: " + stack.top());
    }
}
