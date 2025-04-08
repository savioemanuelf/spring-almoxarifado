package com.spring.almoxarifado.dtos;

import com.spring.almoxarifado.model.Operation.Tipo;

import java.time.LocalDateTime;

public record OperationDTO(
        Long id_operacao,
        String id_item,
        Tipo tipo,
        LocalDateTime data_hora_operacao,
        String destino,
        String observacao
        ) {
}
