package br.com.vieiradev.controleestoque.ControleDeEstoque.repository;

import br.com.vieiradev.controleestoque.ControleDeEstoque.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {}
