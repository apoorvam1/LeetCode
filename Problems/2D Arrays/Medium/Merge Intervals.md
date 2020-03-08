Given a collection of intervals, merge all overlapping intervals.

```
Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
```

NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

My Notes:
  - Know how to write a comparator.
  - Know how to deal with a 2D array using list
  
  
**Solution**

```
class Solution {
    
    private class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
        }
    }
    
    public int[][] merge(int[][] intervals) {
        Collections.sort(Arrays.asList(intervals), new IntervalComparator());
        
        // Linkedlist containing 1D array
        LinkedList<int[]> res = new LinkedList<>();
        
        for(int[] interval: intervals) {
            // if the res is empty, then add the first interval to begin with
            // or if end of the last added interval is greater than the start of the cur interval
            // add it to res
            if(res.isEmpty() || res.getLast()[1] < interval[0]) {
                res.add(interval);
            } else {
                // interval overlaps with the previous one. Extend the end of the last added interval
                res.getLast()[1] = Math.max(interval[1], res.getLast()[1]);
            }
        }
        
        return res.toArray(new int[res.size()][]);
    }
}
```
