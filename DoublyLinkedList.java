package DataStructures;

public class DoublyLinkedList {
	
public class Node {
	    int data;
	    Node prev;
	    Node next;

	public Node(int data) {
	        this.data = data;
	        this.prev = null;
	        this.next = null;
	    }
	}
	
    Node head;
    Node tail;
    Node prev;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.prev = null;
    }

    // Insert a node at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Element added from head: " +data);
    }
    
  //Insert a new node at the end.
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        }else {
        Node current = head;
        while (current.next != null) {
        	current = current.next;
        }
        newNode.prev = current;
        current.next = newNode;
        tail = newNode;
        System.out.println("Element added from tail: " +data);
    }
    }
    
  //Insert a new node in the middle.
    public void insertAtMiddle(int data, int position) {
        if (position <= 1) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            insertAtEnd(data);
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
        System.out.println("Element " +data + " added from position " +position);
    }
    
  //Delete a node from the beginning.
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
            System.out.println("Head node deleted");
        }
    }

    //Delete a node from the end.
    public void deleteFromEnd() {
        if (head == null) {  
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null) {  
            head = null; 
            tail = null; 
            System.out.println("Last node deleted"); 
            return; 
        }
        Node last = tail; 
        tail = last.prev;  
        tail.next = null;  

        System.out.println("Last node deleted");
    }

    //Delete a node from the middle.
    public void deleteFromMiddle(int position) {
        if (head == null || position <= 1) {
            deleteFromBeginning();
            return;
        }

        Node current = head;
        for (int i = 1; i < position && current != null; i++) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            deleteFromEnd();
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
            System.out.println("Node deleted from position " +position);
        }
    }
    
    //Display the output
    public void display() {
        Node current = head; 
        while (current != null) {
            System.out.print(current.data + ",");
            current = current.next;
        }
        System.out.println(" ");
    }



    // Method to traverse the list forward
    public void traverseForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    // Method to traverse the list backward
    public void traverseBackward() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtBeginning(1);
        list.insertAtBeginning(2);
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        list.insertAtMiddle(9, 3);
        System.out.println("Elements at the list after adding: ");
        list.display();
        System.out.println();
        list.deleteFromBeginning();
        list.deleteFromEnd();
        list.deleteFromMiddle(2);
        System.out.println("Elements at the list after deleting: ");
        list.display();
       
       
        System.out.print("\nForward traversal of list: ");
        list.traverseForward();

        System.out.print("\nBackward traversal of list: ");
        list.traverseBackward();
    }
}

