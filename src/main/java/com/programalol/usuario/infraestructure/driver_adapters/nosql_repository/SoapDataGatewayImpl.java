package com.programalol.usuario.infraestructure.driver_adapters.nosql_repository;

import com.programalol.usuario.domain.model.Resultado;
import com.programalol.usuario.domain.model.gateways.SoapGateway;
import com.programalol.usuario.infraestructure.mapper.MapperResultado;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class SoapDataGatewayImpl implements SoapGateway {

    private final MapperResultado mapperResultado;
    private final ResultadoDataRepository resultadoDataRepository;

    @Override
    public void guardarResultado(Resultado resultado) {
        resultadoDataRepository.deleteByValor1(resultado.getValor1());
    }
}
