package rabbitmq.producerconsumer;

import com.intuit.karate.junit5.Karate;

public class ProducerConsumerRunner {
    @Karate.Test
    Karate producerConsumerRunner() {
        return Karate.run("classpath:rabbitmq/producerconsumer/producer_consumer.feature").relativeTo(getClass());
    }
}
