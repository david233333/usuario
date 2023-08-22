package com.programalol.usuario.domain.usecase;

import com.programalol.usuario.domain.model.entity.Resultado;
import com.programalol.usuario.domain.model.gateways.SoapGateway;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
public class SoapUseCase {

    private final SoapGateway soapGateway;

    public double guardarSuma(double valor1, double valor2) {
        double suma = valor1 + valor2;
        Resultado resultado = crearResultado(valor1, valor2, suma);
        soapGateway.guardarResultado(resultado);
        return suma;
    }

    private Resultado crearResultado(double valor1, double valor2, double resultado) {
        Resultado resultadoObj = new Resultado();
        resultadoObj.setValor1(valor1);
        resultadoObj.setValor2(valor2);
        resultadoObj.setResultado(resultado);
        resultadoObj.setFechaOperacion(new Date());
        return resultadoObj;
    }
}
