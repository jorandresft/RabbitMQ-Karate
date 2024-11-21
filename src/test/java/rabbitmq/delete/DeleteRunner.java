package rabbitmq.delete;

import com.intuit.karate.junit5.Karate;

public class DeleteRunner {
    @Karate.Test
    Karate deleteRunner() {
        return Karate.run("classpath:rabbitmq/delete/delete.feature").relativeTo(getClass());
    }
}
