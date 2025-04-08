package com.spring.almoxarifado.repositories;

import com.spring.almoxarifado.model.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
