package com.itriad.apiestacionamento.service;

import com.itriad.apiestacionamento.model.ExitPayment;

public interface ExitPaymentService {

    ExitPayment createExitPayment(String placa, Long id_vehicle);

}
