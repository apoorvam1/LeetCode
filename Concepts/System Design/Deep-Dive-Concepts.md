### Consistency Solutions
1. Introducing Redis cache with DB(which has eventual consistency)
- We can intriduce a caching layer with Redis for introducing high consistency.
- Which means data is written to cache first and then to the DB
- But we may loose data if the data is written to the cache but is lost before writing to the DB
- To handle this we introduce a queue. The data from cache is written to the queue.
  A consumer reads data from the queue and writes to the DB

### Dealing with GeoSpacial Data
1. Add postGIS extension to postgres
- It makes queriying with geospacially indexed data fast
2. Introduce Elastic Search DB
  - Use Change Data Capture to capture all changes to the original DB comes to Elastic Search DB as well


### Redis Cache along with DB 
- It's a good idea to ensure the amount of data stored in cache isn't a lot
- It can store only a subset of the actual data to handle very specific usecases
- It can also store everything and CDC can sync the DB
