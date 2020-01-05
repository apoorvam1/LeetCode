You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

```
root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
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
    
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        
        // contains cumulative sum to each node from root
        Map<Integer, Integer> pathSumCount = new HashMap<>();
        pathSumCount.put(0, 1);
        return pathSum(root, 0, sum, pathSumCount);
    }
    
    private int pathSum(TreeNode root, int cumulative, int target, Map<Integer, Integer> pathSumCount) {
        
        // if root is null, there are 0 ways to achieve target sum
        if(root == null) return 0;
        
        // consider current node val in cumulative sum
        cumulative += root.val;
        
        // Keep in mind that the map contains sum to each node from root
        // cumulative-target is the excess amount that we dont want in the path to achieve target
        // if we have found few paths on the way which gives cumulative-target then there are those many ways to achieve target
        int numWaysToTarget = pathSumCount.getOrDefault(cumulative-target, 0);
        
        pathSumCount.put(cumulative, pathSumCount.getOrDefault(cumulative, 0) + 1);
        
        int res = numWaysToTarget + pathSum(root.left, cumulative, target, pathSumCount) + 
            pathSum(root.right, cumulative, target, pathSumCount);
        
        // remove count from map before returning from recusrion
        pathSumCount.put(cumulative, pathSumCount.get(cumulative) - 1);
        return res;
    }
}
```
