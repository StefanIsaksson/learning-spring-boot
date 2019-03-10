package com.learning.invoice.messaging;

import com.learning.invoice.config.MessagingConfiguration;
import com.learning.invoice.model.GeneratedInvoice;
import com.learning.invoice.model.Invoice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class GeneatedInvoiceReceiver {

    Logger logger = LoggerFactory.getLogger(GeneatedInvoiceReceiver.class);

    @JmsListener(destination = MessagingConfiguration.GENERATEDS_INVOICE_QUEUE_NAME, containerFactory = "myFactory")
    public void receiveMessage(GeneratedInvoice generatedInvoice) {
        logger.info(String.format("Received message from queue [%s] with data: \n %s", MessagingConfiguration.GENERATEDS_INVOICE_QUEUE_NAME, generatedInvoice));
    }

}