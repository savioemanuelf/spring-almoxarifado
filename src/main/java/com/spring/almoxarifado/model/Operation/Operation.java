package com.spring.almoxarifado.model.Operation;

import com.spring.almoxarifado.dtos.OperationDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="operations")
@EqualsAndHashCode(of = "id_operacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Operation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_operacao;

    private String id_item;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    private LocalDateTime data_hora_operacao;
    private String destino;
    private String observacao;

    public Operation(OperationDTO data) {
        this.id_item = data.id_item();
        this.tipo = data.tipo();
        this.data_hora_operacao = data.data_hora_operacao();
        this.destino = data.destino();
        this.observacao = data.observacao();
    }

}
