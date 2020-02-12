/**************************************************************************
 *   Copyright (c) 2012 Dell Inc. All rights reserved.                    *
 *                                                                        *
 * DELL INC. CONFIDENTIAL AND PROPRIETARY INFORMATION. This software may  *
 * only be supplied under the terms of a license agreement or             *
 * nondisclosure agreement with Dell Inc. and may not be copied or        *
 * disclosed except in accordance with the terms of such agreement.       *
 **************************************************************************/
package com.example.producer_consumer;


import com.example.producer_consumer.consumer.ReceiveMessageHandler;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigureRabbitMQ {

    public static final String EXCHANGE_NAME ="mikeexchange";
    public static final String QUEUE_NAME ="mikequeue";

    @Bean
    Queue createQueue() {
        return new Queue(QUEUE_NAME,false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    Binding binding(Queue q , TopicExchange exchange){
        return BindingBuilder.bind(q).to(exchange).with("mike.#");
    }

    @Bean
    MessageListenerAdapter listenerAdapter(ReceiveMessageHandler handler){
        return new MessageListenerAdapter(handler,"handleMessage");
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory , MessageListenerAdapter messageListenerAdapter){
        /*connectionFactory.setHost("localhost");
        connectionFactory.setPort(15678);
        connectionFactory.setUsername("user1");
        connectionFactory.setPassword("MyPassword");*/
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(QUEUE_NAME);
        container.setMessageListener(messageListenerAdapter);
        return container;
    }



}
