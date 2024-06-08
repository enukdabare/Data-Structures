package DataStructures;
import java.util.ArrayList;

public class FIFOQueueUsingArrayList {

public static void main(String[] args) {
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		//Enqueue elements to the queue
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		
		System.out.println("Elements in the queue: " +numbers);
		System.out.println("Size of the queue: " +numbers.size());
		System.out.println("1st Element of the queue: " +numbers.get(0));
		System.out.println();
		
		//Dequeue elements from the queue
		System.out.println("1st dequeued element: " +numbers.remove(0));
		System.out.println("2nd dequeued element: " +numbers.remove(0));
		System.out.println("Size of the queue after dequeue: " +numbers.size());
		System.out.println();
		
		//Checking elements in the queue
		System.out.println("Does element 5 contains(T/F): " +numbers.contains(5));

	}

}
