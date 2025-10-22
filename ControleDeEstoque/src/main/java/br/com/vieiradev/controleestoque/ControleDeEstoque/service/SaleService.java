package br.com.vieiradev.controleestoque.ControleDeEstoque.service;

import br.com.vieiradev.controleestoque.ControleDeEstoque.model.Sale;
import br.com.vieiradev.controleestoque.ControleDeEstoque.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    private SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public List<Sale> getAll() {
        return saleRepository.findAll();
    }

    public Optional<Sale> getById(Long id) {
        if (!saleRepository.existsById(id)) {
            throw new RuntimeException("Venda não encontrada.");
        }
        return saleRepository.findById(id);
    }

    public Sale save(Sale sale) {
        return saleRepository.save(sale);
    }

    public Sale update(Long id, Sale sale) {
        if (!saleRepository.existsById(id)) {
            throw new RuntimeException("Venda não encontrada.");
        }
        sale.setId(id);
        return saleRepository.save(sale);
    }

    public void delete(Long id) {
        if (saleRepository.existsById(id)) {
            saleRepository.deleteById(id);
        } else {
            throw new RuntimeException("Venda não encontrada.");
        }
    }

}
