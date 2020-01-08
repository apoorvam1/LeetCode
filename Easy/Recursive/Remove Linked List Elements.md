Remove all elements from a linked list of integers that have value val.

```
Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next: head;
    }
}
```

