# architectural

This repo is aimed to have example so microservices architectural patterns.
Content:
1.demo1 contains a simple microservice with book recommendation service.
2.demo-client is a simple client microservice to fetch recommendations for the server microservice.
  Its configured to have the threshhold for 1000 microsecond and if the threshhold is breached the circut opens and does not allows the further calling.
    Example is derived from netflix hystrix apis endorsed by spring.
