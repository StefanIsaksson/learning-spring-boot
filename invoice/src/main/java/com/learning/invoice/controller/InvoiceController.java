package com.learning.invoice.controller;

import com.learning.invoice.model.Invoice;
import com.learning.invoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @RequestMapping(value = "/api/v1/invoice", method = RequestMethod.POST)
    public @ResponseBody
    Invoice createInvoice(@RequestBody Invoice invoice) {
        try {
            invoiceService.createInvoice(invoice);
            return invoice;
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @RequestMapping(value = "/api/v1/invoice", method = RequestMethod.GET)
    public @ResponseBody
    List<Invoice> getInvoices() {
        return invoiceService.getInvoices();
    }

}
