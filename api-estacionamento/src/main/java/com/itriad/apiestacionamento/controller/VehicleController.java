package com.itriad.apiestacionamento.controller;

import com.itriad.apiestacionamento.model.Vehicle;
import com.itriad.apiestacionamento.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/vehicle")
    public ResponseEntity<Object> saveVehicle(@RequestBody Vehicle vehicle){
        Object result = vehicleService.registerVehicle(vehicle);
        return ResponseEntity.ok(result);
    }
}
