package com.itriad.apiestacionamento.repository;

import com.itriad.apiestacionamento.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {

}
