package com.itriad.apiestacionamento.controller;

import com.itriad.apiestacionamento.model.Vehicle;
import com.itriad.apiestacionamento.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/api")
@AllArgsConstructor

public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/vehicle")
    @CrossOrigin("*")
    public Vehicle saveVehicle(@RequestBody Vehicle vehicle) throws ParseException {
        Vehicle result = vehicleService.registerVehicle(vehicle);
        return result;
    }

    @GetMapping("/vehicle")
    @CrossOrigin("*")
    public Page<Vehicle> AllVehicleParked(@RequestParam(value = "page" ) int page,
                                          @RequestParam(value = "limit") int limit)  {
        return vehicleService.findAllVehicleParked(page, limit);
    }

}
