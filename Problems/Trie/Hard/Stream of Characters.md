Implement the StreamChecker class as follows:

StreamChecker(words): Constructor, init the data structure with the given words.
query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest to newest, including this letter just queried) spell one of the words in the given list.
 
```
Example:

StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
streamChecker.query('a');          // return false
streamChecker.query('b');          // return false
streamChecker.query('c');          // return false
streamChecker.query('d');          // return true, because 'cd' is in the wordlist
streamChecker.query('e');          // return false
streamChecker.query('f');          // return true, because 'f' is in the wordlist
streamChecker.query('g');          // return false
streamChecker.query('h');          // return false
streamChecker.query('i');          // return false
streamChecker.query('j');          // return false
streamChecker.query('k');          // return false
streamChecker.query('l');          // return true, because 'kl' is in the wordlist
 ```

Note:

```
1 <= words.length <= 2000
1 <= words[i].length <= 2000
Words will only consist of lowercase English letters.
Queries will only consist of lowercase English letters.
The number of queries is at most 40000
```

**Solution**

```
class StreamChecker {

    private class TrieNode {
        boolean isWordBegin = false;
        TrieNode[] next = new TrieNode[26];
    }
    
    private TrieNode root = new TrieNode();
    private StringBuilder sb = new StringBuilder();
    public StreamChecker(String[] words) {
        constructTrie(words);
    }
    
    private void constructTrie(String[] words) {
        for(String w: words) {
            TrieNode cur = root;
            // construct the trie in reverse as in the question we need to simulate backtrack
            for(int i = w.length()-1; i >= 0; i--) {
                // start from the last char
                char c = w.charAt(i);
                // if it is not already added, add it to the tree
                if(cur.next[c - 'a'] == null) {
                    cur.next[c - 'a'] = new TrieNode();
                }
                // change the cur to new node
                cur = cur.next[c - 'a'];
            }
            cur.isWordBegin = true;
        }    
    }
    
    public boolean query(char letter) {
        TrieNode cur = root;
        // keep track of all the letters sent so far
        sb.append(letter);
        
        // start from the new letter and iterate back to see if it an end of one of the words given
        for(int i = sb.length()-1; i >= 0 && cur != null; i--) {
            char c = sb.charAt(i);
            cur = cur.next[c - 'a'];
            // if the letter is found and is marked as word begin then return true
            if(cur != null && cur.isWordBegin) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
 ```
