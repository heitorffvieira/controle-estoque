package br.com.vieiradev.controleestoque.ControleDeEstoque.service;

import br.com.vieiradev.controleestoque.ControleDeEstoque.model.Product;
import br.com.vieiradev.controleestoque.ControleDeEstoque.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Optional<Product> getById(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado.");
        }
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product update(Long id, Product product) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado.");
        }
        product.setId(id);
        return productRepository.save(product);
    }

    public void delete(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new RuntimeException("Produto não encontrado,");
        }
    }

}
