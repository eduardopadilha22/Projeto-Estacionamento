package com.itriad.apiestacionamento.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    @JsonFormat(pattern = "HH:mm:ss")
    @Column(name = "hora_entrada")
    private LocalTime horaEntrada;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_entrada")
    private LocalDate dataEntrada;

    @Enumerated(EnumType.STRING)
    private StatusVehicle statusVehicle;

}
