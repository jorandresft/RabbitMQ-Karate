## Prueba de concepto RabbitMQ-Karate

Prueba de concepto para realizar la conexión a una instancia de RabbitMQ para crear, consumir, purgar y eliminar colas MQ.

Idiomas:

- Java
- Gherkin

## Pasos

- Ir a https://www.cloudamqp.com/ y crear una cuenta.
- Crea una instancia gratuita en el panel de CloudAMQP.
- Selecciona un plan gratuito como el plan Little Lemur (si está disponible).
- Asigna un nombre a tu instancia y créala.
- Obtén las credenciales una vez creada.
- Selecciona tu instancia y copia: 
  - hostname (URL del servidor RabbitMQ).
  - Usuario y contraseña.
  - Puerto AMQP (generalmente 5672).

- En la ruta main/java/co/com/rabbitmq/utils esta el código referencia para Crear, consumir, purgar y eliminar una cola MQ.
- En la ruta test/java/rabbitmq está el código referencia para los .feature.
  
## Ejecutar pruebas

Mediante comando gradle

```bash
gradle clean test
gradle test --tests ParallelTest
```
## Autor

- Jorge Franco
- jorgeandresft@gmail.com