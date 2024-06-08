package DataStructures;

import java.util.Stack;

public class FIFOQueueUsingStack {
	
	Stack<Integer> stack1 = new Stack();
	Stack<Integer> stack2 = new Stack();
	
	 public void push(int x) {
	        stack1.push(x); 
	    }

	    public int pop() {
	        while (stack1.size() > 1) {
	            stack2.push(stack1.pop());
	        }
	        int data = stack1.pop();
	        while(!stack2.isEmpty()) {
	        	stack1.push(stack2.pop());
	        }
	        return data;
	    }

	    public int peek() {
	    	while (stack1.size() > 1) {
	            stack2.push(stack1.pop());
	        }
	        int data = stack1.peek();
	        while(!stack2.isEmpty()) {
	        	stack1.push(stack2.pop());
	        }
	        return data; 
	    }

	    public boolean isEmpty() {
	        return stack1.size() == 0;
	    }
	    
	    public int size() {
	        return stack1.size();
	    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FIFOQueueUsingStack queue = new FIFOQueueUsingStack();
		queue.push(10);
		queue.push(11);
		queue.push(12);
		queue.push(13);
		queue.push(14);
		
		System.out.println("Front Element of Queue: " +queue.peek());
		System.out.println("Size of the Queue: " +queue.size());
		System.out.println("Popped 1st Element: " + queue.pop());
		System.out.println("Popped 2nd Element: " +queue.pop());
	}

}
