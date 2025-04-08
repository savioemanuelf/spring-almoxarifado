package com.spring.almoxarifado.model.Product;

import com.spring.almoxarifado.dtos.RequestItemDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="items")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String descricao;
    private Integer disponiveis;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Product(RequestItemDTO data) {
        this.descricao = data.descricao();
        this.disponiveis = data.disponiveis();
        this.categoria = data.categoria();
    }
}

