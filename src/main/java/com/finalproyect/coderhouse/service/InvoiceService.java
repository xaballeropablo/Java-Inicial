package com.finalproyect.coderhouse.service;

import com.finalproyect.coderhouse.dto.InvoiceDto;
import com.finalproyect.coderhouse.entity.Invoice;

import java.util.List;

public interface InvoiceService {

    Invoice sellProduct(InvoiceDto invoiceDto);

    Invoice getById(Long id);

    List<Invoice> getByClientId(Long id);
}
