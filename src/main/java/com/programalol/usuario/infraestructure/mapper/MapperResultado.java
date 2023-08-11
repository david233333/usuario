package com.programalol.usuario.infraestructure.mapper;

import com.programalol.usuario.domain.model.Resultado;
import com.programalol.usuario.infraestructure.driver_adapters.nosql_repository.ResultadoData;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class MapperResultado {

    public Resultado toResultado (ResultadoData resultadoData){
        return new Resultado(
                resultadoData.getId(),
                resultadoData.getValor1(),
                resultadoData.getValor2(),
                resultadoData.getResultado(),
                resultadoData.getFechaOperacion()
        );

    }

    public ResultadoData toData (Resultado resultado){
        return new ResultadoData(
                resultado.getId(),
                resultado.getValor1(),
                resultado.getValor2(),
                resultado.getResultado(),
                resultado.getFechaOperacion()
        );

    }
}
