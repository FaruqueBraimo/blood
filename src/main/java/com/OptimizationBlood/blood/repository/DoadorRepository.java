package com.OptimizationBlood.blood.repository;

import com.OptimizationBlood.blood.models.Dador;
import com.OptimizationBlood.blood.models.Doador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoadorRepository extends JpaRepository<Doador,Long> {
}
