In a given grid, each cell can have one of three values:

* the value 0 representing an empty cell;
* the value 1 representing a fresh orange;
* the value 2 representing a rotten orange.

Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

```
Example: 

Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4


Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
```

**Solution**

```
class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int countFresh = 0;
        
        Queue<Point> q = new LinkedList<>();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 2) {
                    q.add(new Point(i, j));
                }
                if(grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }
        if(countFresh == 0) return 0;
        
        int min = bfs(grid, q);
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        
        return min;
    }
    
    private int bfs(int[][] grid, Queue<Point> q) {
        
        int min = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            min++;
            for(int i = 0; i < size; i++) {
                Point cur = q.poll();
                int x = cur.x;
                int y = cur.y;
                
                if(x-1 >= 0 && grid[x-1][y] == 1) {
                    grid[x-1][y] = 2;
                    q.offer(new Point(x-1, y));
                }
                
                if(y-1 >= 0 && grid[x][y-1] == 1) {
                    grid[x][y-1] = 2;
                    q.offer(new Point(x, y-1));
                }
                
                if(x+1 < grid.length && grid[x+1][y] == 1) {
                    grid[x+1][y] = 2;
                    q.offer(new Point(x+1, y));
                }
                
                if(y+1 < grid[0].length && grid[x][y+1] == 1) {
                    grid[x][y+1] = 2;
                    q.offer(new Point(x, y+1));
                }
            }
        }
        return min-1;
    }
    
    class Point {
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
```
