package application;

import com.github.javafaker.Faker;
import com.google.common.base.Stopwatch;
import model.Configuration;
import repository.ElasticSearchRepository;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        System.out.println("Usage: java -jar ElasticPump.java eHost* ePort* eClusterName* eIndex* insertsInBatch* keepAliveInSeconds*");

        Configuration conf = new Configuration(args);
        ElasticSearchRepository elasticRepository = ElasticSearchRepository.getInstance(conf);
        Faker fakeStudent = new Faker();

        Stopwatch watch = Stopwatch.createStarted();
        while(watch.elapsed(TimeUnit.SECONDS) < conf.keepAliveSeconds()) {
            elasticRepository.bulkInsertRandomStudents(conf, fakeStudent);
        }
    }
}
