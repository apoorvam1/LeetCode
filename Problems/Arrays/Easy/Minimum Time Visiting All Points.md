Refer question here with diagram: https://leetcode.com/problems/minimum-time-visiting-all-points/

**Solution** 
```
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        // let's say 
        // dx = |x1 - x2|
        // dy = |y1 - y2|
        // avoid going both horizantally and vertically
        // go diagonally from start for at least min(dx, dy) steps
        // then cover the gap harizontally or vertically
        // [1,1] x1 = 1, y1 = 1 => [2,2] => [3,3] => 
        // [3,4] x2 = 3, y2 = 4 => [3,4] => [3,4]
        int min = 0;
        for(int i = 0; i < points.length-1; i++) {
            int[] start = points[i];
            int[] end = points[i+1];
            int dx = Math.abs(start[0] - end[0]);
            int dy = Math.abs(start[1] - end[1]);
            
            min += Math.min(dx, dy) + Math.abs(dx-dy);
        }
        return min;
    }
}
```
