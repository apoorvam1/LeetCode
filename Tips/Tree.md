1. Ancestor Problem
   - If the problem involves keeping track of ancestors create a child-parent map of each node and use it further

      How to Memoize the calculated hieght of a node in tree?
      
      
      That would be by calculating the height from the leaf and pass it to the parent and reach to the root.
      Hence the first thing to do the call would be to recusively call method on left and right node
      Ex: getHt(Node n) 
            n == null ret 0;
           h1 = getHt(n.left)
           h2 = getHt(n.right)
          ....
      

2. If any problem involves depth/height of a tree consider below facts
   - The curDepth at the root is 1
   - Depth is reached when a leaf node is found


3. BFS vs DFS in terms of memory and speed


   - **Memory requirements:** The stack size is bound by the depth whereas the queue size is bound by the width. For a balanced binary tree with n nodes, that means the stack size would be log(n) but the queue size would b O(n). Note that an explicit queue might not be needed for a BFS in all cases -- keeping a stack of child indices might be sufficient where feasible.


   - **Speed:** For a full search, both cases visit all the nodes without significant extra overhead. If the search can be aborted when a matching element is found, BFS should typically be faster if the searched element is typically higher up in the search tree because it goes level by level. DFS might be faster if the searched element is typically relatively deep and finding one of many is sufficient.
   
   
4. How to check one of left/right node is null OR if both nodes are null? 

   - if(left == null || right == null) return left == right;

