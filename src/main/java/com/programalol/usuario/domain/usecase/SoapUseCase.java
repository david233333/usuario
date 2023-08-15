package com.programalol.usuario.domain.usecase;

import com.programalol.usuario.domain.model.Resultado;
import com.programalol.usuario.domain.model.gateways.CalculadoraGateway;
import com.programalol.usuario.domain.model.gateways.SoapGateway;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
public class SoapUseCase {

    private final SoapGateway soapGateway;

    public double guardarResultado(double valor1, double valor2) {
        double resultado = valor1 + valor2;
        Resultado resultado1 = new Resultado();
        resultado1.setValor1(valor1);
        resultado1.setValor2(valor2);
        resultado1.setResultado(resultado);
        resultado1.setFechaOperacion(new Date());
        soapGateway.guardarResultado(resultado1);
        return resultado;
    }
}
