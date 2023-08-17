package com.programalol.usuario.domain.usecase;

import com.programalol.usuario.domain.model.Resultado;
import com.programalol.usuario.domain.model.excepciones.ResultadoNotFoundException;
import com.programalol.usuario.domain.model.gateways.CalculadoraGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



import java.util.Date;

@RequiredArgsConstructor
public class CalculadoraUseCase {


    private final CalculadoraGateway resultadosGateway;

    public Flux<Resultado> consultarResultados() {
        return resultadosGateway.consultarResultados()
                .switchIfEmpty(Mono.error(new ResultadoNotFoundException("Resultados no encontrado")));
    }

    public Flux<Resultado> consultarResultadosPorFechas(Date fechaInicio, Date fechaFin) {
        return resultadosGateway.consultarResultadosPorFechas(fechaInicio,fechaFin)
                .switchIfEmpty(Mono.error(new ResultadoNotFoundException("Resultados no encontrado")));
    }

    public Mono<Void> guardarSuma(double operand1, double operand2) {
        double suma = operand1 + operand2;
        Resultado resultado = crearResultado(operand1, operand2, suma);
        return resultadosGateway.guardarResultado(resultado);
    }

    private Resultado crearResultado(double valor1, double valor2, double resultado) {
        Resultado resultadoObj = new Resultado();
        resultadoObj.setValor1(valor1);
        resultadoObj.setValor2(valor2);
        resultadoObj.setResultado(resultado);
        resultadoObj.setFechaOperacion(new Date());
        return resultadoObj;
    }


    public Mono<Void>  eliminarResultadoPorValor(double valor) {
        return resultadosGateway.eliminarResultadoPorValor(valor);
    }




}
