package DataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
	private Queue<Integer> q1 = new LinkedList<>();
	private Queue<Integer> q2 = new LinkedList<>();
	
	public void push(int x) {
		//insert new element in q2
		q2.add(x);
		
		//take all elements from q1 and insert to q2
		while(!q1.isEmpty()) {
			q2.add(q1.remove());
		}
		
		//swap(q1, q2)
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
	}
	
	public int pop() {
		return q1.remove();
		
	}

	public int top() {
		return q1.peek();
	
	}
	
	public int size() {
		return q1.size();
		
	
	}
	
	public static void main(String[] args) {
		// Implementation of stack using queue
		StackUsingQueues s = new StackUsingQueues();
		s.push(58);
		s.push(98);
		s.push(100);
		
		System.out.println("Current Size: " +s.size());
		System.out.println();
		System.out.println("Element popped at first: " +s.pop());
		System.out.println("Element popped at second: " +s.pop());
		System.out.println("Element popped at last: " +s.top());
			
		}
	}


