package com.learning.invoice.service;

import com.learning.invoice.messaging.InvoiceSender;
import com.learning.invoice.model.GeneratedInvoice;
import com.learning.invoice.model.Invoice;
import com.learning.invoice.repository.InvoiceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    Logger logger = LoggerFactory.getLogger(InvoiceServiceImpl.class);


    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    InvoiceSender invoiceSender;

    @Override
    public void createInvoice(Invoice invoice) throws IllegalArgumentException {
        boolean invoiceNumberExists = invoiceRepository.getInvoices().stream().map(Invoice::getInvoiceNumber).anyMatch(p -> p.equals(invoice.getInvoiceNumber()));
        if (invoiceNumberExists) {
            throw new IllegalArgumentException(String.format("Invoice number %s already exists.", invoice.getInvoiceNumber()));
        }

        invoice.setId(generateUUID());
        invoiceRepository.createInvoice(invoice);
        invoiceSender.sendInvoice(invoice);
    }

    @Override
    public List<Invoice> getInvoices() {
        return invoiceRepository.getInvoices();
    }

    @Override
    public GeneratedInvoice updatePdfFileName(GeneratedInvoice generatedInvoice) {
        return invoiceRepository.updatePdfFileName(generatedInvoice);
    }

    private String generateUUID() {
        return java.util.UUID.randomUUID().toString();
    }
}
