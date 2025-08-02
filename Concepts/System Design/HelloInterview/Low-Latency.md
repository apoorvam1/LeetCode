This article describes approaches you can take to ensure the latency is <200ms or reasonable

### Cause: Expensive DB reads
### Fix:
When we think about low latency requests, the first thing that should come to mind is caching.
1. Real-time cache with CDC: The most effective solution pre-computes and caches feeds using Change Data Capture (CDC) for immediate updates.
   - As the data gets saved in the database, it will trigger CDC events.
   - These CDC events are consumed by some Workers immediately and update the cache entry with the new info
   - We can have some limit on the number of records in the cache and delete the old records if the size limit is hit
2. Redis Cache with some fixed refresh rate
  - We can have a cache with caches the items for a fixed amount of time, like 1min
  - Also identify what transactions in the DB will invalidate a cache entry
3. Have a dedicated read replica of the database: if small amount of inconsistency is tolerable
4. Identify what is the key used for read operations and partition DB by that key
   - That way the DB queries are only send to some of the DB instances
