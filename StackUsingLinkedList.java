package DataStructures;

public class StackUsingLinkedList {
	
	class Node {
	    int data;
	    Node next;

	    Node(int data) {
	        this.data = data;
	        this.next = null;
	    }
	}
    private Node top;

    public StackUsingLinkedList() {
        this.top = null;
    }

    // Push an element onto the stack
    public void push(int data) {
        Node newNode = new Node(data);
        if (top != null) {
            newNode.next = top;
        }
        top = newNode;
        System.out.println(data + " pushed into stack.");
    }

    // Pop an element from the stack
    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return -1;
        }
        int poppedData = top.data;
        top = top.next;
        System.out.println(poppedData + " popped from stack.");
        return poppedData;
    }

    // Peek the top element of the stack
    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return top.data;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Display the stack elements
    public void display() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return;
        }
        Node current = top;
        System.out.println("Stack elements: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display(); 
        System.out.println("Top element is: " + stack.peek()); 
        stack.pop();
        stack.display(); 
        System.out.println("Top element is: " + stack.peek()); 
        stack.pop(); 
        stack.pop(); 
        stack.pop(); //Displays stack is empty
    }
}
