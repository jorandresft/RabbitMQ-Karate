package rabbitmq.purge;

import com.intuit.karate.junit5.Karate;

public class PurgeRunner {
    @Karate.Test
    Karate purgeRunner() {
        return Karate.run("classpath:rabbitmq/purge/purge.feature").relativeTo(getClass());
    }
}
