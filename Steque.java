package DataStructures;

public class Steque<Item> {
	
	    private Node first = null;
	    private Node last = null;

	    private class Node {
	        Item item;
	        Node next;
	    }

	    public boolean isEmpty() {
	        return first == null;
	    }

	    public void push(Item item) {
	        Node oldFirst = first;
	        first = new Node();
	        first.item = item;
	        first.next = oldFirst;
	        if (last == null) {
	            last = first;
	        }
	    }

	    public Item pop() {
	        if (isEmpty()) throw new RuntimeException("Steque underflow");
	        Item item = first.item;
	        first = first.next;
	        if (first == null) {
	            last = null;
	        }
	        return item;
	    }

	    public void enqueue(Item item) {
	        Node oldLast = last;
	        last = new Node();
	        last.item = item;
	        last.next = null;
	        if (isEmpty()) {
	            first = last;
	        } else {
	            oldLast.next = last;
	        }
	    }


	public static void main(String[] args) {
		    Steque<Integer> steque = new Steque<Integer>();
		    
		    steque.push(1);
		    steque.push(2);
		    steque.enqueue(3);
		    
		    while (!steque.isEmpty()) {
		        System.out.println(steque.pop());
		    }

	}

}
