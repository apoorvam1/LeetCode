Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.

 

If there is no common subsequence, return 0.

My Notes: Refer to this video: https://www.youtube.com/watch?v=ASoaQq66foQ 


```
Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.


Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
```

** Solution 1 - Recursion **
```
    public int longestCommonSubsequence(String text1, String text2) {
        return longestCommonSubsequence(text1, text2, 0, 0);
    }
    
    private int longestCommonSubsequence(String text1, String text2, int i, int j) {
        if(i == text1.length() || j == text2.length()) return 0;
        
        if(text1.charAt(i) == text2.charAt(j))
            return 1 + longestCommonSubsequence(text1, text2, i+1, j+1);
        
        return Math.max(longestCommonSubsequence(text1, text2, i, j+1), longestCommonSubsequence(text1, text2, i+1, j));
    }
  ```
  
  
  ** Solution 2 - DP **
  
  ```
   public int longestCommonSubsequence(String text1, String text2) {
        int m[][] = new int[text1.length()+1][text2.length()+1];
        
        for(int i = 0; i < text1.length(); i++) {
            for(int j = 0; j < text2.length(); j++) {
                if(text1.charAt(i) == text2.charAt(j)) {
                    m[i+1][j+1] = 1 + m[i][j];
                } else {
                    m[i+1][j+1] = Math.max(m[i+1][j], m[i][j+1]);
                }
            }
        }
         return m[text1.length()][text2.length()];
    }
  ```
