package com.OptimizationBlood.blood.repository;

import com.OptimizationBlood.blood.models.Sangue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SangueRepository extends JpaRepository<Sangue,Integer> {

    Sangue findByCodigo(Long codigo);
}
