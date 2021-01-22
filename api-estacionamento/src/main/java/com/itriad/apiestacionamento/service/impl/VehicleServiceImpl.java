package com.itriad.apiestacionamento.service.impl;

import com.itriad.apiestacionamento.Utils.Validate;
import com.itriad.apiestacionamento.model.StatusVehicle;
import com.itriad.apiestacionamento.model.Vehicle;
import com.itriad.apiestacionamento.repository.VehicleRepository;
import com.itriad.apiestacionamento.service.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;


    @Override
    public Vehicle registerVehicle(Vehicle vehicle) throws ParseException {

        if (vehicle.getPlaca() == null || vehicle.getCor() == null || vehicle.getModelo() == null) {
            throw new RuntimeException("ERROR");
        }

        LocalTime hora_entrada = LocalTime.now();
        LocalDate data_entrada = LocalDate.now();


        Vehicle vehicleExists = vehicleRepository.findByPlacaAndDataEntrada(vehicle.getPlaca(), data_entrada);

        if (vehicleExists != null) {
            throw new RuntimeException("Veículo ja foi estacionado nesta data");
        }

        if (!Validate.validaHoraEntrada(hora_entrada)) {
            throw new RuntimeException("Hora de entradas somente as 08:00 até as 17:59");
        }


        vehicle.setHoraEntrada(hora_entrada);
        vehicle.setDataEntrada(data_entrada);
        vehicle.setStatusVehicle(StatusVehicle.ESTACIONADO);


        try {
            vehicle = vehicleRepository.save(vehicle);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar Veículo");
        }

        return vehicle;

    }

    @Override
    public Page<Vehicle> findAllVehicleParked(int page, int limit) {
        Page<Vehicle> listVehicle = null;
        PageRequest pageable = PageRequest.of(page-1,limit, Sort.by("placa"));
        listVehicle = vehicleRepository.findAll(pageable);

        return listVehicle;
    }
}
