package com.spring.almoxarifado.dtos;

import com.spring.almoxarifado.model.Product.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestItemDTO(
    String id,
    @NotBlank
    String descricao,
    @NotNull
    Integer disponiveis,
    @NotBlank
    Categoria categoria
    ) {
}
