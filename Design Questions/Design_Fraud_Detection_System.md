
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
        if user_id not in self.user_txns:
            return False

        txns = self.user_txns[user_id]
        n = len(txns)

        start = 0
        for end in range(n):
            while txns[end][0] - txns[start][0] > 60:
                start += 1
            if end - start + 1 > 3:
                return True

        return False

```

## Scaling

1. Data Storage and Ingestion
In the current design, each user’s transactions are stored in a deque, which is fine for small-scale applications, but it doesn’t scale well when you have millions of users or billions of transactions.

Scaling Considerations:

- Distributed storage: You'd want to store the transactions in a distributed database or a distributed in-memory store like Redis, which can be partitioned by user_id (or hash key). This makes it easy to scale across multiple servers and handle high throughput.

Redis supports sorted sets, which could help you store transactions with time-based ordering and query ranges efficiently.

- Sharding: To handle millions or billions of users, you could partition the data (shard) based on user_id. Each shard can store the transactions of a subset of users and perform operations independently.

2. Transaction Processing Pipeline
The current solution processes transactions serially for each user (i.e., one-by-one), but this can be slow when dealing with high throughput.

Scaling Considerations:

- Stream Processing: Instead of processing each transaction in a blocking manner, you could set up a stream processing pipeline using tools like Apache Kafka, Apache Flink, or Apache Spark Streaming. These tools are designed for real-time data ingestion and processing at scale.

  - Kafka can buffer and distribute transaction streams.

  - Flink or Spark Streaming can process data in real time and allow you to apply fraud detection logic in parallel across multiple nodes.

- Microservices Architecture: To scale the solution across distributed systems, you can decouple different parts of the system into separate microservices:

  - One service for transaction ingestion.

  - Another for fraud detection (which can scale horizontally).

  - Another for transaction storage.

  - Another for alerting if suspicious behavior is detected.
 
 3. Suspicious Transaction Detection
The is_suspicious function we discussed uses a sliding window, which works fine in a single machine but could become inefficient if the data grows large.

Scaling Considerations:

- Windowed Queries: In distributed systems, you'd want to use a technique like windowed joins or time-based queries to efficiently handle sliding windows across large data.

For example, Apache Flink has built-in support for time windows and can perform windowed joins to detect fraud over time in a distributed fashion.

- Event Aggregation: Instead of checking every single transaction individually, you can aggregate events over small time windows (like 1 minute, 5 minutes) and then perform fraud detection in batches. This reduces the amount of work done on each transaction and can be processed more efficiently in bulk.

4. Caching and Indexing
To speed up access to recent transactions and avoid scanning large sets of data every time:

Scaling Considerations:

- In-memory Caching: Frequently accessed data (e.g., recent transactions or user risk scores) can be cached in-memory using Redis or Memcached.

This can help speed up the get_recent_transactions method by caching the results for recently queried users.

- Indexing: Proper indexing of data is crucial. In distributed databases (e.g., Cassandra, Elasticsearch), indexing on timestamps and user_id will significantly improve query performance for fetching transactions within a specific time range.

5. Latency & Throughput
Real-time latency is key here, especially since you're detecting fraud in milliseconds.

Scaling Considerations:

- Low-latency systems: Use distributed systems that are designed for low latency (like Flink, Kafka Streams, or AWS Kinesis). These systems allow you to process streams at scale with low-latency guarantees.

- Event Time vs Processing Time: In a distributed system, the time at which an event was generated (event time) is often different from the time it’s processed (processing time). It’s important to handle watermarks (a concept from stream processing) to ensure that events out of order can still be processed correctly.

- Horizontal Scaling: For each of these services (transaction ingestion, fraud detection, etc.), you should be able to horizontally scale the number of instances. You can scale based on throughput (number of transactions per second) and latency requirements.

6. Fault Tolerance & Reliability
In production, we need to ensure that even if parts of the system fail, the service remains reliable.

Scaling Considerations:

- Replication: Use replication in your distributed data store to ensure that data is not lost in case of hardware failure. For example, Redis Cluster supports replication and automatic failover.

- Event Replay: Implement event replay mechanisms (e.g., using Kafka’s replay capability) so that in case of failure, you can replay events to recover lost state or missed transactions.

- Monitoring and Alerting: Set up real-time monitoring and alerting for transaction volumes, fraud detection outcomes, and service health (using tools like Prometheus, Grafana, or Datadog). This will help you detect issues early.
