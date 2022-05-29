package com.finalproyect.coderhouse.repository;

import com.finalproyect.coderhouse.entity.Client;
import com.finalproyect.coderhouse.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    List<Invoice> findAllByClient(Client client);
}
