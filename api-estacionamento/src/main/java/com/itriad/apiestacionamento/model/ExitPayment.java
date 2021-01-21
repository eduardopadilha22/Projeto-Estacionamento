package com.itriad.apiestacionamento.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity(name = "exit_payment")
@Setter
@Getter
public class ExitPayment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @JsonFormat(pattern = "HH:mm:ss")
    @Column(name = "hora_saida")
    private LocalTime horaSaida;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_saida")
    private LocalDate dataSaida;

    @Column(name = "total_pagamento")
    private Double totalPagamento;

}
