package br.com.vieiradev.controleestoque.ControleDeEstoque.service;

import br.com.vieiradev.controleestoque.ControleDeEstoque.model.Client;
import br.com.vieiradev.controleestoque.ControleDeEstoque.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> getById(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado.");
        }
        return clientRepository.findById(id);
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public Client update(Long id, Client client) {
        if (!clientRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado.");
        }
        client.setId(id);
        return clientRepository.save(client);
    }

    public void delete(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cliente não encontrado.");
        }
    }

}
