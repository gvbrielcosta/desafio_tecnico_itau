package com.gabrielcosta.DesafioTecnicoItau.Controller;

import com.gabrielcosta.DesafioTecnicoItau.DTO.TransacaoDTO;
import com.gabrielcosta.DesafioTecnicoItau.Service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransacaoController {

    @Autowired
    TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @GetMapping("/estatistica")
    public ResponseEntity<?> transacao() {
        return ResponseEntity.status(HttpStatus.OK).body(transacaoService.getTransacoes());
    }

    @PostMapping("/transacao")
    public ResponseEntity<?> transacao(@RequestBody TransacaoDTO transacaoDTO) {
        transacaoService.setTransacaoDTO(transacaoDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Transação criada com sucesso");
    }
}
