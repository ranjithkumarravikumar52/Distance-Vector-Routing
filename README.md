# Routing Information Protocol Java Application

### Introduction

* Basic Information about Routing Information Protocol (RIP)? 
    * Finding the least cost path between two nodes
    * Implemented using Bellman-Ford's Algorithm
    * Used in ARPAnet
    * Distributed network
### Protocol Framework
* Initial State at a node: 
    * Cost (distance) to its **neighbors** is known
* Final State at a node: 
    * Cost to all the nodes is known, and also the **next hop**
* Need to handle
    * What information to exchange? 
        * Each Node exchanges its routing table information only with it's neighbors
        * Destination and Estimated cost to destination
        * Next hop information is **NOT** shared
        * HINT: use only destination and cost to send out the message
    * How to act on message? 
        * Update cost based on the bellman-ford's algorithm and change next hop accordingly
    * When to send a message?
        * Triggered Updates: Sent whenever there's a change in the routing table
            * Link/Node failure or cost increase
        * Periodic updates: 
            * To say neighboring nodes ["I'm staying alive"](https://www.youtube.com/watch?v=I_izvAbhExY)
* Each Node maintains its state through routing table (distance-vector)
* Look at the below sample table

| Destination        | Estimated Cost to Destination           | Next Hop Via to Reach Destination |
| ------------- |:-------------:| -----:|
| A     | 1 | A |
| B     | 2      |   E |
| C | 3      |    F |

* After few message passing, 
    * Nodes reach to a convergence, if there is no change in topology
    * After one message exchange, each node knows about nodes two hops away
    * After two message exchange, each node knows about nodes three hops away
    * so..on
    * Basically, converge will be reached in an at most (V-1) times. where V: Nodes in the network (based on BF algorithm)
* No node has GLOBAL knowledge
* Fully distributed algorithm

### Bellman-Ford's Algorithm code
* Java code for Bellman-Ford's Algorithm has already been implemented in my other [repo](https://github.com/ranjithkumarravikumar52/Shortest-path-algorithms)
* Once the code for that is fully understood, next task is to implement routing table for each node

### [Special Cases/Issues](https://www.youtube.com/watch?v=wDV0Nhs3_hE)
* How are node/link failures detected? 
    * Didn't receive periodic updates
    * Can also actively probe (probe-ack)
* Every path has a puddle (Counting to Infinity)
    * Solutions
        * Make infinity "small"
        * Split horizon
        * Split horizon with poison reverse
        * Split horizon without poison reverse
        * Hold-down timer
    
### Tutorials
* [What is Routing Information Protocol](https://www.youtube.com/watch?v=dmS1t2twFrI)
* [In-detail explanation on RIP](https://www.youtube.com/watch?v=-AyHRhaw4Ao)
* [What are the special cases in RIP ?](https://www.youtube.com/watch?v=wDV0Nhs3_hE)
* [Working wiki example](https://en.wikipedia.org/wiki/Distance-vector_routing_protocol)
