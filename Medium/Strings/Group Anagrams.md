Given an array of strings, group anagrams together.


```
Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
```
Note:

 - All inputs will be in lowercase.
 - The order of your output does not matter.
 
 
**Solution 1 using maps**
```
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new LinkedList<>();
        if(strs.length == 0) return result;
        Map<String, List<String>> map = new HashMap<>();
        
        for(String s: strs) {
            char tempArray[] = s.toCharArray();
            Arrays.sort(tempArray);
            String sSorted = new String(tempArray);
            if(map.containsKey(sSorted)) {
                List<String> anagrams = map.get(sSorted);
                anagrams.add(s);
                map.put(sSorted, anagrams);
            } else {
                LinkedList<String> anagrams = new LinkedList<>();
                anagrams.add(s);
                map.put(sSorted, anagrams);
            }
        }
        
        for(List<String> anagrams: map.values()) {
            result.add(anagrams);
        }
        
        return result;
    }
}
```

**Solution 2 using char count - no string sorting**
```
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new LinkedList<>();
        if(strs.length == 0) return result;
        Map<String, List<String>> map = new HashMap<>();
        
        for(String s: strs) {
            char tempArray[] = s.toCharArray();
            int[] count = new int[26];
            for(int i = 0; i < s.length();i++) {
                count[s.charAt(i) - 'a']++;
            }
            
            String sCount = Arrays.toString(count);
            
            if(!map.containsKey(sCount)) {
                map.put(sCount, new LinkedList<>());
            } 
            map.get(sCount).add(s);
            
        }
        
        for(List<String> anagrams: map.values()) {
            result.add(anagrams);
        }
        
        return result;
    }
}
```
