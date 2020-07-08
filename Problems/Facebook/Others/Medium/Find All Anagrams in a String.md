Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

```
Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
```

**Solution**

My Notes: Think simple. Starting from every character in s, construct char-map for length of p.length(). Compare this char-map with char-map of s


```
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indices = new ArrayList<>();
        if(s.length() < p.length()) return indices;
        
        
        
        int[] count = new int[26];
        for(int i = 0; i < p.length(); i++) {
            count[p.charAt(i) - 'a']++;
        }
        
        for(int i = 0 ; i <= s.length() - p.length(); i++) {
            int[] temp = new int[26];
            
            for(int j = 0; j < p.length(); j++) {
                temp[s.charAt(i+j) - 'a']++;
            }
            
            if(match(count, temp)) {
                indices.add(i);
            }
        }
        return indices;
    }
    
    
    private boolean match(int[] s1, int[] s2) {
        for(int i = 0; i < 26; i++) {
            if(s1[i] != s2[i]) return false;
        }
        return true;
    }
}
```
