package com.learning.invoice.controller;

import com.learning.invoice.model.Invoice;
import com.learning.invoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @RequestMapping(value = "/api/v1/invoice", method = RequestMethod.POST)
    public @ResponseBody
    Invoice createInvoice(@RequestBody Invoice invoice){
        invoiceService.createInvoice(invoice);
        return invoice;
    }

    @RequestMapping(value = "/api/v1/invoice", method = RequestMethod.GET)
    public @ResponseBody
    List<Invoice> getInvoices(){
        return Arrays.asList(new Invoice());
    }

}
