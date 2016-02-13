package model;

public class Configuration {

    private String eHost = "127.0.0.1";
    private int ePort = 9300;
    private String eClusterName = "elasticsearch";
    private String eIndex = "pumptestdata";
    private int insertsInBatch = 200;
    private int keepAliveInSeconds = 3600;

    public Configuration(String[] args){
        if (args.length > 0)
            eHost = args[0];
        if (args.length > 1)
            ePort = Integer.parseInt(args[1]);
        if (args.length > 2)
            eClusterName = args[2];
        if (args.length > 3)
            eIndex = args[3].toLowerCase();
        if (args.length > 4)
            insertsInBatch = Integer.parseInt(args[4]);
        if (args.length > 5)
            keepAliveInSeconds = Integer.parseInt(args[5]);
    }

    public String host(){
        return eHost;
    }
    public int port() {
        return ePort;
    }
    public String clusterName() {
        return eClusterName;
    }
    public String index() {
        return eIndex;
    }
    public int inserts() {
        return insertsInBatch;
    }
    public int keepAliveSeconds() {
        return keepAliveInSeconds;
    }
}