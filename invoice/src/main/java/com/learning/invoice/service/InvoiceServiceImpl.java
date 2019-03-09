package com.learning.invoice.service;

import com.learning.invoice.messaging.InvoiceSender;
import com.learning.invoice.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements InvoiceService{

    @Autowired
    InvoiceSender invoiceSender;

    @Override
    public void createInvoice(Invoice invoice) {
        invoiceSender.sendInvoice(invoice);
    }
}
