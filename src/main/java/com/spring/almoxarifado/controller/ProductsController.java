package com.spring.almoxarifado.controller;


import com.spring.almoxarifado.dtos.RequestItemDTO;
import com.spring.almoxarifado.model.Product.Product;
import com.spring.almoxarifado.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProductsController {
    @Autowired
    private ProductRepository repository;

    @GetMapping
    public ResponseEntity getAllItems() {
        List<Product> products = repository.findAll();
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity addNewItem(@RequestBody @Valid RequestItemDTO data) {
        Product product = new Product(data);
        repository.save(product);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateItem(@RequestBody @Valid RequestItemDTO data) {
        Optional<Product> optionalProduct = repository.findById(data.id());
        if(optionalProduct.isPresent()) {
            Product product = optionalProduct.get();

            product.setDescricao(data.descricao());
            product.setDisponiveis(data.disponiveis());
            product.setCategoria(data.categoria());

            repository.save(product);
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteItem(@PathVariable String id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
