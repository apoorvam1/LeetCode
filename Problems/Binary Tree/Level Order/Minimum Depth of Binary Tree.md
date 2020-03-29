  Given a binary tree, find its minimum depth.

  The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

  Note: A leaf is a node with no children.

  ```
  Example:

  Given binary tree [3,9,20,null,null,15,7],

     3
    / \
   9  20
     /  \
    15   7

  return its minimum depth = 2.
```
  My Notes: When some var is being updated in helper, make it a class level member

**Solution**

```
class Solution {
    int minDepth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        minDepth(root, 1);
        return minDepth;
    }
    
    private void minDepth(TreeNode root, int curMin) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            minDepth = Math.min(minDepth, curMin);
        }
        minDepth(root.left, curMin + 1);
        minDepth(root.right, curMin + 1);
    }
}
```

**Solution - Level order**

```
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int curDepth = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            curDepth++;
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if(cur.left == null && cur.right == null) {
                    return curDepth;
                }
                
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        
        return curDepth; 
    }
}
```
