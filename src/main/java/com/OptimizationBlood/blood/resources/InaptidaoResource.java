package com.OptimizationBlood.blood.resources;

import com.OptimizationBlood.blood.models.Agendamento;
import com.OptimizationBlood.blood.models.Dador;
import com.OptimizationBlood.blood.models.Inaptidao;
import com.OptimizationBlood.blood.models.Triagem;
import com.OptimizationBlood.blood.repository.AgendamentoRepository;
import com.OptimizationBlood.blood.repository.DadorRepository;
import com.OptimizationBlood.blood.repository.InaptidaoRepository;
import com.OptimizationBlood.blood.repository.TriagemRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class InaptidaoResource {




    @Autowired
    private TriagemRepository tr;

    @Autowired
    private InaptidaoRepository dr;

    @Autowired
    private TriagemRepository ar;


    @PostMapping("ina/{codigo}")
    public Triagem guardar(@PathVariable(value = "codigo") int codigo , @RequestBody Inaptidao inaptidao){
        Triagem triagem = ar.findByCodigo(codigo);
        inaptidao.setTriagem(triagem);
        dr.save(inaptidao);
        return triagem;
    }



    @GetMapping("/aptos")
    public List<Inaptidao> aptos(){
        return dr.findAll();

    }






    @DeleteMapping("/triagem")
    @ApiOperation(value="remove uma certa triagem")
    public String deletar(@RequestBody  Triagem triagem){

        try {
            tr.delete(triagem);
            return "Triagem removida";
        } catch (Exception e){
            return "Algo inexperado aconteceu";
        }




    }






}
