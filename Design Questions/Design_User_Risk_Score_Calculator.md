Design a system that processes a continuous stream of transactions and maintains a real-time risk score for each user. The system should allow:

Ingesting new transactions (user_id, amount, timestamp)

Efficiently computing and updating a rolling risk score per user (e.g., based on transaction frequency and amount)

Fetching a user’s current risk score in O(1) or near constant time

The system should support millions of users and be able to scale horizontally.

Risk score = sum of amounts in the last 60 seconds / number of transactions in the last 60 seconds. If a user has no recent activity, risk score = 0.

The system should support at least 10 million users, so choose data structures wisely.

```
from collections import defaultdict, deque
import time

class RiskScorer:
    def __init__(self):
        # user_id -> deque of (timestamp, amount)
        self.txn_data = defaultdict(deque)
        # user_id -> sum of amounts in window
        self.amount_sum = defaultdict(float)
        # user_id -> number of transactions in window
        self.txn_count = defaultdict(int)
        # risk window in seconds
        self.window_size = 60

    def add_transaction(self, user_id: str, amount: float, timestamp: int) -> None:
        dq = self.txn_data[user_id]
        dq.append((timestamp, amount))
        self.amount_sum[user_id] += amount
        self.txn_count[user_id] += 1

        # Prune old transactions
        while dq and timestamp - dq[0][0] > self.window_size:
            old_ts, old_amt = dq.popleft()
            self.amount_sum[user_id] -= old_amt
            self.txn_count[user_id] -= 1

    def get_risk_score(self, user_id: str) -> float:
        if self.txn_count[user_id] == 0:
            return 0.0
        return self.amount_sum[user_id] / self.txn_count[user_id]
```

## Scaling Plan

### What is a Flink Job?
A Flink Job is a dataflow program that reads data from a source (e.g., Kafka), processes it in real time, and writes results to a sink (e.g., Redis, another Kafka topic, database, etc.).

Think of it as a streaming pipeline:

text
Copy
Edit
(Source) → [Transformations] → (Sink)


### Basics

For millions of users and high transaction throughput,
- Shard processing by user ID and use Kafka as the ingestion bus.
- Each processing node (or Flink task) would manage a stateful rolling window per user — either using a deque or a time-based aggregator.
- Risk scores would be cached in Redis and updated in real-time.
- Also consider pruning inactive users to control memory growth
- Snapshot state for fault-tolerance.

