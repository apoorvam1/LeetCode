<img width="800" alt="Screen Shot 2022-10-14 at 5 33 22 PM" src="https://user-images.githubusercontent.com/10835807/195960894-ed2cc76c-cc40-4c73-bd44-ec130fc466b5.png">

```
Approach: 
- You can reach the last step i.e height step by taking 1, 2... maxsteps.
  - That indicates that we need an iterative loop to go from 1 to maxSteps in recursion. Each time you take a 
  step height reduces by those many steps
- If you have reached the height then you have found one way to reach. That happens when height val becomes 0 or less
- Accumulate the result in each call and return
```

```
import java.util.*;

class Program {

  public int staircaseTraversal(int height, int maxSteps) {
    return numOfWays(height, maxSteps);
  }

  private int numOfWays(int height, int maxSteps) {
    if(height <= 0) return 1;

    int res = 0;
    for(int i = 1; i <= Math.min(height, maxSteps); i++) {
      res += numOfWays(height-i, maxSteps);
    }

    return res;
  }
}
```
