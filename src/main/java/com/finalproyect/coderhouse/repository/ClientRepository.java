package com.finalproyect.coderhouse.repository;

import com.finalproyect.coderhouse.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByName(String name);

    Client findBySurname(String surname);

    Client findByCi(Long ci);
}
