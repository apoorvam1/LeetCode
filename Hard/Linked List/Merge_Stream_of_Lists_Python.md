```
from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def __init__(self):
        self.merged_list = None  # Stores the incrementally merged list

    def addList(self, new_list: Optional[ListNode]):
        """Merges a new incoming list into the already merged list."""
        self.merged_list = self.merge(self.merged_list, new_list)

    def getMergedList(self) -> Optional[ListNode]:
        """Returns the fully merged list."""
        return self.merged_list

    def merge(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        """Merges two sorted linked lists into one sorted list."""
        dummy = ListNode()
        tail = dummy

        while l1 and l2:
            if l1.val < l2.val:
                tail.next = l1
                l1 = l1.next
            else:
                tail.next = l2
                l2 = l2.next
            tail = tail.next

        if l1:
            tail.next = l1
        if l2:
            tail.next = l2

        return dummy.next
```
