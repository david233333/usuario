package com.programalol.usuario.domain.model.gateways;

import com.programalol.usuario.domain.model.Resultado;
import reactor.core.publisher.Mono;

public interface SoapGateway {

    void guardarResultado(Resultado resultado);
}
