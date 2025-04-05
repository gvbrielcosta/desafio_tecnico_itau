package com.gabrielcosta.DesafioTecnicoItau.Controller;

import com.gabrielcosta.DesafioTecnicoItau.Service.EstatisticasService;
import com.gabrielcosta.DesafioTecnicoItau.Service.TransacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
@RequiredArgsConstructor
public class EstatisticaController {

    private final EstatisticasService estatisticasService;

    @GetMapping
    public ResponseEntity<?> getEstatisticas(@RequestParam(value = "intervaloBusca",required = false, defaultValue = "60") Integer intervaloBusca) {
        return ResponseEntity.ok(estatisticasService.getEstatisticas(intervaloBusca));
    }
}
