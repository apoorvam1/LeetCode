Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

```
Example 1:

Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
 ```   
 
 My Notes: Think as if you are first trying to buy a stock today for the best price. And any next day you try to sell it for the best price.
 
**Solution**

```
class Solution {
    public int maxProfit(int[] a) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        
        for(int i = 0; i < a.length; i++) {
            // if there is a tomorrow, i.e i+1 is valid, check if stock price goes low tomorrow. If yes then don't buy today
            // we need to find min value to buy the stock
            while(i+1 <= a.length - 1 &&  a[i] >= a[i+1]) i++;
            min = a[i];
            i++;
            
            // if there is a tomorrow, i.e i+1 is valid check if the stock price is higher tomorrow. If yes then don't sell today
            // we need to find max value to sell stock
            while(i+1 <= a.length - 1 && a[i] < a[i+1]) i++;
            int localprofit = i <= a.length - 1 ? a[i] - min: 0;
            profit += localprofit;
        }
        return profit;
    }
}

```
