/**************************************************************************
 *   Copyright (c) 2012 Dell Inc. All rights reserved.                    *
 *                                                                        *
 * DELL INC. CONFIDENTIAL AND PROPRIETARY INFORMATION. This software may  *
 * only be supplied under the terms of a license agreement or             *
 * nondisclosure agreement with Dell Inc. and may not be copied or        *
 * disclosed except in accordance with the terms of such agreement.       *
 **************************************************************************/
package com.example.producer_consumer.consumer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ReceiveMessageHandler {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiveMessageHandler.class);
    public void handleMessage(String messageBody)
    {
        LOG.info("HandleMessage!!!");
        LOG.info(messageBody);
    }
}
