package com.finalproyect.coderhouse.service;

import com.finalproyect.coderhouse.dto.InvoiceDto;
import com.finalproyect.coderhouse.entity.*;
import com.finalproyect.coderhouse.exception.DbException;
import com.finalproyect.coderhouse.repository.ClientRepository;
import com.finalproyect.coderhouse.repository.InvoiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    ProductService productService;

    @Autowired
    ClientService clientService;

    @Autowired
    EnterpriseService enterpriseService;

    public Invoice sellProduct(InvoiceDto invoiceDto) {
        log.info("Searching client {}", invoiceDto.getClient());
        if (Objects.isNull(invoiceDto.getClient())) {
            throw new RuntimeException("Client not found");
        }

        log.info("Creating variable client");
        Client client;

        try {
            log.info("Searching client by ci {}", invoiceDto.getClient().getCi());
            client = clientService.getByCi(invoiceDto.getClient().getCi());
        } catch (DbException e) {
            log.info("Saving client by ci {}", invoiceDto.getClient().getCi());
            client = clientService.saveClient(invoiceDto.getClient());
        }

        log.info("Searching enterprise {}", invoiceDto.getEnterprise());
        if (Objects.isNull(invoiceDto.getEnterprise())) {
            throw new RuntimeException("Enterprise not found");
        }

        log.info("Getting enterprise by name {}", invoiceDto.getEnterprise().getName());
        Enterprise enterprise = enterpriseService.getByName(invoiceDto.getEnterprise().getName());

        log.info("Creating new invoice");
        Invoice invoice = new Invoice();
        log.info("Set date to invoice");
        invoice.setDate(invoiceDto.getDate());
        log.info("Set invoice type to invoice");
        invoice.setInvoiceType(invoiceDto.getInvoiceType());
        log.info("Set total to invoice");
        invoice.setTotal(invoiceDto.getTotal());
        log.info("Set client to invoice");
        invoice.setClient(client);
        log.info("Set enterprise to invoice");
        invoice.setEnterprise(enterprise);
        log.info("Creating empty list");
        invoice.setInvoiceDetail(new HashSet<>());

        log.info("Touring list, calling the change stock method");
        invoiceDto.getInvoiceDetails().forEach(invoiceDetailDto -> {

            Product product = productService.getByName(invoiceDetailDto.getProduct().getName());

            if (invoiceDetailDto.getAmount() > product.getStock()) {
                log.error("The required quantity exceeds the stock");
                throw new DbException("Insufficient stock, quantity available: " + product.getStock());
            }

            productService.changeStock(product.getId(), invoiceDetailDto.getAmount());

            log.info("Creating new invoice detail");
            InvoiceDetail invoiceDetail = new InvoiceDetail();
            log.info("Set product id {} to invoice detail", product.getId());
            invoiceDetail.setProductId(product.getId());
            log.info("Set amount {} required to invoice detail", invoiceDetailDto.getAmount());
            invoiceDetail.setAmount(invoiceDetailDto.getAmount());
            log.info("Setting invoice to invoice detail");
            invoiceDetail.setInvoice(invoice);
            log.info("Adding detail to invoice");
            invoice.addDetail(invoiceDetail);

        });

        return invoiceRepository.save(invoice);
    }

    public Invoice getById(Long id) {
        log.info("Searching invoice by id {}", id);
        Optional<Invoice> invoiceFound = invoiceRepository.findById(id);
        if (invoiceFound.isPresent()) {
            log.info("Invoice by id {} found", id);
            return invoiceFound.get();
        } else {
            log.error("Invoice by id {} not found", id);
            throw new DbException("Invoice id not found");
        }
    }

    public List<Invoice> getByClientId(Long id) {
        log.info("Calling the find client by ClientServiceImpl id method and return a list of invoices");
        return invoiceRepository.findAllByClient(clientService.getById(id));
    }
}
