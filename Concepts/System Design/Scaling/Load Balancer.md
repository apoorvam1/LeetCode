**What is a load balancer?**

Load balancers distribute incoming client requests to computing resources such as application servers and databases. In each case, the load balancer returns the response from the computing resource to the appropriate client.

**When do we need load balancers**
- If the system needs to be reloable and there is a single point of failure
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
