Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
```
Given binary tree [3,9,20,null,null,15,7],
     3
    / \
   9  20
     /  \
    15   7
 return its level order traversal as:
 [
   [3],
   [9,20],
   [15,7]
 ]
 ```

**Solution**
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subResult = new LinkedList<>();
            
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                subResult.add(cur.val);
                if(cur.left != null) {
                    queue.offer(cur.left);
                } 
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            result.add(subResult);
        }
        return result;
    }
}
```
