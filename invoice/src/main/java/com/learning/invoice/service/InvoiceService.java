package com.learning.invoice.service;

import com.learning.invoice.model.GeneratedInvoice;
import com.learning.invoice.model.Invoice;

import java.util.List;

public interface InvoiceService {

    void createInvoice(Invoice invoice);

    List<Invoice> getInvoices();

    GeneratedInvoice updatePdfFileName(GeneratedInvoice generatedInvoice);
}
