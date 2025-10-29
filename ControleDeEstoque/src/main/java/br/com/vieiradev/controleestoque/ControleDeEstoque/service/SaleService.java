package br.com.vieiradev.controleestoque.ControleDeEstoque.service;

import br.com.vieiradev.controleestoque.ControleDeEstoque.dto.SaleRequestDTO;
import br.com.vieiradev.controleestoque.ControleDeEstoque.model.Client;
import br.com.vieiradev.controleestoque.ControleDeEstoque.model.Employee;
import br.com.vieiradev.controleestoque.ControleDeEstoque.model.Product;
import br.com.vieiradev.controleestoque.ControleDeEstoque.model.Sale;
import br.com.vieiradev.controleestoque.ControleDeEstoque.repository.ClientRepository;
import br.com.vieiradev.controleestoque.ControleDeEstoque.repository.EmployeeRepository;
import br.com.vieiradev.controleestoque.ControleDeEstoque.repository.ProductRepository;
import br.com.vieiradev.controleestoque.ControleDeEstoque.repository.SaleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;
    private final ClientRepository clientRepository;
    private final EmployeeRepository employeeRepository;

    public SaleService(SaleRepository saleRepository,
                       ProductRepository productRepository,
                       ClientRepository clientRepository,
                       EmployeeRepository employeeRepository) {
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
        this.clientRepository = clientRepository;
        this.employeeRepository = employeeRepository;
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

    @Transactional
    public Sale realizarVenda(SaleRequestDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Dados da venda não informados.");
        }
        if (dto.getQuantity() == null || dto.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantidade inválida.");
        }

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado."));

        Integer estoqueAtual = product.getQuantity();
        if (estoqueAtual == null || estoqueAtual < dto.getQuantity()) {
            throw new IllegalArgumentException("Estoque insuficiente. Disponível: " + estoqueAtual);
        }

        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));
        Employee employee = employeeRepository.findById(dto.getEmployeeId())
                .orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado."));

        double total = product.getPrice() * dto.getQuantity();

        Sale sale = new Sale();
        sale.setClientSale(client);
        sale.setProductSale(product);
        sale.setEmployeeSale(employee);
        sale.setQuantityProduct(dto.getQuantity());
        sale.setSaleValue(total);

        int novoEstoque = estoqueAtual - dto.getQuantity();
        product.setQuantity(novoEstoque);

        if (novoEstoque <= 0) {
            product.setActive(false);
            productRepository.save(product);
        } else {
            productRepository.save(product);
        }

        return saleRepository.save(sale);
    }
}
