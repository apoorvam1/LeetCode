**I. Define Usecase, Constraints and Assumptions**

**User/Client**

1. Who is going to use it?
2. How are they going to use it? Check can the user perform CRUD operation.
   
   If applicable note, Does user need and account or can be anonymous?

**Service/Server**

1. What all actions can service take on regular basis. Ex: Delete some expired records
2. What is the input, what is the output?

**Numbers**
1. How many users?
2. How much data?
2. Frequency of service request?
4. read - write ratio

**II.Draw Diagram**

First draw a diagram with components in mind. Then start visiting them and map components with software solution.
ex: Communication Channel - REST/RPC, Dat Storage - SQL Server or NoSQL server, File Server or Object Store etc. 

**III. Define details of components and Interaction between the components**

1. If there is a web server, does it need a reverse proxy?
2. If there is table, give an approx schema

**IV. Find limitations and plan what needs to be improved/fixed
1. Do you need a discovery service?
2. Address how to handle SPOF?
3. Is there a need of configuration service?

**V. Scale the design**
1. Load balancer
2. Horizontal scaling
3. Caching
4. Database sharding

**Userful Pointers**
1. 1 month has 2.5 million seconds
2. To store a file a file server can be used. Instead one can use an object store such as Amazon S3 or a NoSQL Document store
3. MD5 is a widely used hashing function that produces a 128-bit hash value
4. Internal communication can use Remote Procedure Calls

