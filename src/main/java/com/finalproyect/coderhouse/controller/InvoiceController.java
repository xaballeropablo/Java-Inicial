package com.finalproyect.coderhouse.controller;

import com.finalproyect.coderhouse.dto.InvoiceDto;
import com.finalproyect.coderhouse.entity.Invoice;
import com.finalproyect.coderhouse.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @PostMapping("/sellProduct")
    public Invoice sellProduct(@RequestBody InvoiceDto invoice){
        return invoiceService.sellProduct(invoice);
    }

    @GetMapping("/invoiceId/{id}")
    public Invoice getInvoiceId(@PathVariable(value = "id")@Min(1) Long id) {
        return invoiceService.getById(id);
    }

    @GetMapping("/invoiceByIdClient/{id}")
    public List<Invoice> getInvoiceIdClient(@PathVariable(value = "id")@Min(1) Long id){
        return invoiceService.getByClientId(id);
    }
}
