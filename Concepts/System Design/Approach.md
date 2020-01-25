**I. Define Components and Assumptions**

**User/Client**

1. Check can the user perform CRUD operation?
2. Does user need and account or can be anonymous
3. How many users? 

**Service/Server**

1. What all actions can service take on regular basis. Ex: Delete some expired records
2. Frequency of service request
3. What is the input, what is the output?
4. Does it need HA?
5. What could be the acceptable latency?

**II.Draw Diagram**
First draw a diagram with components in mind. Then start visiting them and decide which componets which software solution.
ex: SQL Server or NoSQL server, File Server or Object Store etc. 

**III. Define details of components and Interaction between the components**

1. If there is a web server, does it need a reverse proxy?
2. If there is table give an approx schema

**IV. Scale the design**
1. Load balancer
2. Horizontal scaling
3. Caching
4. Database sharding

**Userful Pointers**
1. 1 month has 2.5 million seconds
2. To store a file a file server can be used. Instead if it, one can use an object store such as Amazon S3 or a NoSQL Document store
3. MD5 is a widely used hashing function that produces a 128-bit hash value
4. Internal communication can use Remote Procedure Calls

