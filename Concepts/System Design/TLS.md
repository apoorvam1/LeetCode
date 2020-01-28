**Overview:**

- Transport Layer security(TLS) is a security layer procol used for establishing secure communication over internet
- TLS is the evolved version of SSL

**What solution does TLS provide?**
- Primary application is to encrypt the communication between the client and the server
- Authentication: ensures that the parties exchanging information are who they claim to be.
- Integrity: verifies that the data has not been forged or tampered with.

**What is the connection between TLS and HTTPS?**
HTTPS is an implementation of TLS encryption on top of the HTTP protocol

**Why should we use TLS?**
- To protect the applications from attacks such as data breaches, DDos attacks

**TLS Handshake with RSA Key Exchange Algorithm**
Authenticate & arrive at a session key(Client random, Server random & Premaster secret) that can encrypt the message

1. Client Initiates: 
    * Sends TLS version to use & cipher suites supported
    * Sends a string of random bytes known as the "client random"
2. Server Responds:
    * Sends SSL certificate with Public Key
    * Sends a string of random bytes known as the "server random"
3. Authentication: 
    * The client verifies the server's SSL certificate with the certificate authority that issued it
4. Test Encryption:
    * Client encrypts some random string of bytes with public key (The client gets the public key from the server's SSL certificate)
    * This message is called `premaster secret`
    * Server decrypts the `premaster secret` with private key
5. Generate one final session key: 
    * Both client and server generate session keys from the client random, the server random, and the premaster secret. They should arrive at the same results.
6. Ready:
    * The client and the server sends a "finished" message that is encrypted with a session key 
7. All Set:
    * The handshake is completed, and communication continues using the session keys
    
**Variation**
Another variation is TLS handshake with ephemeral Diffie-Hellman algorithm.

    
