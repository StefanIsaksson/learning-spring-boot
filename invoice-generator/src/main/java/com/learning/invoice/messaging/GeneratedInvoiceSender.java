package com.learning.invoice.messaging;

import com.learning.invoice.model.GeneratedInvoice;

public interface GeneratedInvoiceSender {

    void sendGeneratedInvoice(GeneratedInvoice generatedInvoice);
}
