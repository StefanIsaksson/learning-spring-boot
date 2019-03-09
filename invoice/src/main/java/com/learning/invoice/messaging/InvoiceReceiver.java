package com.learning.invoice.messaging;

import com.learning.invoice.config.MessagingConfiguration;
import com.learning.invoice.model.Invoice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class InvoiceReceiver {

    Logger logger = LoggerFactory.getLogger(InvoiceReceiver.class);

    @JmsListener(destination = MessagingConfiguration.INVOICE_QUEUE_NAME, containerFactory = "myFactory")
    public void receiveMessage(Invoice invoice) {
        logger.info(String.format("Received message from queue [%s] with data: \n %s", MessagingConfiguration.INVOICE_QUEUE_NAME, invoice));
    }

}