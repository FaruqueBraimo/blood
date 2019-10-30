package com.OptimizationBlood.blood.repository;

import com.OptimizationBlood.blood.models.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AgendamentoRepository  extends JpaRepository<Agendamento,Integer> {



    Agendamento findByCodigo(int codigo);


}
