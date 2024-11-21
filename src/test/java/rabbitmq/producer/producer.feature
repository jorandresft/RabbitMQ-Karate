Feature:RabbitMQ Test

  Scenario Outline: Publish and consume message from RabbitMQ
    Given def producer = Java.type('co.com.rabbitmq.utils.RabbitMQProducer')
    #Public message
    When eval  producer.publishMessage('<queue>', '<message>')
    Then print 'Message published successfully ' + '<message>'

    Examples:
      | queue        | message |
      | Test-Queue09 | Test    |