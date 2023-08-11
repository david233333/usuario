package com.programalol.usuario.infraestructure.driver_adapters.nosql_repository;

import com.programalol.usuario.domain.model.Resultado;
import com.programalol.usuario.domain.model.gateways.CalculadoraGateway;
import com.programalol.usuario.infraestructure.mapper.MapperResultado;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class ResultadoDataGatewayImpl implements CalculadoraGateway {

    private final MapperResultado mapperResultado;
    private final ResultadoDataRepository resultadoDataRepository;

    @Override
    public Flux<Resultado> consultarResultados() {
        return resultadoDataRepository.findAll()
                .map(mapperResultado::toResultado);
    }

    @Override
    public Mono<Void> sumarYguardarResultados(Resultado resultado) {
        return Mono.just(resultado).map(mapperResultado::toData)
                .flatMap(resultadoDataRepository::save)
                .then();
    }
}
