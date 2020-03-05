**HashMap**

  * Implements Map interface
  * Array of singly linked list where each node stores key, value, hash and next
  * If a bucket has more than 8 nodes it is changed to red-black tree (self-balancing BST)
  
 Advantages:
  * Average Running time for remove(), get() and put() is O(1)
  * Efficient to store key-value type data
  
  
 Drawbacks:
  * Not synchronized (There is a ConcurrentHashMap for that)
  * Not Ordered. LinkedHashMap provides this solution
