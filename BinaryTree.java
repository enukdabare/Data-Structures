package DataStructures;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    
    class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;
    BinaryTree() {   // Constructor
        root = null;
    }

    // Method to insert a new node with given data
    void insert(int data) {
        root = insertLevelOrder(root, data);
    }

    // Method to insert a new node in level-order
    Node insertLevelOrder(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        // Use a queue to perform level-order traversal
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            // Insert node at the first empty left or right position
            if (temp.left == null) {
                temp.left = new Node(data);
                break;
            } else {
                queue.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = new Node(data);
                break;
            } else {
                queue.add(temp.right);
            }
        }
        return root;
    }

    // Method to perform in-order traversal of the binary tree
    void inorder() {
    	inorderMethod(root);
    }

    // Recursive method to perform in-order traversal
    void inorderMethod(Node root) {
        if (root != null) {
        	inorderMethod(root.left);
            System.out.print(root.data + ", ");
            inorderMethod(root.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Insert nodes into the tree
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("In-order traversal of general binary tree: \n");
        tree.inorder();
    }
}
