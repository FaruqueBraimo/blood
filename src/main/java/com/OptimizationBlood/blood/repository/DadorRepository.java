package com.OptimizationBlood.blood.repository;

import com.OptimizationBlood.blood.models.Dador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DadorRepository extends JpaRepository<Dador,Integer>{

    Dador findByCodigo(long codigo);

    @Query(value = "Select nome from dador where codigo = 1 ", nativeQuery = true)
    int getDador();

}
