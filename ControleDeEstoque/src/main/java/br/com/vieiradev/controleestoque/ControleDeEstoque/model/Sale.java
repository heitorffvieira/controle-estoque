package br.com.vieiradev.controleestoque.ControleDeEstoque.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sale_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client clientSale;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product productSale;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employeeSale;

    private Integer quantityProduct;
    private Double saleValue;

}

