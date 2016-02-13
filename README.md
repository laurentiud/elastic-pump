### Elastic Pump
It's a project meant to provide an easy way of pumping a lot of data into an ElasticSearch cluster in order to stress test the ingestion capabilities of your ElasticSearch setup.
You need to have java installed and the ElasticSearch setup needs to be accessible through the network.

#### Usage
Download the attached ElasticPump.jar file. The starting command is
```
java -jar ElasticPump.java eHost* ePort* eClusterName* eIndex* insertsInBatch* keepAliveInSeconds*
```
Where we have:  
* eHost - optional, the default is 127.0.0.1, the host or IP of the ElasticSearch node we will connect to.  
* ePort - optional, the default is 9300, port used to connect to ElasticSearch node.  
* eClusterName - optional, the default is elasticsearch, the name of the ElasticSearch cluster.  
* eIndex - optional, the default index is pumptestdata, define in what index should the inserts go. MUST be lowercasel.  
* insertsInBatch - optional, the default is 200, how many elements to be inserted in a single batch.  
* keepAliveInSeconds- optional, the default is 3600 seconds, for how many seconds should the application be alive.  

#### Examples
So depending on what your goals are, here are a few examples.
- **Basic insert on localhost**. Will pump data into 192.168.192.168 Elasticsearch node, on port 9300, 200 elements per batch, into pumptestdata index, for 3600 seconds
```
java -jar ElasticPump.jar
```
- Will pump data into 192.168.192.168 Elasticsearch node, on port 9301, to the cluster named myClusterName, 200 elements per batch, into testdataindex index, for 3600 seconds
```
java -jar ElasticPump.jar 192.168.192.168 9301 myClusterName testdataindex
```
- Will pump data into 192.168.192.168 Elasticsearch node, on port 9301, to the cluster named myClusterName, 2000 elements per batch, into teststudents index, for 600 seconds.
```
java -jar ElasticPump.jar 192.168.192.168 9301 myClusterName teststudents 2000 600
```

**It's possible to start multiple instances with different configurations.**