package com.itriad.apiestacionamento.repository;

import com.itriad.apiestacionamento.model.StatusVehicle;
import com.itriad.apiestacionamento.model.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {



    Vehicle findByPlacaAndDataEntrada(String placa, LocalDate dataEntrada);

    Page<Vehicle> findAllByDataEntradaAndStatusVehicleOrderByHoraEntradaDesc(LocalDate dataEntrada, StatusVehicle statusVehicle, Pageable pageable);
}
