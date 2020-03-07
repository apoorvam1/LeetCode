Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

```
Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
```

**Solution**

```
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(0);
        ListNode head = res;
        
        PriorityQueue<ListNode> q = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.val, b.val);
        });
        
        // store heads of each list in sorted order
        for(ListNode node : lists) {
            if(node != null) {
                q.add(node);
            }
        }
        
        // poll and add to result
        // insert the node next to the polled node to queue
        while(!q.isEmpty()) {
            ListNode cur = q.poll();
            res.next = cur;
            res = res.next;
            
            if(cur.next != null) {
                q.add(cur.next);
            }
        }
        
        return head.next;
    }
}
```
