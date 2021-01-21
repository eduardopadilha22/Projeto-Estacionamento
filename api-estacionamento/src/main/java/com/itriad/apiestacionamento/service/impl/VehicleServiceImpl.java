package com.itriad.apiestacionamento.service.impl;

import com.itriad.apiestacionamento.model.Vehicle;
import com.itriad.apiestacionamento.service.VehicleService;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Override
    public Object registerVehicle(Vehicle vehicle) {

        if(vehicle.getPlaca() == null && vehicle.getCor() == null && vehicle.getModelo() == null) {
            throw new RuntimeException("ERROR");
        }

        LocalTime hora_entrada = LocalTime.now();
        LocalDate data_entrada = LocalDate.now();
        System.out.println(hora_entrada);
        System.out.println(data_entrada);
        return  null;
    }
}
