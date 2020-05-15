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
    }
    
    /** Inserts a word into the trie. 
    * Get the root
    * iterate over each char in the word and every trie node together
    * if it's a new char insert it
    * move on to the next node
    */
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
    
    /** Returns if the word is in the trie.
    * Get the root
    * iterate over each char in the word and every trie node together
    * if the map doesn't have the char return false
    * else return if the last char makes it a word
    */
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
    
    /** Returns if there is any word in the trie that starts with the given prefix. 
    * Get the root
    * iterate over each char in the word and every trie node together
    * if the map doesn't have the char return false
    * else return true   
    */
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
