package rabbitmq.producer;

import com.intuit.karate.junit5.Karate;

public class ProducerRunner {
    @Karate.Test
    Karate consumerRunner() {
        return Karate.run("classpath:rabbitmq/producer/producer.feature").relativeTo(getClass());
    }
}
