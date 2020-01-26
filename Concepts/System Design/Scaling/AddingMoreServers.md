**Cloning**

We know that the public servers of a scalable web service are hidden behind a load balancer.  This load balancer evenly distributes load (requests from your users) onto your group/cluster of  application servers. 

If we need to clone more severs in the system we need to take care of below concerns

* The servers should be stateles
  
  The servers should not maintain anything that makes it stateful such as user sessions, images etc.
  
* All the servers should have the same codebase.
  
  How can you make sure that a code change is sent to all your servers without one server still serving old code? This tricky   problem is fortunately already solved by the great tool Capistrano. 
  
  Once the code is deployed, create an image file from one of these servers (AWS calls this AMI - Amazon Machine Image.) and use it to clone a new servers
  
  
  **PS:** Sessions need to be stored in a centralized data store which is accessible to all your application servers. It can be an external database or an external persistent cache, like Redis. An external persistent cache will have better performance than an external database. By external I mean that the data store does not reside on the application servers. Instead, it is somewhere in or near the data center of your application servers. 
