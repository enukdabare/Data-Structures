package DataStructures;

import java.util.LinkedList;

class StackUsingList{
    LinkedList<Integer> stack = new LinkedList<>();

    public void push(int element) {
        stack.push(element);
    }

    public int pop() {
        if (isEmpty()) {
        	System.out.println("Stack is empty");
        }
        return stack.pop();
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
        StackUsingList stack = new StackUsingList();
        stack.push(100);
        stack.push(200);
        stack.push(300);

        System.out.println("Stack size: " + stack.size());
        System.out.println("Top element: " + stack.top());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack size after popping: " + stack.size());
        System.out.println("Top element: " + stack.top());
    }
}
