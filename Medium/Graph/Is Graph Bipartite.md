Given an undirected graph, return true if and only if it is bipartite.

Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.

The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.

```
Example 1:
Input: [[1,3], [0,2], [1,3], [0,2]]
Output: true
Explanation: 
The graph looks like this:
0----1
|    |
|    |
3----2
We can divide the vertices into two groups: {0, 2} and {1, 3}.
```

```
Example 2:
Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
Output: false
Explanation: 
The graph looks like this:
0----1
| \  |
|  \ |
3----2
We cannot find a way to divide the set of nodes into two independent subsets.
```


**Solution**

```
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        // mark all nodes as unvisited
        Arrays.fill(color, -1);
        
        // Start from first node and go until last
        for(int node = 0; node < n; node++) {
            // if the node is not visited yet add to stack and explore it's children
            if(color[node] == -1) {
                Stack<Integer> stk = new Stack<>();
                stk.push(node);
                color[node] = 0;
                
                while(!stk.isEmpty()) {
                    int cur = stk.pop();
                    
                    // if child has not been visited assign opposite color
                    // if child has the same color as the parent return false
                    for(int nei : graph[cur]) {
                        if(color[nei] == -1) {
                            color[nei] = color[cur] ^ 1;
                            stk.push(nei);
                        } else {
                            if(color[nei] == color[cur]) return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
```
