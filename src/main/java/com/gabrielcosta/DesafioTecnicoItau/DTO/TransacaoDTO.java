package com.gabrielcosta.DesafioTecnicoItau.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransacaoDTO {
    private double valor;
    private OffsetDateTime dataHora;
}
