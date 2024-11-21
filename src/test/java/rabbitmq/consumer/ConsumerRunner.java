package rabbitmq.consumer;

import com.intuit.karate.junit5.Karate;

public class ConsumerRunner {
    @Karate.Test
    Karate consumerRunner() {
        return Karate.run("classpath:rabbitmq/consumer/consumer.feature").relativeTo(getClass());
    }
}
