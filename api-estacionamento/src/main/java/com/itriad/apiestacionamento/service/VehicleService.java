package com.itriad.apiestacionamento.service;

import com.itriad.apiestacionamento.model.Vehicle;
import org.springframework.data.domain.Page;

import java.text.ParseException;

public interface VehicleService {
   Vehicle registerVehicle(Vehicle vehicle) throws ParseException;

   Page<Vehicle> findAllVehicleParked(int page, int limit);
}
