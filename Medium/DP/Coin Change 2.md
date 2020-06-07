You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.

 

Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10] 
Output: 1
 

Note:

You can assume that

0 <= amount <= 5000
1 <= coin <= 5000
the number of coins is less than 500
the answer is guaranteed to fit into signed 32-bit integer


**Solution**

```
class Solution {
    public int change(int amount, int[] coins) {
        int combinations[] = new int[amount+1];
        
        // number of ways to make change for amount 0 is 1
        combinations[0] = 1;
        
        // pick up one coin at a time and update number of ways to make change with that given coin for each amount
        for(int coin: coins) {
            for(int i = 1; i < combinations.length; i++) {
                // if current amount for which we want change is at least as big as the coin proceed
                if(i >= coin) {
                    // total combination to make change for amount i is, whatver is the current value + 
                    // combinations the remaining amount i.e i-coin
                    combinations[i] = combinations[i] + combinations[i-coin];
                }
            }
        }
        
        return combinations[amount];
    }
}
```

Reference: https://leetcode.com/problems/coin-change-2/discuss/99222/Video-explaining-how-dynamic-programming-works-with-the-Coin-Change-problem
