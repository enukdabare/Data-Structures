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
        if (head == null) {  // Step 1: Check if the list is empty
            System.out.println("List is empty.");
            return;  // If the list is empty, print a message and exit the method
        }

        if (head.next == null) {  // Step 2: Check if there is only one node in the list
            head = null;  // If there's only one node, set head to null
            tail = null;  // Also set tail to null because the list will be empty after deletion
            System.out.println("Last node deleted");  // Print a message
            return;  // Exit the method
        }

        // Step 3: If there are multiple nodes in the list
        Node last = tail;  // Start from the tail node
        tail = last.prev;  // Update the tail to be the previous node
        tail.next = null;  // Set the new tail's next pointer to null

        System.out.println("Last node deleted");  // Print a message indicating the last node was deleted
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

