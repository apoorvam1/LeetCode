Write a function that takes in an array of positive integers and return returns maximum sum of non-adjacent elements.

If input array is empty, then return 0.

Example: [75, 105, 120, 75, 90, 135]
Output: 330 // 75 + 120 + 135

```
import java.util.*;

class Program {
  public static int maxSubsetSumNoAdjacent(int[] array) {
    if(array.length == 0) return 0;
    if(array.length == 1) return array[0];
    if(array.length == 2) return Math.max(array[0], array[1]);

    // create a MaxSum array which contains maxSum we can acheive at each index
    // keeping the constraint in mind
    int maxSums[] = new int[array.length];
    // init
    maxSums[0] = array[0];
    maxSums[1] = Math.max(array[0],array[1]);

    for(int i = 2; i < array.length; i++) {
      // Max at current index would be either same as the value at maxSums[i-1]
      // or maxSum[i-2]+cur
      maxSums[i] = Math.max(maxSums[i-1], array[i] + maxSums[i-2]);
    }

    
    
    return maxSums[array.length-1];
  }
}

```

With optimized Memoization

```
import java.util.*;

class Program {
  public static int maxSubsetSumNoAdjacent(int[] array) {
    if(array.length == 0) return 0;
    if(array.length == 1) return array[0];
    if(array.length == 2) return Math.max(array[0], array[1]);

    // init
    int second = array[0];
    int first = Math.max(array[0],array[1]);

    for(int i = 2; i < array.length; i++) {
      // Max at current index would be either same as the value at first
      // or second + cur
      int cur = Math.max(first, array[i] + second);
      second = first;
      first = cur;
    }

    
    
    return first;
  }
}
```
