package com.learning.invoice.model;

public class GeneratedInvoice {

    String invoiceNumber;
    String fileName;

    public GeneratedInvoice() {
    }

    public GeneratedInvoice(String invoiceNumber, String fileName) {
        this.invoiceNumber = invoiceNumber;
        this.fileName = fileName;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return String.format("{invoiceNumber:\"%s\", fileName:\"%s\"}", getInvoiceNumber(),getFileName());
    }
}
