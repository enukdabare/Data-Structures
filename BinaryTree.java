package DataStructures;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    // TreeNode class to represent each node in the binary tree
    class TreeNode {
        int value;
        TreeNode leftChild, rightChild;

        public TreeNode(int val) {
            value = val;
            leftChild = rightChild = null;
        }
    }

    // CustomBinaryTree class to represent the entire tree
    TreeNode rootNode;

    // Constructor
    BinaryTree() {
        rootNode = null;
    }

    // Method to insert a new node with given value
    void addNode(int value) {
        rootNode = insertLevelOrder(rootNode, value);
    }

    // Method to insert a new node in level-order
    TreeNode insertLevelOrder(TreeNode currentNode, int value) {
        if (currentNode == null) {
            return new TreeNode(value);
        }

        // Use a queue to perform level-order traversal
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(currentNode);

        while (!nodeQueue.isEmpty()) {
            TreeNode tempNode = nodeQueue.poll();

            // Insert node at the first empty left or right position
            if (tempNode.leftChild == null) {
                tempNode.leftChild = new TreeNode(value);
                break;
            } else {
                nodeQueue.add(tempNode.leftChild);
            }

            if (tempNode.rightChild == null) {
                tempNode.rightChild = new TreeNode(value);
                break;
            } else {
                nodeQueue.add(tempNode.rightChild);
            }
        }
        return currentNode;
    }

    // Method to delete a node with the given value
    void removeNode(int value) {
        rootNode = deleteNode(rootNode, value);
    }

    // Method to delete the node with given value in a binary tree
    TreeNode deleteNode(TreeNode currentNode, int value) {
        if (currentNode == null) {
            return null;
        }

        if (currentNode.value == value) {
            return deleteRootNode(currentNode);
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(currentNode);

        while (!nodeQueue.isEmpty()) {
            TreeNode tempNode = nodeQueue.poll();

            if (tempNode.leftChild != null) {
                if (tempNode.leftChild.value == value) {
                    tempNode.leftChild = deleteRootNode(tempNode.leftChild);
                    break;
                } else {
                    nodeQueue.add(tempNode.leftChild);
                }
            }

            if (tempNode.rightChild != null) {
                if (tempNode.rightChild.value == value) {
                    tempNode.rightChild = deleteRootNode(tempNode.rightChild);
                    break;
                } else {
                    nodeQueue.add(tempNode.rightChild);
                }
            }
        }
        return currentNode;
    }

    // Method to delete the root node
    TreeNode deleteRootNode(TreeNode currentNode) {
        if (currentNode == null) {
            return null;
        }

        if (currentNode.leftChild == null && currentNode.rightChild == null) {
            return null;
        }

        if (currentNode.leftChild == null) {
            return currentNode.rightChild;
        }

        if (currentNode.rightChild == null) {
            return currentNode.leftChild;
        }

        TreeNode deepestRightmost = getDeepestRightmostNode(currentNode);
        int deepestValue = deepestRightmost.value;
        deleteNode(currentNode, deepestValue);
        currentNode.value = deepestValue;
        return currentNode;
    }

    // Get the deepest rightmost node
    TreeNode getDeepestRightmostNode(TreeNode currentNode) {
        TreeNode tempNode = null;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(currentNode);

        while (!nodeQueue.isEmpty()) {
            tempNode = nodeQueue.poll();
            if (tempNode.leftChild != null) {
                nodeQueue.add(tempNode.leftChild);
            }
            if (tempNode.rightChild != null) {
                nodeQueue.add(tempNode.rightChild);
            }
        }
        return tempNode;
    }

    // Recursive method to perform in-order traversal
    void inOrderTraversal() {
        inOrderRec(rootNode);
        System.out.println();
    }

    void inOrderRec(TreeNode currentNode) {
        if (currentNode != null) {
            inOrderRec(currentNode.leftChild);
            System.out.print(currentNode.value + " ");
            inOrderRec(currentNode.rightChild);
        }
    }

    // Recursive method to perform pre-order traversal
    void preOrderTraversal() {
        preOrderRec(rootNode);
        System.out.println();
    }

    void preOrderRec(TreeNode currentNode) {
        if (currentNode != null) {
            System.out.print(currentNode.value + " ");
            preOrderRec(currentNode.leftChild);
            preOrderRec(currentNode.rightChild);
        }
    }

    // Recursive method to perform post-order traversal
    void postOrderTraversal() {
        postOrderRec(rootNode);
        System.out.println();
    }

    void postOrderRec(TreeNode currentNode) {
        if (currentNode != null) {
            postOrderRec(currentNode.leftChild);
            postOrderRec(currentNode.rightChild);
            System.out.print(currentNode.value + " ");
        }
    }

    public static void main(String[] args) {
    	BinaryTree tree = new BinaryTree();

        // Insert nodes into the tree
        tree.addNode(4);
        tree.addNode(10);
        tree.addNode(60);
        tree.addNode(8);
        tree.addNode(25);
        tree.addNode(5);
        tree.addNode(100);

        System.out.println("In-order traversal:");
        tree.inOrderTraversal();

        System.out.println("Pre-order traversal:");
        tree.preOrderTraversal();

        System.out.println("Post-order traversal:");
        tree.postOrderTraversal();

        // Deleting a node
        tree.removeNode(5);
        System.out.println("In-order traversal after deleting 40:");
        tree.inOrderTraversal();
    }
}


