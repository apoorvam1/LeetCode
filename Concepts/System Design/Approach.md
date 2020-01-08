
**User/Client**

1. Check can the user perform CRUD operation?
2. Does user need and account or can be anonymous

**Service/Server**

1. What all actions can service take on regular basis. Ex: Delete some expired records
2. Does it need HA?

**State the assumptions**

1. How many users? 
2. Frequency of service request
3. What could be the acceptable latency?

**Userful Pointers**
1. 1 month has 2.5 million seconds
2. To store a file a file server can be used. Instead if it, one can use an object store such as Amazon S3 or a NoSQL Document store
