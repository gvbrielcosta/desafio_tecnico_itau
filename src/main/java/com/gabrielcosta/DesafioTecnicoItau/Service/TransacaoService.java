package com.gabrielcosta.DesafioTecnicoItau.Service;

import com.gabrielcosta.DesafioTecnicoItau.DTO.TransacaoDTO;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {

    List<TransacaoDTO> transacoes = new ArrayList<>();
    @Getter
    TransacaoDTO transacaoDTO;

    public void setTransacaoDTO(TransacaoDTO transacaoDTO) {
        transacoes.add(transacaoDTO);
    }

    public List<TransacaoDTO> getTransacoes() {
        return transacoes;
    }

    public void deletarTransacoes() {
        transacoes.clear();
    }
}
