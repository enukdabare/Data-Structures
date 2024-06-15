package DataStructures;
import java.util.Scanner;

public class SinglyLinkedList {
    //Inner Node class.
    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    //Insert a new node at the beginning.
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        System.out.println("Element added from head: " +data);
    }

    //Insert a new node at the end.
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
        System.out.println("Element added from tail: " +data);
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
            System.out.println("Element " +data + " added from position " +position);
        }

        if (current == null || current.next == null) {
            insertAtEnd(data);
            return;
        } else {
            newNode.next = current.next;
            current.next = newNode;
            System.out.println("Element " +data + " added from position: " +position);
        }
    }

    //Delete a node from the beginning
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
        System.out.println("Head node deleted");
    }

    //Delete a node from the end
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node secondLast = head;
        while (secondLast.next.next != null) {
            secondLast = secondLast.next;
        }
        secondLast.next = null;
        System.out.println("Last node deleted");
    }

    //Delete a node from the middle
    public void deleteFromPosition(int position) {
        if (head == null || position <= 1) {
            deleteFromBeginning();
            return;
        }

        Node current = head;
        for (int i = 1; i < position - 1 && current != null && current.next != null; i++) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            deleteFromEnd();
        } else {
            current.next = current.next.next;
            System.out.println("Node deleted from position " +position);
        }
    }

    //Display the linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtBeginning(10);
        list.insertAtBeginning(3);
        list.insertAtBeginning(2);
        list.insertAtMiddle(5, 2);
        list.insertAtEnd(6);
        list.deleteFromBeginning();
        list.deleteFromEnd();
        list.deleteFromPosition(2);
        list.display();
    }
}
