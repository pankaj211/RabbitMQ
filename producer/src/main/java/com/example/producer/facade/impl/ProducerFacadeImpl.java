/**************************************************************************
 *   Copyright (c) 2012 Dell Inc. All rights reserved.                    *
 *                                                                        *
 * DELL INC. CONFIDENTIAL AND PROPRIETARY INFORMATION. This software may  *
 * only be supplied under the terms of a license agreement or             *
 * nondisclosure agreement with Dell Inc. and may not be copied or        *
 * disclosed except in accordance with the terms of such agreement.       *
 **************************************************************************/
package com.example.producer.facade.impl;

import com.example.producer.facade.ProducerFacade;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProducerFacadeImpl implements ProducerFacade {

    @Autowired
    private RabbitTemplate rabbitTemplate ;
    @Value("${rabbit.queue.name}")
    private String queueName;
    @Override
    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(queueName,message);
    }
}
