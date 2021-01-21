package com.itriad.apiestacionamento.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
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

    @Temporal(TemporalType.TIME)
    @Column(name = "hora_saida")
    private Date horaSaida;

    @Temporal(TemporalType.TIME)
    @Column(name = "data_saida")
    private Date dataSaida;

    @Column(name = "total_pagamento")
    private Double totalPagamento;

}
