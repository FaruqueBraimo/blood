package com.OptimizationBlood.blood.resources;


import com.OptimizationBlood.blood.models.Agendamento;
import com.OptimizationBlood.blood.models.Dador;
import com.OptimizationBlood.blood.models.Doacao;
import com.OptimizationBlood.blood.models.Triagem;
import com.OptimizationBlood.blood.repository.DoacaoRepository;
import com.OptimizationBlood.blood.repository.TriagemRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class DoacaoResource {


    @Autowired
    private TriagemRepository tr;

    @Autowired
    private DoacaoRepository dr;






    @PostMapping("doacao/{codigo}")
    public String   guardar(@PathVariable(value = "codigo") int codigo , @RequestBody Doacao doacao){


      
        return "sucesso";
    }

    @GetMapping("/doacoes")
    public List<Doacao> listar(){

        return dr.findAll();



    }



    @DeleteMapping("/doacao")
    @ApiOperation(value="remove uma certa doacao")
    public String deletar(@RequestBody  Doacao doacao){

        try {
            dr.delete(doacao);
            return "doacao removida";
        } catch (Exception e){
            return "Algo inexperado aconteceu";
        }




    }

  

   

}
