package com.itriad.apiestacionamento.repository;

import com.itriad.apiestacionamento.model.ExitPayment;
import com.itriad.apiestacionamento.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ExitPaymentRepository extends JpaRepository<ExitPayment,Long> {


    Optional<ExitPayment> findByVehicleAndDataSaida(Vehicle vehicle, LocalDate dateSaida);


    List<ExitPayment> findByDataSaidaBetween(LocalDate data_inicial, LocalDate  data_final);
}
