package com.learning.invoice.messaging;

import com.learning.invoice.config.MessagingConfiguration;
import com.learning.invoice.model.GeneratedInvoice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class GeneratedInvoiceSenderImpl implements GeneratedInvoiceSender {

    Logger logger = LoggerFactory.getLogger(GeneratedInvoiceSenderImpl.class);

    @Autowired
    JmsTemplate jmsTemplate;

    @Override
    public void sendGeneratedInvoice(GeneratedInvoice generatedInvoice) {
        jmsTemplate.convertAndSend(MessagingConfiguration.GENERATEDS_INVOICE_QUEUE_NAME, generatedInvoice);
        logger.info(String.format("Message sent to queue [%s] with data: \n %s", MessagingConfiguration.GENERATEDS_INVOICE_QUEUE_NAME, generatedInvoice));
    }
}
