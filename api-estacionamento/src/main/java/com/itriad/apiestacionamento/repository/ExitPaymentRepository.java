package com.itriad.apiestacionamento.repository;

import com.itriad.apiestacionamento.model.ExitPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExitPaymentRepository extends JpaRepository<ExitPayment,Long> {
}
