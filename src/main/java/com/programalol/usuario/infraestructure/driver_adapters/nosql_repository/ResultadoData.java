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
@Document(collection = "operations")
public class ResultadoData {
    @Id
    private String id;
    private int valor1;
    private int valor2;
    private int resultado;
    private Date fechaOperacion;

}
