6 patterns to solve recursive problems

1. Iteration - Iterate over and array or list using recursion
    - We can replace the forloop with recursion
    - Useful when accessing the last elements of DS
    - Use stack of recursion instead
    - This approach is rarely better than the iterative approach
    
  ```  
  Ex: Printing a list in reverse order
    public void printReverseList(Node head) {
        if(head == null) return;
        printReverseList(head.next);
        System.out.println(head.value);
    }
  ```  
    
2. Breaking into subproblems
  Ex: Fibonacci Series
  
3. Selection (Combinations)
   Problems that can be solved by finding all combination of solutions. 
   Ex: Knapsack
   
4. Ordering (Permutation)
   Find out all permutation and validate which all fit the solution
   Ex: Find all N-digit number whose sum matches some specific value
   
5. Divide and Conquer
  Solve problem for each half and combine the result
  Ex: Mergesort, find all valid paranthesis
  
6. DFS
   Ex: search a node in a tree
   
