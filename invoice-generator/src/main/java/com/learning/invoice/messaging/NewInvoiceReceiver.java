package com.learning.invoice.messaging;

import com.learning.invoice.config.MessagingConfiguration;
import com.learning.invoice.model.Invoice;
import com.learning.invoice.service.InvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class NewInvoiceReceiver {

    Logger logger = LoggerFactory.getLogger(NewInvoiceReceiver.class);

    @Autowired
    InvoiceService invoiceService;

    @JmsListener(destination = MessagingConfiguration.NEW_INVOICE_QUEUE_NAME, containerFactory = "myFactory")
    public void receiveMessage(Invoice invoice) {
        logger.info(String.format("Received message from queue [%s] with data: \n %s", MessagingConfiguration.NEW_INVOICE_QUEUE_NAME, invoice));
        invoiceService.createInvoice(invoice);
    }

}