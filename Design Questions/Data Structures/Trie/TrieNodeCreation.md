If the trie has letters it could be creates as follows

```
class Parent {
  class TrieNode {
    TrieNode[] next = new TrieNode[26];
  }

  private TrieNode root = new TrieNode();
  
  private void constructTrie(String[] words) {
    for(String w : words) {
      TrieNode cur = root;
      
      for(int i = 0; i < w.length(); i++) {
        // get each char
        char c = w.charAt(i);
        
        // if it is not already added, add it to the tree
        if(cur.next[c - 'a'] == null) {
          cur.next[c - 'a'] = new TrieNode();
        }
        // change the cur to new node
        cur = cur.next[c - 'a'];
      }
    }
  }
  
  ...
}

```
