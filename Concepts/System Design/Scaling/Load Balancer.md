**What is a load balancer?**

Load balancers distribute incoming client requests to computing resources such as application servers and databases. In each case, the load balancer returns the response from the computing resource to the appropriate client.

**When do we need load balancers**
- If the system needs to be reliable and there is a single point of failure
- When requests per second is too high and we need more servers in the system

Additional benefits include:

- SSL termination - Decrypt incoming requests and encrypt server responses so backend servers do not have to perform these potentially expensive operations
Removes the need to install X.509 certificates on each server

- Session persistence - Issue cookies and route a specific client's requests to same instance if the web apps do not keep track of sessions

**What are the load balancer solutions**
- Can be implemented with hardware
- Can be implemented with software such as HAProxy, Nginx, Linux Virtual Server(LSV)

**Types of Load Balancing**
Layer 4 load balancer: Layer 4 load balancers look at info at the transport layer to decide how to distribute requests. Generally, this involves the source, destination IP addresses, and ports in the header, but not the contents of the packet.

Layer 7 load balancer: Using layer 7 allows the load balancer to forward requests to different backend servers based on the content of the user’s request(header, message, cookie) . This mode of load balancing allows you to run multiple web application servers under the same domain and port.

**Load Balancing Algorithms**
The load balancing algorithm that is used determines which server, in a backend, will be selected when load balancing.
Some of them are as follows: 

- roundrobin: Round Robin selects servers in turns. This is the default algorithm.

- leastconn: Selects the server with the least number of connections–it is recommended for longer sessions. Servers in the same backend are also rotated in a round-robin fashion.

- source: This selects which server to use based on a hash of the source IP i.e. your user’s IP address. This is one method to ensure that a user will connect to the same server.

- Sticky Sessions: Some applications require that a user continues to connect to the same backend server. This persistence is achieved through sticky sessions, using the appsession parameter in the backend that requires it.

**What if the load balancer is heavily loaded?**
- Typically load balancers like HAProxy can handle 20k-60k active sessions per GB of RAM. If you run out of RAM, either upgrade it or build another load balancer fronted by a round-robin DNS system. 
  - Round robin DNS publicizes multiple IP address for one domain. Keeps a cluster of 2 servers with 1 load balancer for each IP. This allows horizontal scaling
- Routing or firewall tweaks to spread load to multiple load balancers. Have the front router or front firewall spread the incoming connections to several IP addresses

![DNS Round Robin](https://github.com/apoorvam1/LeetCode/blob/master/Concepts/System%20Design/Scaling/Screen%20Shot%202020-01-16%20at%2011.54.52%20AM.png)

**What issues could bringin in a load balancer cause?**
- If it doesn't have enough resources, it can become a bottleneck
- Increases system complexity
- Single load balancer is a single point of failure and bringing in more load balancer increases the complexity of the system
