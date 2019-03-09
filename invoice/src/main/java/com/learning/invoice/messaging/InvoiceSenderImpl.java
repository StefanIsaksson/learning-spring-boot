package com.learning.invoice.messaging;

import com.learning.invoice.config.MessagingConfiguration;
import com.learning.invoice.model.Invoice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class InvoiceSenderImpl implements InvoiceSender {

    Logger logger = LoggerFactory.getLogger(InvoiceSenderImpl.class);


    @Autowired
    JmsTemplate jmsTemplate;

    @Override
    public void sendInvoice(Invoice invoice) {
        jmsTemplate.convertAndSend(MessagingConfiguration.INVOICE_QUEUE_NAME, invoice);
        logger.info(String.format("Message sent to queue [%s] with data: \n %s", MessagingConfiguration.INVOICE_QUEUE_NAME, invoice));
    }
}
