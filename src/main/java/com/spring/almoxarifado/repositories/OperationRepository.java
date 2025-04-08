package com.spring.almoxarifado.repositories;

import com.spring.almoxarifado.model.Operation.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OperationRepository extends JpaRepository<Operation, Long> {

    List<Operation> findByTipo(String tipo);
    List<Operation> findByDestino(String destino);

    default List<Operation> findByDate(LocalDateTime date) {
        return findByDate(date);
    }
}
