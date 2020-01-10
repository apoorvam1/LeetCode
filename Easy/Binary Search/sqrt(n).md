# Implement int sqrt(int x).

# Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

# Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

```
# Example 1:
# Input: 4
# Output: 2

# Example 2:
# Input: 8
# Output: 2
```

# *My Notes:* We initialize the interval to [0, n]. We compare the squares of mid = floor[(start + end) / 2] with n, and use the # elimination rule to update the interval. If mid^2 <= n, we know all integers less then or equal to mid have a square less 
# than or equal to n. Therefore, we update the interval to [mid + 1, end]. If mid^2 > n, we know all numbers greater than or 
# equal to mid have a square greater than n, so we update the candidate interval to [start, mid - 1]. The algorithm terminates # when the interval is empty, in which case every number less than start has a square less than or equal to n and square of 
# start is greater than n, so the result is start - 1

```
class Solution {
    public int mySqrt(int n) {
       
        long start = 0, end = n;

		while(start <= end)
		{
			long mid = start + (end - start) / 2;

            if(mid * mid <= n)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return (int)start - 1;
	
    }
}
```
