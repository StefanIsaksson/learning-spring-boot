package com.learning.invoice.repository;

import com.learning.invoice.model.GeneratedInvoice;
import com.learning.invoice.model.Invoice;
import com.learning.invoice.repository.util.InvoiceRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InvoiceRepositoryImpl implements InvoiceRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Invoice> getInvoices() {
        List<Invoice> invoices = jdbcTemplate.query("select * from invoice", new InvoiceRowMapper());
        return invoices;
    }

    @Override
    public Invoice createInvoice(Invoice invoice) {
        jdbcTemplate.update("insert into invoice (ID, INVOICE_NUMBER, CLIENT_NAME, CLIENT_ADRESS, INVOICE_TOTAL, INVOICE_DATE, DUE_DATE, PDF_FILE_NAME) values (?,?,?,?,?,?,?,?)",
                invoice.getId(), invoice.getInvoiceNumber(), invoice.getClientName(), invoice.getClientAdress(),
                invoice.getInvoiceTotal(), invoice.getInvoiceDate(), invoice.getDueDate(), invoice.getPdfFileName());
        return invoice;
    }

    @Override
    public GeneratedInvoice updatePdfFileName(GeneratedInvoice generatedInvoice) {
        jdbcTemplate.update("update invoice set PDF_FILE_NAME = ? where INVOICE_NUMBER = ?",
                generatedInvoice.getFileName(), generatedInvoice.getInvoiceNumber());
        return generatedInvoice;
    }
}
