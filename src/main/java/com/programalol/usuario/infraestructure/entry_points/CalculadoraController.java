package com.programalol.usuario.infraestructure.entry_points;


import com.programalol.usuario.domain.model.dto.ResultadoRequest;
import com.programalol.usuario.domain.model.entity.Resultado;
import com.programalol.usuario.domain.model.excepciones.ResultadoNotFoundException;
import com.programalol.usuario.domain.usecase.CalculadoraUseCase;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/calculadora")

public class CalculadoraController {


    private final CalculadoraUseCase calculadoraUseCase;

    public CalculadoraController(CalculadoraUseCase calculadoraUseCase) {
        this.calculadoraUseCase = calculadoraUseCase;
    }


    @GetMapping("/resultados")
    public Flux<Resultado> consultarResultados() {
            return calculadoraUseCase.consultarResultados();
    }

    @GetMapping("/resultadosFechaOperacion")
    public Flux<Resultado> getResultadosPorRangoDeFechas(
            @RequestParam("fechaInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
            @RequestParam("fechaFin")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin) {

        return calculadoraUseCase.consultarResultadosPorFechas(fechaInicio, fechaFin);
    }

    @PostMapping("/suma")
    public Mono<Void> guardarSuma(@RequestBody ResultadoRequest request) {
        return calculadoraUseCase.guardarSuma(request.getValor1(), request.getValor2());
    }

    @DeleteMapping("/resultado/{valor}")
    public ResponseEntity<Void> eliminarResultadoPorValor(@PathVariable double valor) {
        try {
            calculadoraUseCase.eliminarResultadoPorValor(valor);
            return ResponseEntity.ok().build();
        } catch (ResultadoNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
