package com.programalol.usuario.domain.model.gateways;

import com.programalol.usuario.domain.model.entity.Resultado;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

public interface CalculadoraGateway {

    Flux<Resultado> consultarResultados();

    Flux<Resultado> consultarResultadosPorFechas(Date fechaInicio, Date fechaFin);

    Mono<Void> guardarResultado(Resultado resultado);

    Mono<Void> eliminarResultadoPorValor(double valor);

}
