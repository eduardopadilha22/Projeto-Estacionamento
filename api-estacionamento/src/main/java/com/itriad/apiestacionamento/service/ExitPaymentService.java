package com.itriad.apiestacionamento.service;

import com.itriad.apiestacionamento.model.ExitPayment;

import java.text.ParseException;
import java.util.List;

public interface ExitPaymentService {

    ExitPayment createExitPayment(String placa, Long id_vehicle);

    List<ExitPayment> generatedReport(String dataInicial, String dataFinal ) throws ParseException;

}
