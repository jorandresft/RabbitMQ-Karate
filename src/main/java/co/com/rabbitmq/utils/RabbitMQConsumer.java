package co.com.rabbitmq.utils;

import co.com.rabbitmq.models.Event;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.GetResponse;

public class RabbitMQConsumer {

    private RabbitMQConsumer() {
    }

    public static String consumeMessage (String queueName) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Constants.HOST);
        factory.setUsername(Constants.USER);
        factory.setPassword(Constants.PASS);
        factory.setVirtualHost(Constants.VIRTUAL_HOST);
        factory.setPort(Constants.PORT);

        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
            channel.queueDeclare(queueName, true, false, false, null);
            GetResponse response = channel.basicGet(queueName, true);
            if (response != null) {
                return new String(response.getBody());
            } else {
                return null;
            }
        }
    }
}
