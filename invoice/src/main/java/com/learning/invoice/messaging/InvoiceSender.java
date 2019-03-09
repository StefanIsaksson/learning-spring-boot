package com.learning.invoice.messaging;

import com.learning.invoice.model.Invoice;

public interface InvoiceSender {

    void sendInvoice(Invoice invoice);
}
