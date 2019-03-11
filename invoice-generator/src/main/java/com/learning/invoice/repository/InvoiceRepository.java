package com.learning.invoice.repository;

import com.learning.invoice.model.GeneratedInvoice;
import com.learning.invoice.model.Invoice;

import java.util.List;

public interface InvoiceRepository {

    List<String> getFileNames();

    void createPDF(String pdfFileName, byte[] pdfFileBinaries);

    byte[] getPDF(String pdfFileName);

}
