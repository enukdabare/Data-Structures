package DataStructures;
import java.util.LinkedList;
import java.util.Queue;

public class FIFOQueueUsingLinkedList {

	public static void main(String[] args) {
		
		Queue<Integer> queue = new LinkedList<>();
		
		//Enqueue elements to the queue
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		
		System.out.println("Elements in the queue: " +queue);
		System.out.println("Size of the queue:" +queue.size());
		System.out.println("1st Element of the queue: " +queue.peek());
		
		System.out.println();
		
		//Dequeue elements from the queue
		System.out.println("1st dequeued element: " +queue.poll());
		System.out.println("2nd dequeued element: " +queue.poll());
		System.out.println("Size of the queue after dequeue: " +queue.size());

	}

}
