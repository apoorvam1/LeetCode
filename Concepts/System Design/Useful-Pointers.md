Userful Pointers
- 1 day has 100K seconds
- 1 month has 2.5 million seconds
- Largest cache is of size 128GB
- To store a file a file server can be used. Instead one can use an object store such as Amazon S3 or a NoSQL Document store
- MD5 is a widely used hashing function that produces a 128-bit hash value
- Internal communication can use Remote Procedure Calls

Postgres:
10K writes per sec per node

Cassandra:
- Optimized for writes
- Which means it can take in a lot of writes (being available) but consistency will take a hit
- netflix achieved 1M writes per sec with Cassandra
