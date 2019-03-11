package com.learning.invoice.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.learning.invoice.model.GeneratedInvoice;
import com.learning.invoice.model.Invoice;
import com.learning.invoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;

@Controller
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @RequestMapping(value="/{fileName}", method=RequestMethod.GET)
    public ResponseEntity<byte[]> getPDF(@PathVariable(value = "fileName") String fileName) {
        //byte[] contents = invoiceService.getPDFdocuments().get(fileName);
        byte[] contents = invoiceService.getPDF(fileName);
        if(contents == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Invoice File not found.");        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));

        headers.setContentDispositionFormData(fileName, fileName);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        ResponseEntity<byte[]> response = new ResponseEntity<>(contents, headers, HttpStatus.OK);
        return response;
    }

    @RequestMapping(value = "/api/v1/invoice", method = RequestMethod.GET)
    public @ResponseBody List<String> getInvoices(){
        return invoiceService.getInvoices();
    }

}
