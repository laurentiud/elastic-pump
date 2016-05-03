package repository;

import com.github.javafaker.Faker;
import model.Configuration;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

public class ElasticSearchRepository {

    private static ElasticSearchRepository instance;
    private Client client;

    private ElasticSearchRepository(Configuration conf) {

        Settings settings = Settings.settingsBuilder()
                .put("cluster.name", conf.clusterName())
                .put("client.transport.sniff", false)
                .build();
        try{
            TransportClient transportClient = TransportClient.builder().settings(settings).build()
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(conf.host()), conf.port()));
            this.client = transportClient;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Could not connect to ES.");
            System.exit(1);
        }
    }

    public static ElasticSearchRepository getInstance(Configuration conf) {
        if (instance == null) instance = new ElasticSearchRepository(conf);
        return instance;
    }

    public void insertRandomStudent(Configuration conf, Faker fakeStudent) {
        try {
            client.prepareIndex(conf.index(), "data").setSource(jsonBuilder().startObject()
                    .field("First name", fakeStudent.name().firstName())
                    .field("Last name", fakeStudent.name().lastName())
                    .field("Email", fakeStudent.internet().emailAddress())
                    .field("Enrollment date", fakeStudent.date().past(1000, TimeUnit.DAYS))
                    .field("Credit card", fakeStudent.finance().creditCard())
                    .field("Background", fakeStudent.lorem().paragraph(20))
            ).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
