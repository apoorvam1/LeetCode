import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    // Tree has a starting node root
    Node root;

    /*
     * if the new node’s value is lower than or equal to the current node’s, we go to the left child
     * if the new node’s value is greater than the current node’s, we go to the right child
     * when the current node is null, we’ve reached a leaf node and we can insert the new node in that position
     */
    private Node insertRecursive(Node current, int value) {
        if(current == null) {
            return new Node(value);
        }

        if(value <= current.value) {
            current.left = insertRecursive(current.left, value);
        } else {
            current.right = insertRecursive(current.right, value);
        }
        return current;
    }

    public Node add(int value) {
        return insertRecursive(root, value);
    }

    /*
     * if current node is null value was not found
     * if current node's value is equal to the value return true
     * if current node's value is lower we go to the left child else go to the right child
     */
    private boolean containsNodeRecursive(Node current, int value) {
        if(current == null)
            return false;
        if(current.value == value)
            return true;
        return current.value > value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    /*
     * find the node to delete the same way as containsNode
     * if the node to be deleted has no child set it to null
     * if the node to be deleted has one child replace the node with that child
     * if it has both the children then the smallest node in the right sub tree must replace the current node
     * smallest node on the right ub tree is the leftmost node
     * assign the smallest value to the node to be deleted and delete that smallest value node from the right subtree
     */
    private Node deleteNodeRecursive(Node current, int value) {
        if(current == null)
            return null;
        if(current.value == value) {
            // if the node to be deleted has no child set it to null
            if(current.left == null && current.right == null) {
                return null;
            }
            // if the node to be deleted has one child replace the node with that child
            if(current.right == null)
                return current.left;
            if(current.left == null)
                return current.right;

            // if it has both the children then the smallest node in the right sub tree must replace the current node
            int smallestVal = findSmallestValue(current.right);
            current.value = smallestVal;
            current.right = deleteNodeRecursive(current.right, smallestVal);
            return current;
        }

        // find the node to delete the same way as containsNode
        if(current.value > value) {
            current.left = deleteNodeRecursive(current.left, value);
            return current;
        }

        current.right = deleteNodeRecursive(current.right, value);
        return current;
    }

    private int findSmallestValue(Node node) {
        // smallest node on the right ub tree is the leftmost node
        return node.left == null ? node.value :  findSmallestValue(node.left);
    }

    public Node delete(int value) {
        return deleteNodeRecursive(root, value);
    }

    /*
     * Depth First Search
     * In Order traversal
     */
    public void inOderTraversal(Node node) {
        if(node != null) {
            inOderTraversal(node.left);
            System.out.println(node.value);
            inOderTraversal(node.right);
        }
    }

    /*
     * Depth First Search
     * Pre Order traversal
     */
    public void preOderTraversal(Node node) {
        if(node != null) {
            System.out.println(node.value);
            preOderTraversal(node.left);
            preOderTraversal(node.right);
        }
    }

    /*
     * Depth First Search
     * Post Order traversal
     */
    public void postOderTraversal(Node node) {
        if(node != null) {
            postOderTraversal(node.left);
            postOderTraversal(node.right);
            System.out.println(node.value);
        }
    }

    /*
     * Breadth First Search
     * Level order traversal of the tree from left to right using queue
     */
    public void levelOrderTraversal(Node node) {
        if(node == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            Node current = queue.remove();
            System.out.println(current.value);
            if(current.left != null)
                queue.add(current.left);
            if(current.right != null)
                queue.add(current.right);
        }
    }

    
    public int getSize() {
        return getSizeRecursive(root);
    }

    /*
     * if current is null size is 0
     * else return the (sum of nodes is left sub tree + 1 (the current node) + sum of nodes in right sub tree)
     */
    private int getSizeRecursive(Node current) {
        return (current == null) ? 0 : getSizeRecursive(current.left) + 1 + getSizeRecursive(current.right);
    }
    
    private BinarySearchTree createBinarySearchTree() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(6);
        bst.add(4);
        bst.add(8);
        bst.add(3);
        bst.add(5);
        bst.add(7);
        bst.add(9);
        return bst;
    }
}
