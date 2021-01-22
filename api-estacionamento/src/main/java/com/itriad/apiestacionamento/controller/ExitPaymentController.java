package com.itriad.apiestacionamento.controller;

import com.itriad.apiestacionamento.model.ExitPayment;
import com.itriad.apiestacionamento.service.ExitPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ExitPaymentController {

    @Autowired
    private ExitPaymentService exitPaymentService;

    @PostMapping("/payment/{placa}/{id_vehicle}")
    @CrossOrigin("*")
    ExitPayment createPayment(@PathVariable(value = "placa") String placa,
                              @PathVariable(value = "id_vehicle") Long idVehicle){
        return exitPaymentService.createExitPayment(placa,idVehicle);
    }
}
