package com.programalol.usuario.infraestructure.entry_points;

import com.programalol.usuario.domain.model.soap.SumarRequest;
import com.programalol.usuario.domain.model.soap.SumarResponse;
import com.programalol.usuario.domain.usecase.SoapUseCase;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CalculadoraEndpoint {

    private final SoapUseCase soapUseCase;

    private static final String NAMESPACE_URI = "http://example.com/calculadora";

    public CalculadoraEndpoint(SoapUseCase soapUseCase) {
        this.soapUseCase = soapUseCase;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "sumarRequest")
    @ResponsePayload
    public SumarResponse suma(@RequestPayload SumarRequest request) {
        SumarResponse response = new SumarResponse();
        double resultado = soapUseCase.guardarSuma(request.getValor1(), request.getValor2());
        response.setResultado(resultado);
        return response;
    }
}
