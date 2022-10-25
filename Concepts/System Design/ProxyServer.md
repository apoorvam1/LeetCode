### Proxy Server
A proxy server is a `server application` that acts on behalf of the client when requesting a service and potentially masking the true origin of the request from the server.


Instead of connecting directly to a server that can fulfill a requested resource, such as a file or web page for example, the client directs the request to the proxy server, which evaluates the request and performs the required network transactions. This could benifit in providing load balancing, sercurity and privacy.

#### When would someone use Proxy/Forward Proxy?
- To hide the identity of the client. Only the IP address of the proxy will be visible to the server
- To bypass the browsing restrictions. But this would not work if the firewall restricts the access to the proxy
- To block access to certain contents

### Reverse Proxy
Reverse proxy acts on behalf of the server hiding the internal network complexities from the clients. 

Clients only see the reverse proxy's IP, allowing you to scale servers or change their configuration

#### When would someone use Reverse Proxy?
- To hide the identity of the server. This makes the DDOS attack against the server much harder
- To load balanace
- To cache the static content
- To handle SSL Encryptions. Frees up the servers from the computationally expensive operation. Instead of handling SSL for all clients the web servers needs to handle SSL only for a number of reverse proxies

