Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

```
Example 1:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:
Input: "cbbd"
Output: "bb"
```


**Solution**

```
class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 1) return s;
        String longest = s.substring(0,1);
        String tmp = longest;
        for(int i = 0 ; i < s.length(); i++) {
            // if s has odd number of characters start both start and end pointer from the same index
            tmp = getPalindrome(s, i, i);
            if(tmp.length() > longest.length()) {
                longest = tmp;
            }
            
            // if s has even number of characters start the start at i  end pointer from i+1 index
            tmp = getPalindrome(s, i , i+1);
            if(tmp.length() > longest.length()) {
                longest = tmp;
            }
        }
        return longest;
    }
    
    private static String getPalindrome(String s, int st, int end) {
        while(st >= 0 && end <= s.length()-1 && s.charAt(st) == s.charAt(end)) {
            // keep moving the start and end pointers apart
            st--;
            end++;
        }
        return s.substring(st+1, end); 
    }
}
```
