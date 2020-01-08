Given two arrays, write a function to compute their intersection.

```
Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
```

Note:

--Each element in the result must be unique.
--The result can be in any order.

**Solution**

```
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> temp = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        
        for(int i : nums1) {
            temp.add(i);
        }
        
        for(int i : nums2) {
            if(temp.contains(i)) {
                intersect.add(i);
            }
        }
        
        int[] res = new int[intersect.size()];
        int index = 0;
        
        for(int i : intersect) {
            res[index++] = i;
        }
        
        return res;
    }
}
```
