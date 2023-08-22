package com.programalol.usuario.domain.model.gateways;

import com.programalol.usuario.domain.model.entity.Resultado;
import reactor.core.publisher.Mono;

public interface SoapGateway {

    Mono<Void> guardarResultado(Resultado resultado);
}
