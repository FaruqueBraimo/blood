package com.OptimizationBlood.blood.repository;

import com.OptimizationBlood.blood.models.Triagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TriagemRepository extends JpaRepository<Triagem,Integer> {

    Triagem findByCodigo(long codigo);


}
