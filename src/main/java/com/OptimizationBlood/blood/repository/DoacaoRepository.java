package com.OptimizationBlood.blood.repository;

import com.OptimizationBlood.blood.models.Agendamento;
import com.OptimizationBlood.blood.models.Dador;
import com.OptimizationBlood.blood.models.Doacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DoacaoRepository extends JpaRepository<Doacao,Integer> {

    Doacao findByCodigo(int codigo);






}
