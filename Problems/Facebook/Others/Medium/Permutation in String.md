Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

 

Example 1:
```
Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False
```

Constraints:

The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].


**Solution**

My Notes: Think simple. Starting from every character in s2, construct char-map for length of s1.length(). Compare this char-map with char-map of s1. 


```
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        
        int[] s1count = new int[26];

        for(int i = 0; i < s1.length(); i++) {
            s1count[s1.charAt(i)-'a']++;
        }
    
        // we can leave last s1.length() - 1 characters, hence i <= s2.length() - s1.length()
        for(int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] s2count = new int[26];
            
            for(int j = 0; j < s1.length(); j++) {
                s2count[s2.charAt(i+j)-'a']++;
            }
            
            
            if(matches(s1count, s2count)) return true;
            
        }
    
        return false;
    }
    
    private boolean matches(int[] s1count, int[] s2count) {
        for(int i = 0; i < 26; i++) {
            if(s1count[i] != s2count[i]) return false;
        }
        return true;
    }
}
```
