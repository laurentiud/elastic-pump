### Elastic Pump
It's a project meant to provide an easy way of pumping data into an ElasticSearch cluster for exploring it or to test the ElasticSearch setup.
You need to have java installed and the ElasticSearch (2.3.0) setup needs to be accessible through the network.

#### Usage
**Run Main.java** or build ElasticPump.jar file and use the starting command:
```
java -jar ElasticPump.java
```
Where you can add:
* host=127.0.0.1, the host or IP of the ElasticSearch node we will connect to.
* port=9300, port used to connect to ElasticSearch node.
* clusterName=elasticsearch, the name of the ElasticSearch cluster.
* index=pumptestdata, define in what index should the inserts go. MUST be lowercase.
* inserts=200, how many elements to be inserted in a single batch.

#### Examples
So depending on what your goals are, here are a few examples.  

- Basic insert on localhost. Will pump data into localhost Elasticsearch node, on port 9300, 200 elements, into pumptestdata index
```
java -jar ElasticPump.jar
```  
- Will pump data into 192.168.192.168 Elasticsearch node, on port 9301, to the cluster named myClusterName, 200 elements, into testdataindex index
```
java -jar ElasticPump.jar host=192.168.192.168 port=9301 clusterName=myClusterName index=testdataindex
```  
- Will pump data into 192.168.192.168 Elasticsearch node, on port 9301, to the cluster named myClusterName, 2000 elements, into teststudents index
```
java -jar ElasticPump.jar host=192.168.192.168 port=9301 clusterName=myClusterName index=teststudents inserts=2000
```
  
**It's possible to start multiple instances with different configurations.**
