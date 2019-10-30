package com.OptimizationBlood.blood.repository;

import com.OptimizationBlood.blood.models.Dador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DadorRepository extends JpaRepository<Dador,Integer>{

    Dador findByCodigo(long codigo);
//
//    @Query(value = "SELECT  a.codigo, d.codigo from dador d INNER JOIN agendamento a ON (a.codigo = d.codigo) where a.codigo = ?1 ", nativeQuery = true)
//    Dador dador(long codigo);
//



}
