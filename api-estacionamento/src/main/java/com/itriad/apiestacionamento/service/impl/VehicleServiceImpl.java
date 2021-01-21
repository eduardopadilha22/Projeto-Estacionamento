package com.itriad.apiestacionamento.service.impl;

import com.itriad.apiestacionamento.model.Vehicle;
import com.itriad.apiestacionamento.service.VehicleService;

import org.springframework.stereotype.Service;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Override
    public Object registerVehicle(Vehicle vehicle) {

        if(vehicle.getPlaca() == null && vehicle.getCor() == null && vehicle.getModelo() == null) {
            throw new RuntimeException("ERROR");
        }

        LocalTime hora_entrada = LocalTime.now();
        LocalDate data_entrada = LocalDate.now();
        Calendar c = new GregorianCalendar();
        String calendar =  weekDay(c);
        System.out.println(hora_entrada);
        System.out.println(calendar);
        return  null;
    }


    public String weekDay(Calendar cal) { return new DateFormatSymbols().getWeekdays()[cal.get(Calendar.DAY_OF_WEEK)]; }
}
