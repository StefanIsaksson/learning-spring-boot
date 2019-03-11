package com.learning.invoice.messaging;

import com.learning.invoice.config.MessagingConfiguration;
import com.learning.invoice.model.GeneratedInvoice;
import com.learning.invoice.model.Invoice;
import com.learning.invoice.service.InvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class GeneatedInvoiceReceiver {

    Logger logger = LoggerFactory.getLogger(GeneatedInvoiceReceiver.class);

    @Autowired
    InvoiceService invoiceService;

    @JmsListener(destination = MessagingConfiguration.GENERATEDS_INVOICE_QUEUE_NAME, containerFactory = "myFactory")
    public void receiveMessage(GeneratedInvoice generatedInvoice) {
        logger.info(String.format("Received message from queue [%s] with data: \n %s", MessagingConfiguration.GENERATEDS_INVOICE_QUEUE_NAME, generatedInvoice));
        invoiceService.updatePdfFileName(generatedInvoice);
    }

}