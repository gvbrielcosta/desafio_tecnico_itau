package com.gabrielcosta.DesafioTecnicoItau.Service;

import com.gabrielcosta.DesafioTecnicoItau.DTO.TransacaoDTO;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class TransacaoService {

    List<TransacaoDTO> transacoes = new ArrayList<>();
    @Getter
    TransacaoDTO transacaoDTO;
    DoubleSummaryStatistics doubleSummaryStatistics;

    public void setTransacaoDTO(TransacaoDTO transacaoDTO) {
        transacoes.add(transacaoDTO);
    }

    public List<TransacaoDTO> getTransacoes(Integer intervaloBusca) {
        OffsetDateTime dateTimeMinus60 = OffsetDateTime.now().minusSeconds(intervaloBusca);
        return transacoes.stream()
                .filter(transacao -> transacao.getDataHora()
                        .isAfter(dateTimeMinus60))
                .toList();

    }

    public void deletarTransacoes() {
        transacoes.clear();
    }
}
