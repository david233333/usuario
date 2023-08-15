package com.programalol.usuario.infraestructure.entry_points;


import com.programalol.usuario.domain.model.ResultadoRequest;
import com.programalol.usuario.domain.model.Resultado;
import com.programalol.usuario.domain.usecase.CalculadoraUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/calculadora")

public class CalculadoraController {

    @Autowired
    private CalculadoraUseCase calculadoraUseCase;

    @GetMapping("/resultados")
    public Flux<Resultado> consultarResultados() {
        return calculadoraUseCase.consultarResultados();
    }

    @PostMapping("/suma")
    public Mono<Void> sumar(@RequestBody ResultadoRequest request) {
        return calculadoraUseCase.guardarResultado(request.getValor1(), request.getValor2());
    }

    @DeleteMapping("/resultado/{valor}")
    public Mono<Void> eliminarResultadoPorValor(@PathVariable double valor) {
      return calculadoraUseCase.eliminarResultadoPorValor(valor);

    }
}
