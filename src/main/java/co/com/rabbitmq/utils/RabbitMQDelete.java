package co.com.rabbitmq.utils;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RabbitMQDelete {

    private RabbitMQDelete() {
    }

    static final Logger logger = LoggerFactory.getLogger(RabbitMQProducer.class);

    public static String deleteQueue (String queueName) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Constants.HOST);
        factory.setUsername(Constants.USER);
        factory.setPassword(Constants.PASS);
        factory.setVirtualHost(Constants.VIRTUAL_HOST);
        factory.setPort(Constants.PORT);

        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
            channel.queueDeclare(queueName, true, false, false, null);
            channel.queueDelete(queueName);
            AMQP.Queue.DeleteOk response = channel.queueDelete(queueName);
            if (response != null) {
                return "Queue delete";
            } else {
                return null;
            }
        }
    }
}
