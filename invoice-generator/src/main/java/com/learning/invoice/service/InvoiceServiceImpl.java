package com.learning.invoice.service;

import com.itextpdf.text.DocumentException;
import com.learning.invoice.messaging.GeneratedInvoiceSender;
import com.learning.invoice.model.GeneratedInvoice;
import com.learning.invoice.model.Invoice;
import com.learning.invoice.pdf.PDFGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    Logger logger = LoggerFactory.getLogger(InvoiceServiceImpl.class);
    @Autowired
    GeneratedInvoiceSender generatedInvoiceSender;
    @Autowired
    PDFGenerator PDFGenerator;
    private Map<String, byte[]> PDFdocuments = new HashMap<>();

    @Override
    public void createInvoice(Invoice invoice) {
        try {
            String timestamp = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
            String fileName = String.format("%s_%s.pdf", invoice.getInvoiceNumber(), timestamp);
            byte[] pdf = PDFGenerator.generatePDF(fileName, invoice);
            PDFdocuments.put(fileName, pdf);
            logger.info(String.format("Generated PDF with file name: %s", fileName));
            generatedInvoiceSender.sendGeneratedInvoice(new GeneratedInvoice(invoice.getInvoiceNumber(), fileName));
        } catch (IOException e) {
            logger.error("Error creating Invoice", e);
        } catch (DocumentException e) {
            logger.error("Error creating Invoice", e);
        }
    }

    public Map<String, byte[]> getPDFdocuments() {
        return PDFdocuments;
    }

    public void setPDFdocuments(Map<String, byte[]> PDFdocuments) {
        this.PDFdocuments = PDFdocuments;
    }
}
