package br.com.vieiradev.controleestoque.ControleDeEstoque.controller;

import br.com.vieiradev.controleestoque.ControleDeEstoque.model.Product;
import br.com.vieiradev.controleestoque.ControleDeEstoque.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        return productService.save(product);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

}
