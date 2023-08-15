package com.programalol.usuario.application.config;

import com.programalol.usuario.domain.model.gateways.CalculadoraGateway;
import com.programalol.usuario.domain.model.gateways.SoapGateway;
import com.programalol.usuario.domain.usecase.CalculadoraUseCase;
import com.programalol.usuario.domain.usecase.SoapUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public CalculadoraUseCase calculadoraUseCase(CalculadoraGateway calculadoraGateway){
        return new CalculadoraUseCase(calculadoraGateway);
    }

    @Bean
    public SoapUseCase soapUseCase(SoapGateway soapGateway){
        return new SoapUseCase(soapGateway);
    }
}
