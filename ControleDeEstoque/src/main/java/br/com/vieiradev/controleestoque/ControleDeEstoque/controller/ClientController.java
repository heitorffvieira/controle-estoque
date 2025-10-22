package br.com.vieiradev.controleestoque.ControleDeEstoque.controller;

import br.com.vieiradev.controleestoque.ControleDeEstoque.model.Client;
import br.com.vieiradev.controleestoque.ControleDeEstoque.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAll() {
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Client> getById(@PathVariable Long id) {
        return clientService.getById(id);
    }

    @PostMapping
    public Client create(@RequestBody Client client) {
        return clientService.save(client);
    }

    @PutMapping("/{id}")
    public Client uptade(@PathVariable Long id, @RequestBody Client client) {
        client.setId(id);
        return clientService.save(client);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clientService.delete(id);
    }

}
