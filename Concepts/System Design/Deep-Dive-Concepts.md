### Consistency Solutions
1. Introducing Redis cache with DB(which has eventual consistency)
- We can intriduce a caching layer with Redis for introducing high consistency.
- Which means data is written to cache first and then to the DB
- But we may loose data is the data is written to the cache but is lost before writing to the DB
- To handle this we introduce a queue. The data from cache is written to the queue.
  A consumer reads data from the queue and writes to the DB
  
2. 
