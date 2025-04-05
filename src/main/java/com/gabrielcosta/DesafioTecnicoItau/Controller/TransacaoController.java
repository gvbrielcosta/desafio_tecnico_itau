package com.gabrielcosta.DesafioTecnicoItau.Controller;

import com.gabrielcosta.DesafioTecnicoItau.DTO.TransacaoDTO;
import com.gabrielcosta.DesafioTecnicoItau.Service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.time.OffsetDateTime;
@RequestMapping("/transacao")
@RestController
public class TransacaoController {

    @Autowired
    TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping()
    public ResponseEntity<Void> transacao(@RequestBody TransacaoDTO transacaoDTO) {
        if (transacaoDTO.getDataHora() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else if (transacaoDTO.getDataHora().isAfter(OffsetDateTime.now()) || transacaoDTO.getValor() < 0) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        transacaoService.setTransacaoDTO(transacaoDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @DeleteMapping()
    public ResponseEntity<?> deletar() {
        transacaoService.deletarTransacoes();
        return ResponseEntity.ok().build();
    }
}
