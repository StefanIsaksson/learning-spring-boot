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
        byte[] contents = invoiceService.getPDFdocuments().get(fileName);
        if(contents == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Invoice File not found.");        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        // Here you have to set the actual filename of your pdf
        //String filename = "output.pdf";
        headers.setContentDispositionFormData(fileName, fileName);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        ResponseEntity<byte[]> response = new ResponseEntity<>(contents, headers, HttpStatus.OK);
        return response;
    }

    private byte[] generatePDF(Invoice invoice) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Document pdfDoc = new Document(PageSize.A4);
            PdfWriter.getInstance(pdfDoc, baos).setPdfVersion(PdfWriter.PDF_VERSION_1_7);
            pdfDoc.open();

            Font myfont = new Font();
            myfont.setStyle(Font.NORMAL);
            myfont.setSize(11);
            pdfDoc.add(new Paragraph("\n"));

            Paragraph para = new Paragraph(invoice + "\n", myfont);
            para.setAlignment(Element.ALIGN_JUSTIFIED);
            pdfDoc.add(para);

            pdfDoc.close();
            return baos.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/api/v1/invoice", method = RequestMethod.GET)
    public @ResponseBody List<Invoice> getInvoices(){
        return Arrays.asList(new Invoice());
    }

}
