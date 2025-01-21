How to address Single Point of Failure?

### Storage/Cache
## By Adding Primary and secondary nodes
- We will have Multiple nodes to hold the data shards in the system. Ex: 10 nodes
- Among those we will have one primary and every time a data is written to primary 2 other nodes will get the copy of it.
  Those are secondary nodes.
- Data distributed accross all the secondary nodes is sharded so that hardware is used well and there is no contention.

Ex: We have node 1 to 10 and node 1 is primary. Client writes `A` to primary and this is written to node 2 and node 3. 
Client writes `B` to primary and this is written to say node 4 and node 5. 

We can use consistant hashing to decide which 2 secodary nodes need to keep the copy.
