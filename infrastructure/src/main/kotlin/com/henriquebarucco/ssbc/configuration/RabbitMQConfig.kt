package com.henriquebarucco.ssbc.configuration

import org.springframework.amqp.core.Message
import org.springframework.amqp.core.MessageProperties
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMQConfig {
    @Bean
    fun customMessageConverter(): MessageConverter =
        object : MessageConverter {
            override fun fromMessage(message: Message): Any = message.body

            override fun toMessage(
                obj: Any,
                messageProperties: MessageProperties,
            ): Message = throw UnsupportedOperationException("This converter is for consumption only.")
        }

    @Bean
    fun myRabbitListenerContainerFactory(
        connectionFactory: ConnectionFactory,
        customMessageConverter: MessageConverter,
    ): SimpleRabbitListenerContainerFactory {
        val factory = SimpleRabbitListenerContainerFactory()
        factory.setConnectionFactory(connectionFactory)
        factory.setMessageConverter(customMessageConverter)
        return factory
    }
}
