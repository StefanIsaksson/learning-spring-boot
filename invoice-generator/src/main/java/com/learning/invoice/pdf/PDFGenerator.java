package com.learning.invoice.pdf;

import com.itextpdf.text.DocumentException;
import com.learning.invoice.model.Invoice;

import java.io.IOException;

public interface PDFGenerator {

    byte[] generatePDF(String fileName, Invoice invoice) throws IOException, DocumentException;
}
