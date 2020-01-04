Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

```
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
```
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]


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
    List<List<Integer>> res = new LinkedList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        pathSum(root, sum, new LinkedList<>());
        return res;
    }
    
    private void pathSum(TreeNode root, int sum, LinkedList<Integer> subRes) {
        if(root == null) return;
        subRes.add(root.val);
        
        if(root.left == null && root.right == null && sum - root.val == 0) {
            // make a new copy of subRes and add to res
            // subRes is a reference, which gets modified over the course of recursion
            res.add(new LinkedList(subRes));
        } else {
            pathSum(root.left, sum - root.val, subRes);
            pathSum(root.right, sum - root.val, subRes);
        }
        
        // go one step back
        subRes.removeLast();
    }
}
```
