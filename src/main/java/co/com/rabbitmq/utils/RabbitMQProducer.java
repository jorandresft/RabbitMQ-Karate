package co.com.rabbitmq.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

public class RabbitMQProducer {

    private RabbitMQProducer() {
    }

    static final Logger logger = LoggerFactory.getLogger(RabbitMQProducer.class);

    public static void publishMessage (String queueName, String message) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Constants.HOST);
        factory.setUsername(Constants.USER);
        factory.setPassword(Constants.PASS);
        factory.setVirtualHost(Constants.VIRTUAL_HOST);
        factory.setPort(Constants.PORT);

        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
            channel.queueDeclare(queueName, true, false, false, null);
            channel.basicPublish("", queueName, null, message.getBytes());
            logger.info("Message sent {}", message);
        }
    }
}
