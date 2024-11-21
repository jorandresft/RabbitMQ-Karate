Feature:RabbitMQ Test

  Scenario Outline: Consume message from RabbitMQ
    Given def consumer = Java.type('co.com.rabbitmq.utils.RabbitMQConsumer')
    #Consumer message
    When def message = consumer.consumeMessage('<queue>')
    Then print 'Consume message: ', message
    And match message == '<message>'

    Examples:
      | queue        | message |
      | Test-Queue05 | Test    |