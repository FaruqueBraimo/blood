package com.OptimizationBlood.blood.repository;

import com.OptimizationBlood.blood.models.Dador;
import com.OptimizationBlood.blood.models.Doacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoacaoRepository extends JpaRepository<Doacao,Integer> {

    Doacao findByCodigo(int codigo);

}
