package com.finalproyect.coderhouse.controller;

import com.finalproyect.coderhouse.entity.Client;
import com.finalproyect.coderhouse.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Validated
@RestController
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/clientId/{id}")
    public Client getClientId(@PathVariable(value = "id") @Min(1) Long id) {
        return clientService.getById(id);
    }

    @GetMapping("/clientName/{name}")
    public Client getClient(@PathVariable(value = "name")@NotBlank @Pattern(regexp = "[a-zA-Z]+") String name) {
        return clientService.getByName(name);
    }

    @GetMapping("/clientSurname/{surname}")
    public Client getClientSurname(@PathVariable(value = "surname")@NotBlank @Pattern(regexp = "[a-zA-Z]+") String surname) {
        return clientService.getBySurname(surname);
    }

    @GetMapping("/clientCi/{ci}")
    public Client getClientCi(@PathVariable(value = "ci") @Min(100) Long ci) {
        return clientService.getByCi(ci);
    }

    @GetMapping("/client")
    public List<Client> getAllClient() {
        return clientService.getByAllClient();
    }

    @PostMapping("/clientSet")
    public Client setClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @PutMapping("/clientPut")
    public Client putClient(@RequestBody Client client) {
        return clientService.putClientDatabase(client);
    }

    @DeleteMapping("/clientDelete/{id}")
    public String clientDeleted(@PathVariable(value = "id") @Min(1) Long id) {
        return clientService.deleteClient(id);
    }
}
