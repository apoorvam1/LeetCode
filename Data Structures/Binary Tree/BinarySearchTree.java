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
     * Depth First Search With Stack
     * Iterative In Order traversal
     */
    public void inOrderTraversalIterative(Node node) {
        if(node == null)
            return;
        Stack<Node> s = new Stack<>();
        Node cur = node;
        
        // As it's depth first search traversal, travel deep into the tree in in-order
        whie(cur != null || !s.isEmpty()) {
            
            // traverse left sub tree
            while(cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            
            // print current node
            cur = s.pop();
            System.out.println(cur.val);
            
            // traverse right sub tree
            cur = cur.right;
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

    /*
     * Get the numbers of nodes in a tree
     */
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
    
    public int getDepth() {
        return getDepthRecursiveTopToBottom(root, 0, 0);  
    }
    
    /*
     *  Get the maximum depth/height of a tree top-down approach
     *  Handle base case
     *  Recalculate return value on condition
     *  Calculate the result recursive on left sub tree & right sub tree
     */
    private int getDepthRecursiveTopToBottom(Node current, int depth, int maxDepth) {
        if(current == null)
            return maxDepth;
        if(current.left == null && current.right == null) {
            maxDepth = Math.max(depth, maxDepth);   
        }
        getDepthRecursiveTopToBottom(current.left, depth+1);
        getDepthRecursiveTopToBottom(current.right, depth+1);
    }
    
    /*
     * Get the maximum depth/height of a tree bottom-up approach
     * return specific value for null node
     * call function recursive for left child
     * call function recursive for right child  
     * get max of the sub-tree depth and add 1
     */
    private int getDepthRecursiveBottomToTop(Node current) {
        if(current == null)
            return 0;
        int leftDepth = getDepthRecursiveBottomToTop(cuurent.left);
        int rightDepth = getDepthRecursiveBottomToTop(current.right);
        return Math.max(leftDepth, rightDepth) + 1;
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
