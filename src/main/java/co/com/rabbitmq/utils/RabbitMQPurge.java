package co.com.rabbitmq.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RabbitMQPurge {

    private RabbitMQPurge() {
    }

    static final Logger logger = LoggerFactory.getLogger(RabbitMQProducer.class);

    public static String purge (String queueName) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Constants.HOST);
        factory.setUsername(Constants.USER);
        factory.setPassword(Constants.PASS);
        factory.setVirtualHost(Constants.VIRTUAL_HOST);
        factory.setPort(Constants.PORT);

        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
            channel.queueDeclare(queueName, true, false, false, null);
            channel.queuePurge(queueName);
            int numMessage = (int) channel.messageCount(queueName);
            logger.info("MessageCount: {}",numMessage);
            if (numMessage == 0) {
                return "Queue purged";
            } else {
                return null;
            }
        }
    }
}
