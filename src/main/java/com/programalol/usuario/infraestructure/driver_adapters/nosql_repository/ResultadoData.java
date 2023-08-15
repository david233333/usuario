package com.programalol.usuario.infraestructure.driver_adapters.nosql_repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Resultados")
public class ResultadoData {
    @Id
    private String id;
    private double valor1;
    private double valor2;
    private double resultado;
    private Date fechaOperacion;

}
