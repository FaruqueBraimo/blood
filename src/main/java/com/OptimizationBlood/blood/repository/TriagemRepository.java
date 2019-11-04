package com.OptimizationBlood.blood.repository;

import com.OptimizationBlood.blood.models.Triagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TriagemRepository extends JpaRepository<Triagem,Integer> {

    Triagem findByCodigo(int codigo);


    @Query(value = "Select *from triagem where status = 'apto' ", nativeQuery = true)
    List<Triagem> aptos();


    @Query(value = "Select *from triagem where status = 'inapto' ", nativeQuery = true)
    List<Triagem> inaptos();



    @Query(value = "select count(*) from triagem where status = 'inapto'", nativeQuery = true)
       String  conInaptos();




    @Query(value = "select count(*) from triagem where status = 'inapto'", nativeQuery = true)
       String  procurar();

}
