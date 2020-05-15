```
class Trie {
    
    private class TrieNode {
        Map<Character, TrieNode> map = new HashMap<>();
        boolean isWord;
    }
    
    TrieNode root;
    

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
        root.isWord = false;
        // root.map = new HashMap<>();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode temp = root;
        
        for(char c: word.toCharArray()) {
            Map<Character, TrieNode> curMap = temp.map;
            if(!curMap.containsKey(c)) {
                curMap.put(c, new TrieNode());
            }
            
            temp = curMap.get(c);
        }
        temp.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode temp = root;
        
        for(char c: word.toCharArray()) {
            Map<Character, TrieNode> curMap = temp.map;
            if(!curMap.containsKey(c)) {
                return false;
            }
            
            temp = curMap.get(c);
        }
        return temp.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
                TrieNode temp = root;
        
        for(char c: prefix.toCharArray()) {
            Map<Character, TrieNode> curMap = temp.map;
            if(!curMap.containsKey(c)) {
                return false;
            }
            
            temp = curMap.get(c);
        }
        return true;
    }
}
```
