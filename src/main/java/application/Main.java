package application;

import com.github.javafaker.Faker;
import model.Configuration;
import repository.ElasticSearchRepository;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        System.out.println("Usage: java -jar ElasticPump.java host={host} port={port} clusterName={clusterName} index={index} inserts={inserts}");

        Configuration conf = new Configuration(args);
        ElasticSearchRepository elasticRepository = ElasticSearchRepository.getInstance(conf);
        Faker fakeStudent = new Faker();

        IntStream.range(1, conf.inserts())
                .forEach(i -> elasticRepository.insertRandomStudent(conf, fakeStudent));
    }
}
