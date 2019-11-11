package com.OptimizationBlood.blood.repository;

import com.OptimizationBlood.blood.models.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface AgendamentoRepository  extends JpaRepository<Agendamento,Integer> {



    Agendamento findByCodigo(int codigo);



    @Query(value = "select count(*) from agendamento", nativeQuery = true)
    String contagem();



    @Query(value = "select count(*) from agendamento where status = 'realizada' ", nativeQuery = true)
    String realizados();


    @Query(value = "select * from agendamento where dador_codigo =  ?1 and  status = 'por realizar' ", nativeQuery = true)
    int procuar( int codigo );

  
    @Query(value = "select * from agendamento where  status = 'por realizar' ", nativeQuery = true)
    List<Agendamento> agendamento( );


    @Query(value = "select data from agendamento where dador_id = 3", nativeQuery = true)
    Agendamento agendamentoDador( int codigo );





}
