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
