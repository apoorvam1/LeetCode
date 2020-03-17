How? 

* Keep 2 indexes i & j. 
* Move 1 index (say j) based on some condition
* At each step calculate some res that is needed
* When needed move i

Ex: Longest Substring Without Repeating Characters

```
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
```

**My Notes**: Notice, we dont use j-i value for the result. the result is hashset size.
We use i to point to which character to remove next from the hashset. 


** Solution ** 

```
public int lengthOfLongestSubstring(String s) {
    if(s == null || s.length() == 0) return 0;

    Set<Character> hs = new HashSet<>();
    int res = Integer.MIN_VALUE;
    int i = 0;
    int j = 0;

    while(j < s.length()) {
        if(!hs.contains(s.charAt(j))) {
            hs.add(s.charAt(j++));
            res = Math.max(res, hs.size());
        } else {
            hs.remove(s.charAt(i++));
        }
    }

    return res;
}
```    
