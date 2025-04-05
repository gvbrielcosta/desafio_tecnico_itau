package com.gabrielcosta.DesafioTecnicoItau.Service;

import com.gabrielcosta.DesafioTecnicoItau.DTO.EstatisticasDTO;
import com.gabrielcosta.DesafioTecnicoItau.DTO.TransacaoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EstatisticasService {
    private final TransacaoService transacaoService;

    public EstatisticasDTO getEstatisticas(Integer intervaloBusca) {
        List<TransacaoDTO> transacoes = transacaoService.getTransacoes(intervaloBusca);

        DoubleSummaryStatistics estatisticasTransacoes = transacoes.stream().mapToDouble(TransacaoDTO::getValor).summaryStatistics();

        return new EstatisticasDTO(
                estatisticasTransacoes.getCount(),
                estatisticasTransacoes.getSum(),
                estatisticasTransacoes.getAverage(),
                estatisticasTransacoes.getMin(),
                estatisticasTransacoes.getMax());
    }
}
