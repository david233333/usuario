package com.programalol.usuario.infraestructure.entry_points;


import com.programalol.usuario.domain.model.CalculadoraRequest;
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
    public Flux<Resultado> consultarProgramas() {
        return calculadoraUseCase.consultarResultados();
    }

    @PostMapping("/suma")
    public Mono<Void> suma(@RequestBody CalculadoraRequest request) {
        return calculadoraUseCase.suma(request.getValor1(), request.getValor2());
    }

    @DeleteMapping("/eliminar/{valor}")
    public Mono<Void> eliminarPorValor(@PathVariable int valor) {
      return calculadoraUseCase.eliminarPorValor(valor);

    }
}
