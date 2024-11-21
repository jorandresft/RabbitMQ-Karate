Feature:RabbitMQ Test

  Scenario Outline: Purge queue from RabbitMQ
    Given def deleteQueue = Java.type('co.com.rabbitmq.utils.RabbitMQDelete')
    #Delete queue
    When def message = deleteQueue.deleteQueue('<queue>')
    Then print 'Consume message: ', message

    Examples:
      | queue        |
      | Test-Queue06 |