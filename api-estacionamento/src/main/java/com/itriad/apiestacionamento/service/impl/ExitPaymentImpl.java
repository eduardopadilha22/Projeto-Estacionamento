package com.itriad.apiestacionamento.service.impl;

import com.itriad.apiestacionamento.Utils.Validate;
import com.itriad.apiestacionamento.model.ExitPayment;
import com.itriad.apiestacionamento.model.StatusVehicle;
import com.itriad.apiestacionamento.model.Vehicle;
import com.itriad.apiestacionamento.repository.ExitPaymentRepository;
import com.itriad.apiestacionamento.repository.VehicleRepository;
import com.itriad.apiestacionamento.service.ExitPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class ExitPaymentImpl implements ExitPaymentService {

    @Autowired
    private ExitPaymentRepository exitPaymentRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public ExitPayment createExitPayment(String placa, Long id_vehicle) {
        ExitPayment exitPayment = new ExitPayment();
        Vehicle vehicle = vehicleRepository.findById(id_vehicle).get();

        LocalTime hora_exit = LocalTime.now();
        LocalDate data_exit = LocalDate.now();
        String dia = Validate.weekDay();

        if (exitPaymentRepository.findByVehicleAndDataSaida(vehicle, data_exit).isPresent()) {
            throw new RuntimeException("Veículo já foi retirado");
        }


        Double paymentAmount = validarDiaValor(dia, vehicle.getHoraEntrada(), hora_exit);

        vehicle.setStatusVehicle(StatusVehicle.RETIRADO);
        vehicle = vehicleRepository.save(vehicle);

        exitPayment.setHoraSaida(hora_exit);
        exitPayment.setDataSaida(data_exit);
        exitPayment.setVehicle(vehicle);
        exitPayment.setTotalPagamento(paymentAmount);

        try {
            exitPayment = exitPaymentRepository.save(exitPayment);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar no banco");
        }
        return exitPayment;

    }

    public Double validarDiaValor(String dia, LocalTime time_entry, LocalTime time_exit) {

        switch (dia) {
            case "Sábado":
            case "Domingo":
                return calcularValorFS(time_entry, time_exit);
            default:
                return calcularValorDefault(time_entry, time_exit);

        }


    }

    public Double calcularValorFS(LocalTime time_entry, LocalTime time_exit) {
        int horasTotal = time_exit.getHour() - time_entry.getHour();
        int minutosTotal = time_exit.getMinute() - time_entry.getMinute();

        return horasTotal * 2.5;
    }

    public Double calcularValorDefault(LocalTime time_entry, LocalTime time_exit) {

        int horasTotal = time_exit.getHour() - time_entry.getHour();
        int minutosTotal = time_exit.getMinute() - time_entry.getMinute();

        Double paymentAmount = 0D;

        if (time_entry.getHour() >= 8 && time_entry.getMinute() > 0 && time_exit.getHour() <= 12 && time_exit.getMinute() == 0) {
            return horasTotal * 2.0;
        } else if (time_entry.getHour() >= 12 && time_exit.getHour() <= 18) {
            return horasTotal * 3.0;
        } else {
            for (int i = time_entry.getHour(); i < time_exit.getHour(); i++) {
                if (i < 12) {
                    paymentAmount += 2.0;
                } else
                    paymentAmount += 3.0;
            }
        }

        return paymentAmount;
    }


}
