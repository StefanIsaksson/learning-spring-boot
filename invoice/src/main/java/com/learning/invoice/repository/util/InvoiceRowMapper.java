package com.learning.invoice.repository.util;

import com.learning.invoice.model.Invoice;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InvoiceRowMapper implements RowMapper<Invoice> {

    @Override
    public Invoice mapRow(ResultSet rs, int rowNum) throws SQLException {
        Invoice invoice = new Invoice();
        invoice.setId(rs.getString("ID"));
        invoice.setInvoiceNumber(rs.getString("INVOICE_NUMBER"));
        invoice.setClientName(rs.getString("CLIENT_NAME"));
        invoice.setClientAdress(rs.getString("CLIENT_ADRESS"));
        invoice.setInvoiceTotal(rs.getBigDecimal("INVOICE_TOTAL"));
        invoice.setInvoiceDate(rs.getString("INVOICE_DATE"));
        invoice.setDueDate(rs.getString("DUE_DATE"));
        invoice.setPdfFileName(rs.getString("PDF_FILE_NAME"));
        return invoice;
    }
}
