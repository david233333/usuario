package com.programalol.usuario.domain.usecase;

import com.programalol.usuario.domain.model.Resultado;
import com.programalol.usuario.domain.model.gateways.CalculadoraGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@RequiredArgsConstructor
public class CalculadoraUseCase {

    private final CalculadoraGateway resultadosGateway;

    public Flux<Resultado> consultarResultados() {
        return resultadosGateway.consultarResultados();
    }

    public Mono<Void> suma(int operand1, int operand2) {
        int suma = operand1 + operand2;
        Resultado resultado = new Resultado();
        resultado.setValor1(operand1);
        resultado.setValor2(operand2);
        resultado.setResultado(suma);
        resultado.setFechaOperacion(new Date());

        return resultadosGateway.sumarYguardarResultados(resultado);
    }



}
