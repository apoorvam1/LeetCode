  Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to     left for the next level and alternate between).

  For example:
  ```
  Given binary tree [3,9,20,null,null,15,7],
      3
     / \
    9  20
      /  \
     15   7
  return its zigzag level order traversal as:
  [
    [3],
    [20,9],
    [15,7]
  ]
```
  My Notes: The intention is to insert every sub-result in Zigzag order. So use boolean flag to insert the sub-results
  

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        boolean forward = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subResult = new LinkedList<>();
            
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if(forward)
                    subResult.add(cur.val);
                else
                    subResult.add(0, cur.val);
                
                if(cur.left != null) {
                    queue.add(cur.left);
                } 
                if(cur.right != null) {
                    queue.add(cur.right);
                }
                
            }
            res.add(subResult);
            forward = !forward;
        }
        return res;
    }
}
```
