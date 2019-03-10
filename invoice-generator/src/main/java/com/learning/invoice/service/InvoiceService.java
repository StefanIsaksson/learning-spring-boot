package com.learning.invoice.service;

import com.learning.invoice.model.Invoice;

import java.util.Map;

public interface InvoiceService {

    void createInvoice(Invoice invoice);

    Map<String, byte[]> getPDFdocuments();
}
