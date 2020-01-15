As we know, a tree can be defined recursively as a node(the root node), which includes a value and a list of references to other nodes. Recursion is one of the nature features of a tree. Therefore, many tree problems can be solved recursively. 

IMP: "For each recursion level, we can only focus on the problem within one single node and call the function recursively to solve its children. Think of the solution from the perspective of that one node, as the same has to be repeated for each node below" 

Typically, we can solve a tree problem recursively from the top down or from the bottom up.

"Top-down" Solution

"Top-down" means that in each recursion level, we will visit the node first to come up with some values, and pass these values to its children when calling the function recursively. So the "top-down" solution can be considered as kind of preorder traversal. To be specific, the recursion function top_down(root, params) works like this:

====================================================================================================================

"Top-down" Solution

1. return specific value for null node
2. update the answer if needed                      // anwer <-- params
3. left_ans = top_down(root.left, left_params)      // left_params <-- root.val, params
4. right_ans = top_down(root.right, right_params)   // right_params <-- root.val, params 
5. return the answer if needed                      // answer <-- left_ans, right_ans

====================================================================================================================


Ex: maximum_depth(root, depth):
answer = 0;
1. return if root is null
2. if root is a leaf node:
3.      answer = max(answer, depth)         // update the answer if needed
4. maximum_depth(root.left, depth + 1)      // call the function recursively for left child
5. maximum_depth(root.right, depth + 1)     // call the function recursively for right child



"Bottom-up" Solution

"Bottom-up" is another recursion solution. In each recursion level, we will firstly call the functions recursively for all the children nodes and then come up with the answer according to the return values and the value of the root node itself. This process can be regarded as kind of postorder traversal. Typically, a "bottom-up" recursion function bottom_up(root) will be like this:

====================================================================================================================

"Bottom-up" Solution

1. return specific value for null node
2. left_ans = bottom_up(root.left)          // call function recursively for left child
3. right_ans = bottom_up(root.right)        // call function recursively for right child
4. return answers                           // answer <-- left_ans, right_ans, root.val

====================================================================================================================

EX: maximum_depth(root):

1. return 0 if root is null                 // return 0 for null node
2. left_depth = maximum_depth(root.left)
3. right_depth = maximum_depth(root.right)
4. return max(left_depth, right_depth) + 1  // return depth of the subtree rooted at root

Conclusion
It is not easy to understand recursion and find out a recursion solution for the problem.
When you meet a tree problem, ask yourself two questions: can you determine some parameters to help the node know the answer of itself? Can you use these parameters and the value of the node itself to determine what should be the parameters parsing to its children? If the answers are both yes, try to solve this problem using a "top-down" recursion solution.

Or you can think the problem in this way: for a node in a tree, if you know the answer of its children, can you calculate the answer of the node? If the answer is yes, solving the problem recursively from bottom up might be a good way.

