package br.com.vieiradev.controleestoque.ControleDeEstoque.controller;

import br.com.vieiradev.controleestoque.ControleDeEstoque.dto.SaleRequestDTO;
import br.com.vieiradev.controleestoque.ControleDeEstoque.model.Sale;
import br.com.vieiradev.controleestoque.ControleDeEstoque.service.SaleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sale")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping
    public List<Sale> getAll() {
        return saleService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Sale> getById(@PathVariable Long id) {
        return saleService.getById(id);
    }

    @PostMapping
    public Sale save(@RequestBody Sale sale) {
        return saleService.save(sale);
    }

    @PutMapping("/{id}")
    public Sale update(@PathVariable Long id, @RequestBody Sale sale) {
        return saleService.update(id, sale);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        saleService.delete(id);
    }

    @PostMapping("/realizar")
    public Sale realizarVenda(@RequestBody SaleRequestDTO dto) {
        return saleService.realizarVenda(dto);
    }
}

