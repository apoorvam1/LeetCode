Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:
```
LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
```


**Solution 1**
```

class LRUCache extends LinkedHashMap<Integer, Integer> {

    private int capacity;
    
    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        super.put(key, value);
    }
    
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
 ```
 



**Solution 2**

```
class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }
    
    private int capacity;
    private int size;
    private Node head;
    private Node tail;
    private Map<Integer, Node> cache = new HashMap<>();
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node cur = cache.get(key);
        
        if(cur == null) return -1;
        
        moveToHead(cur);
        return cur.value;
    }
    
    public void put(int key, int value) {
        Node cur = cache.get(key);
        
        if(cur != null) {
            cur.value = value;
            moveToHead(cur);
        } else {
            Node node = new Node();
            node.key = key;
            node.value = value;
            
            if(size == capacity) {
                // if size is capacity remove last node before tail
                Node tail = popTail();
                cache.remove(tail.key);
                size--;
            }
            
            cache.put(key, node);
            
            // insert node next to head
            addNodeAtHead(node);
            
            // increase size    
            size++;
        }
        
    }
    
    /** All private helper methods **/
    private void moveToHead(Node cur) {
        // remove cur from it's position
        removeNode(cur);
        
        // Add cur next to head
        addNodeAtHead(cur);
    }
    
    private void addNodeAtHead(Node cur) {
        Node temp = head.next;
        
        cur.prev = head;
        cur.next = temp;
        head.next = cur;
        temp.prev = cur;
    }
    
    private void removeNode(Node cur) {
        Node prev = cur.prev;
        Node next = cur.next;
        
        prev.next = next;
        next.prev = prev;
    }
    
    private Node popTail() {
        Node remove = tail.prev;
        removeNode(remove);
        return remove;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
 ```
