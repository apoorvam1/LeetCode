```
Given a string s, find the length of the longest 
substring
 without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
```

Solution: 
```
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        '''
            p w w k e w
            - - 
            max = 2

            p w w k e w x y z
                - - - 
            max = 3

            p w w k e w x y z
                      - - - -
            max = 4
        '''

        l = 0
        maxWindow = 0
        charSet = set()

        for r in range(len(s)):
            # if we have a duplicate, remove the char from set and move the left pointer
            while s[r] in charSet:
                charSet.remove(s[l])
                l += 1
            charSet.add(s[r])
            maxWindow = max(maxWindow, r - l + 1)
        return maxWindow

```
