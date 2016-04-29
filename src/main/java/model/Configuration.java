package model;

import java.io.IOException;
import java.io.StringReader;
import java.text.MessageFormat;
import java.util.Properties;

public class Configuration {

    private String host = "127.0.0.1";
    private int port = 9300;
    private String clusterName = "elasticsearch";
    private String index = "pumptestdata";
    private int inserts = 200;

    public Configuration(String[] args) {
        try {
            Properties props = new Properties();
            props.load(new StringReader(String.join("\n", args)));

            this.host = props.getProperty("host", host);
            this.port = Integer.parseInt(props.getProperty("port", "" + port));
            this.clusterName = props.getProperty("clusterName", clusterName);
            this.index = props.getProperty("index", index);
            this.inserts = Integer.parseInt(props.getProperty("inserts", "" + inserts));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(this);
    }

    public String host(){
        return host;
    }
    public int port() {
        return port;
    }
    public String clusterName() {
        return clusterName;
    }
    public String index() {
        return index;
    }
    public int inserts() {
        return inserts;
    }

    @Override
    public String toString() {
        return MessageFormat.format("Configuration: host={0}, port={1}, clusterName={2}, index={3} and inserts={4}",
                host, port, clusterName, index, inserts);
    }
}