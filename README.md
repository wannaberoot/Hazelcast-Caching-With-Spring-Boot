# Hazelcast-Caching-With-Spring-Boot
Caching example using Hazelcast and Spring Boot.

## What is Caching?
In computing, a cache is a high-speed data storage layer which stores a subset of data, typically transient in nature, so that future requests for that data are served up faster than is possible by accessing the data’s primary storage location. 
Caching allows you to efficiently reuse previously retrieved or computed data.

## What is Hazelcast?
Hazelcast is a distributed In-Memory Data Grid platform for Java. The architecture supports high scalability and data distribution in a clustered environment. 
It supports the auto-discovery of nodes and intelligent synchronization.
Likewise, Hazelcast offers various features such as Distributed Data Structure, Distributed Compute, Distributed Query, etc.

## Caching with Spring Boot and Hazelcast
Spring Boot is very well integrated with Hazelcast. It’s enough to provide Hazelcast configuration on the classpath and it will be automatically used.

To use caching in your Spring Boot application, you need to:
> add org.springframework.boot:spring-boot-starter-cache dependency\
> add @EnableCaching annotation to your main class\
> add @Cacheable annotation to every method you want to cache

## Comparison of Data Loading Time by Database and Cache

### Data Loading from Database: 5.415s
![---](/images/1.png)

### Data Loading from Cache: 0.049s
![---](/images/2.png)
