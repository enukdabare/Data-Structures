package DataStructures;

import java.util.Arrays;

public class CircularQueue<E> {
	private E[] circular;
	private int head;
	private int tail;
	private int queueSize;
	
	CircularQueue(int size){
		circular = (E[])new Object[size];
		head = -1;
		tail = -1;
		queueSize = 0;
	}
	
	private E dequeue() throws Exception{
		if(isQueueEmpty()) {
			throw new Exception("Queue is Empty");
		}
		E dequeuedElement = circular[head];
		circular[head] = null;
		head = (head+1)%circular.length;
		queueSize--;
		return dequeuedElement;
	}
	
	private void enqueue(E item) throws Exception {
		if(isQueueFull()) {
			throw new Exception("Queue is Full");
		}
		tail = (tail+1)%circular.length;
		circular[tail] = item;
		queueSize++;
		
		if(head==-1) {
			head++;
		}
	}
	private boolean isQueueFull() {
		if(queueSize == circular.length) {
			return true;
		}
		return false;
	}
	
	private boolean isQueueEmpty() {
		if(queueSize == 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		CircularQueue<Integer> queue = new CircularQueue<Integer>(5);
		queue.enqueue(10);
		queue.enqueue(11);
		queue.enqueue(12);
		queue.enqueue(13);
		queue.enqueue(14);
		//queue.enqueue(15); cannot be entered because the queue is full. Throws an exception
		System.out.println("Circular Queue is: " +queue);
		
		System.out.println("Dequeued element is: " +queue.dequeue());
		System.out.println("Dequeued element is: " +queue.dequeue());
		System.out.println("Dequeued element is: " +queue.dequeue());
		System.out.println("Dequeued element is: " +queue.dequeue());
		System.out.println("Dequeued element is: " +queue.dequeue());
		//System.out.println("Dequeued element is: " +queue.dequeue()); cannot be dequeued because the queue is empty. Throws an exception
		System.out.println("Circular Queue is: " +queue);
		
		//Entering new elements after deletion of existing elements
		queue.enqueue(15);
		System.out.println("Circular Queue is: " +queue);
	}

	@Override
	public String toString() {
		return "CircularQueue [circular=" + Arrays.toString(circular) + ", head=" + head + ", tail=" + tail
				+ ", queueSize=" + queueSize + "]";
	}

	
}
