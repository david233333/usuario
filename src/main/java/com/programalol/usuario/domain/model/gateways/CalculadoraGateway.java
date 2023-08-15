package com.programalol.usuario.domain.model.gateways;

import com.programalol.usuario.domain.model.Resultado;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CalculadoraGateway {

    Flux<Resultado> consultarResultados();

    Mono<Void> guardarResultado(Resultado resultado);

    Mono<Void> eliminarResultadoPorValor(double valor);

}
