Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples 1:
```
Input: [3,9,20,null,null,15,7]

   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7 

Output:

[
  [9],
  [3,15],
  [20],
  [7]
]
Examples 2:

Input: [3,9,8,4,0,1,7]

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7 

Output:

[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null) return result;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        
        queue.add(root);
        cols.add(0);
        
        int leftmost = 0;
        int rightmost = 0;
        
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int curCol = cols.poll();
            
            map.putIfAbsent(curCol, new LinkedList<>());
            map.get(curCol).add(cur.val);
            
            if(cur.left != null) {
                queue.offer(cur.left);
                cols.offer(curCol-1);
                leftmost = Math.min(leftmost, curCol-1);
            }
            
            if(cur.right != null) {
                queue.offer(cur.right);
                cols.offer(curCol+1);
                rightmost = Math.max(rightmost, curCol+1);
            }
        }
        
        for(int i = leftmost; i <= rightmost; i++) {
            result.add(map.get(i));
        }
        
        return result;
    }
}
```
