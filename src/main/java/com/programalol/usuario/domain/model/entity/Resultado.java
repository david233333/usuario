package com.programalol.usuario.domain.model.entity;

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
    private double valor1;
    private double valor2;
    private double resultado;
    private Date fechaOperacion;
}
