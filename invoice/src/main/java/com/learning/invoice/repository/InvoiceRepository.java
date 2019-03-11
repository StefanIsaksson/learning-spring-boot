package com.learning.invoice.repository;

import com.learning.invoice.model.GeneratedInvoice;
import com.learning.invoice.model.Invoice;

import java.util.List;

public interface InvoiceRepository {

    List<Invoice> getInvoices();

    Invoice createInvoice(Invoice invoice);

    GeneratedInvoice updatePdfFileName(GeneratedInvoice generatedInvoice);

}
