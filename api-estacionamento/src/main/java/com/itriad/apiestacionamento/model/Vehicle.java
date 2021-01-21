package com.itriad.apiestacionamento.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity(name = "vehicle")
@Setter
@Getter
public class Vehicle  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String placa;

    private String modelo;

    private String cor;

    @Temporal(TemporalType.TIME)
    @Column(name = "hora_entrada")
    private Date horaEntrada;

    @Column(name = "data_entrada")
    @Temporal(TemporalType.DATE)
    private Date dataEntrada;

    @Enumerated(EnumType.STRING)
    private StatusVehicle statusVehicle;

}
