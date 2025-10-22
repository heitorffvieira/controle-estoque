package br.com.vieiradev.controleestoque.ControleDeEstoque.repository;

import br.com.vieiradev.controleestoque.ControleDeEstoque.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {}
