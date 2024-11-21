Feature:RabbitMQ Test

  Scenario Outline: Purge queue from RabbitMQ
    Given def purge = Java.type('co.com.rabbitmq.utils.RabbitMQPurge')
    #Delete all messages
    When def message = purge.purge('<queue>')
    Then print 'Consume message: ', message

    Examples:
      | queue        |
      | Test-Queue05 |