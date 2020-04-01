Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

```
Example:

MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
```

**Solution - 1**
```
class MovingAverage {
    int size;
    List<Integer> running = new LinkedList<>();
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        running.add(val);
        
        int curSum = 0;
        int startIndex = Math.max(0, running.size() - size);
        
        for(int i = startIndex; i < running.size(); i++) {
            curSum += (int)running.get(i);
        }
        
        return (double)curSum/Math.min(size, running.size());
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
 ```
