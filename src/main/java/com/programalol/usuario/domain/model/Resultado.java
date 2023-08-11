package com.programalol.usuario.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Resultado {

    private String id;
    private int valor1;
    private int valor2;
    private int resultado;
    private Date fechaOperacion;
}
