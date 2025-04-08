package com.spring.almoxarifado.controller;

import com.spring.almoxarifado.dtos.OperationDTO;
import com.spring.almoxarifado.model.Operation.Operation;
import com.spring.almoxarifado.repositories.OperationRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/operacoes")
public class OperationController {
    @Autowired
    OperationRepository repository;

    @GetMapping
    public ResponseEntity getAllOperation() {
        List<Operation> operacoes = repository.findAll();
        return ResponseEntity.ok(operacoes);
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity getOperationByTipo(@PathVariable String tipo) {
        List<Operation> foundRequest = repository.findByTipo(tipo);
        return ResponseEntity.ok(foundRequest);
    }

    @GetMapping("/destino/{destino}")
    public ResponseEntity getOperationByDestination(@PathVariable String destino) {
        List<Operation> foundRequest = repository.findByDestino(destino);
        return ResponseEntity.ok(foundRequest);
    }

    @PostMapping
    public ResponseEntity saveOperation(@RequestBody @Valid OperationDTO data) {
        Operation operation = new Operation(data);
        repository.save(operation);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateOperation(@PathVariable Long id, @RequestBody @Valid OperationDTO data) {
        Optional<Operation> optionalOperation = repository.findById(id);
        if (optionalOperation.isPresent()) {
            Operation operation = optionalOperation.get();
            operation.setData_hora_operacao(data.data_hora_operacao());
            operation.setTipo(data.tipo());
            operation.setDestino(data.destino());
            operation.setId_item(data.id_item());
            operation.setObservacao(data.observacao());
            repository.save(operation);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOperation(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
