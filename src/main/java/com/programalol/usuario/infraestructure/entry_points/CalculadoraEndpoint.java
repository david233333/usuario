package com.programalol.usuario.infraestructure.entry_points;

import com.programalol.usuario.domain.model.soap.SumarRequest;
import com.programalol.usuario.domain.model.soap.SumarResponse;
import com.programalol.usuario.domain.usecase.CalculadoraUseCase;
import com.programalol.usuario.domain.usecase.SoapUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CalculadoraEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/calculadora";

    @Autowired
    private SoapUseCase soapUseCase;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "sumarRequest")
    @ResponsePayload
    public SumarResponse suma(@RequestPayload SumarRequest request) {
        SumarResponse response = new SumarResponse();
        double resultado = soapUseCase.guardarResultado(request.getValor1(), request.getValor2());
        response.setResultado(resultado);
        return response;
    }
}
