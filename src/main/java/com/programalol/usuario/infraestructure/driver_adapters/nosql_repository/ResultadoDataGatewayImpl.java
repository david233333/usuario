package com.programalol.usuario.infraestructure.driver_adapters.nosql_repository;

import com.programalol.usuario.domain.model.Resultado;
import com.programalol.usuario.domain.model.gateways.CalculadoraGateway;
import com.programalol.usuario.infraestructure.mapper.MapperResultado;
import lombok.RequiredArgsConstructor;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Repository
@RequiredArgsConstructor
public class ResultadoDataGatewayImpl implements CalculadoraGateway, Job {

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

    @Override
    public Mono<Void> eliminarPorValor(int valor) {
        return resultadoDataRepository.deleteByValor1(valor);
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // Este método se ejecuta cuando Quartz programa la tarea para ser ejecutada.
        // El parámetro JobExecutionContext proporciona el contexto de ejecución de la tarea.

        Date oneDayAgo = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
        resultadoDataRepository.deleteByFechaOperacionBefore(oneDayAgo).subscribe();
    }


}
