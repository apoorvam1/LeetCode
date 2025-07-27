This article describes approaches you can take to ensure the latency is <200ms or reasonable

### Cause: Expensive DB reads
### Fix:
When we think about low latency requests, the first thing that should come to mind is caching.
1. Real-time cache with CDC: The most effective solution pre-computes and caches feeds using Change Data Capture (CDC) for immediate updates.
   - As the data gets saved in the database, it will trigger CDC events.
   - These CDC events are consumed by some Workers immediately and update the cache entry with the new info
   - We can have some limit on the number of records in the cache and delete the old records of the size limit is hit
