Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

```
Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
```

**Solution**

```
class Solution {
    public int longestConsecutive(int[] nums) {
        int len = 0;
        Set<Integer> hs = new HashSet<>();
        
        for(int n: nums) {
            hs.add(n);
        }
        
        for(int i = 0; i < nums.length; i++) {
            int localLen = 1;
            //if previous number is present either it's sequence is already explored
            // or we will explore it when we encounter it
            // This makes sure that we don't find the sequence for same number many times
            int cur = nums[i];
            if(hs.contains(cur-1)) continue;
            // loop over if cur is the beginning of the sequence
            while(hs.contains(cur+1)) {
                localLen++;
                cur++;
            }
            len = Math.max(len, localLen);
        }   
        return len;
    }
}
```
