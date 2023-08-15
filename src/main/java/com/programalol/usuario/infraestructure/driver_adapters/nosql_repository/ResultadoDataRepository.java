package com.programalol.usuario.infraestructure.driver_adapters.nosql_repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

public interface ResultadoDataRepository extends ReactiveCrudRepository<ResultadoData, String> {
    Mono<Void> deleteByValor1(double valor1);
    Mono<Void> deleteByFechaOperacionBefore(Date fechaOperacion);
}
