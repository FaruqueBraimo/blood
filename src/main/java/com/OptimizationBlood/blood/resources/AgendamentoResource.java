package com.OptimizationBlood.blood.resources;


import com.OptimizationBlood.blood.models.Agendamento;
import com.OptimizationBlood.blood.models.Dador;
import com.OptimizationBlood.blood.models.Triagem;
import com.OptimizationBlood.blood.repository.AgendamentoRepository;
import com.OptimizationBlood.blood.repository.DadorRepository;
import com.OptimizationBlood.blood.repository.TriagemRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class AgendamentoResource {

    @Autowired
    private DadorRepository dr;

    @Autowired
     private   AgendamentoRepository ar;

    @PostMapping("agendamento/{codigo}")
    public Agendamento guardar(@PathVariable(value = "codigo") int codigo , @RequestBody Agendamento agendamento){

        Dador dador = dr.findByCodigo(codigo);
      agendamento.setDador(dador);
      ar.save(agendamento);
      return  agendamento;
    }

    @GetMapping("/agendamento")
    public List<Agendamento> listar(){
        return ar.findAll();
    }

    @GetMapping("agendamento/{codigo}")
    @ApiOperation(value="retorna um cert agendamento")

    public Agendamento pesquisar(@PathVariable(value = "codigo") int id){

        return ar.findByCodigo(id);

    }


    @DeleteMapping("/agendamento")
    @ApiOperation(value="remove uma certo agendamento")
    public String deletar(@RequestBody  Agendamento agendamento){

        try {
            ar.delete(agendamento);
            return "agendamento removido";
        } catch (Exception e){
            return "Algo inexperado aconteceu";
        }
    }

    @PutMapping("/agendamento")
    @ApiOperation(value="Edita um  agendamento")
    public Agendamento editar(@RequestBody Agendamento agendamento){
        return ar.save(agendamento);

    }

}
