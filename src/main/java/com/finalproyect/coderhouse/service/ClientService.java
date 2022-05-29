package com.finalproyect.coderhouse.service;

import com.finalproyect.coderhouse.entity.Client;

import java.util.List;

public interface ClientService {

    Client getById(Long id);

    Client getByName(String name);

    Client getBySurname(String surname);

    Client getByCi(Long ci);

    List<Client> getByAllClient();

    Client saveClient(Client client);

    Client putClientDatabase(Client client);

    String deleteClient(Long id);
}
