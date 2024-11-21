Feature:RabbitMQ Test

  Scenario Outline: Publish and consume message from RabbitMQ
    Given def producer = Java.type('co.com.rabbitmq.utils.RabbitMQProducer')
    #Public message
    When eval  producer.publishMessage('<queue>', '<message>')
    Then print 'Message published successfully ' + '<message>'
    Given def consumer = Java.type('co.com.rabbitmq.utils.RabbitMQConsumer')
    #Consumer message
    When def message = consumer.consumeMessage('<queue>')
    Then print 'Consume message: ', message
    And match message == '<message>'

    Examples:
      | queue        | message |
      | Test-Queue08 | Test    |