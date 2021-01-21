package com.itriad.apiestacionamento.service;

import com.itriad.apiestacionamento.model.Vehicle;

import java.text.ParseException;

public interface VehicleService {
   Vehicle registerVehicle(Vehicle vehicle) throws ParseException;
}
