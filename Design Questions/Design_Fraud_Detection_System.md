
Stream-based Suspicious Transaction Detector
Problem Statement:
Design a service that ingests a stream of user transactions and supports:
add_transaction(user_id: str, amount: float, timestamp: int)
 → Adds a new transaction. timestamp is in epoch seconds.


get_recent_transactions(user_id: str, window_seconds: int)
 → Returns all transactions for the user that happened within the past window_seconds from the current time.


is_suspicious(user_id: str)
 → Returns True if there are more than 3 transactions within any 60-second sliding window.


```
from collections import deque
import time

class TransactionMonitor:
    def __init__(self):
        self.user_txns = {}  # user_id -> deque[(timestamp, amount)]

    def add_transaction(self, user_id: str, amount: float, timestamp: int = None):
        if timestamp is None:
            timestamp = int(time.time())

        if user_id not in self.user_txns:
            self.user_txns[user_id] = deque()

        self.user_txns[user_id].append((timestamp, amount))


        def get_recent_transactions(self, user_id: str, window_seconds: int):
        if user_id not in self.user_txns:
            return []

        now = int(time.time())
        window_start = now - window_seconds
        txn_deque = self.user_txns[user_id]

        # Remove outdated transactions from the front
        while txn_deque and txn_deque[0][0] < window_start:
            txn_deque.popleft()

        return list(txn_deque)


    def is_suspicious(self, user_id: str) -> bool:
        pass

```
