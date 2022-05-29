package com.finalproyect.coderhouse.service;

import com.finalproyect.coderhouse.entity.Client;
import com.finalproyect.coderhouse.exception.DbException;
import com.finalproyect.coderhouse.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client getById(Long id) {
        log.info("Searching client by id {}", id);
        Optional<Client> clientFound = clientRepository.findById(id);
        if (clientFound.isPresent()) {
            log.info("Client by id {} found", id);
            return clientFound.get();
        } else {
            log.error("Client by id {} not found", id);
            throw new DbException("Client id not found");
        }
    }

    public Client getByName(String name) {
        log.info("Searching client by name {}", name);
        Optional<Client> clientFound = Optional.ofNullable(clientRepository.findByName(name));
        if (clientFound.isPresent()) {
            log.info("Client by name {} found", name);
            return clientFound.get();
        } else {
            log.error("Client by name {} not found", name);
            throw new DbException("(Get) Client name not found");
        }
    }

    public Client getBySurname(String surname) {
        log.info("Searching client by surname {}", surname);
        Optional<Client> clientFound = Optional.ofNullable(clientRepository.findBySurname(surname));
        if (clientFound.isPresent()) {
            log.info("Client by surname {} found", surname);
            return clientFound.get();
        } else {
            log.error("Client by surname {} not found", surname);
            throw new DbException("(Get) Client surname not found");
        }
    }

    public Client getByCi(Long ci) {
        log.info("Searching client by ci {}", ci);
        Optional<Client> clientFound = Optional.ofNullable(clientRepository.findByCi(ci));
        if (clientFound.isPresent()) {
            log.info("Client by ci {} found", ci);
            return clientFound.get();
        } else {
            log.error("Client by ci {} not found", ci);
            throw new DbException("Client ci not found");
        }
    }

    public List<Client> getByAllClient() {
        log.info("Getting all clients");
        return clientRepository.findAll();
    }

    public Client saveClient(Client client) {
        log.info("Saving new client");
        return clientRepository.save(client);
    }

    public Client putClientDatabase(Client client) {
        log.info("Searching client by id {}", client.getId());
        Optional<Client> clientFound = clientRepository.findById(client.getId());
        if (clientFound.isPresent()) {
            log.info("Client by id {} found", client.getId());
            Client putClient = clientFound.get();
            log.info("Set name {} to client id {}", client.getName(), client.getId());
            putClient.setName(client.getName());
            log.info("Set surname");
            putClient.setSurname(client.getSurname());
            log.info("Set address");
            putClient.setAddress(client.getAddress());
            log.info("Set ci");
            putClient.setCi(client.getCi());
            log.info("Saving new data client");
            return clientRepository.save(client);
        } else {
            log.error("Client by id {} not found", client.getId());
            throw new DbException("(Put) Client id not found");
        }
    }

    public String deleteClient(Long id) {
        log.info("Searching client by id {}", id);
        Optional<Client> clientFound = clientRepository.findById(id);
        if (clientFound.isPresent()) {
            log.info("Client by id {} found", id);
            Client deleteClient = clientFound.get();
            clientRepository.deleteById(id);
            return "Client " + deleteClient.getName() + " " + deleteClient.getSurname() + " " + deleteClient.getCi() + " deleted";
        } else {
            log.error("Client by id {} not found", id);
            throw new DbException("(Delete) Client id not found");
        }
    }
}