alanced strings are those who have equal quantity of 'L' and 'R' characters.

Given a balanced string s split it in the maximum amount of balanced strings.

Return the maximum amount of splitted balanced strings.

 
```
Example 1:

Input: s = "RLRRLLRLRL"
Output: 4
Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
Example 2:

Input: s = "RLLLLRRRLR"
Output: 3
Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
Example 3:

Input: s = "LLLLRRRR"
Output: 1
Explanation: s can be split into "LLLLRRRR".
Example 4:

Input: s = "RLRRRLLRLL"
Output: 2
Explanation: s can be split into "RL", "RRRLLRLL", since each substring contains an equal number of 'L' and 'R'
``` 

Constraints:

1 <= s.length <= 1000
s[i] = 'L' or 'R'


**Solution**

class Solution {
    public int balancedStringSplit(String s) {
        if(s.length() % 2 != 0) return 0;
        int rc = 0;
        int lc = 0;
        int res = 0;
        
        char[] c = s.toCharArray();
        
        for(int i = 0; i < s.length(); i++) {
            if(c[i]=='L') {
                lc++;
            } else {
                rc++;
            }
            
            if(lc == rc) {
                res++;
                lc = 0;
                rc = 0;
            }
        }
        return res;
    }
}
