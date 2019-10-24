package com.OptimizationBlood.blood.resources;


import com.OptimizationBlood.blood.models.Agendamento;
import com.OptimizationBlood.blood.models.Dador;
import com.OptimizationBlood.blood.models.Doacao;
import com.OptimizationBlood.blood.models.Triagem;
import com.OptimizationBlood.blood.repository.AgendamentoRepository;
import com.OptimizationBlood.blood.repository.DadorRepository;
import com.OptimizationBlood.blood.repository.TriagemRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api")
@Api(value = " Sistema de banco de sangue", description = "Este recurso é responsaval por todas as operacoes sobre triagens" )
public class TriagemResource {

    @Autowired
  private TriagemRepository tr;

    @Autowired
    private DadorRepository dr;

    @Autowired
    private AgendamentoRepository ar;


    @PostMapping("triagem/{codigo}")
    public Triagem guardar(@PathVariable(value = "codigo") int codigo , @RequestBody Triagem triagem){
        Agendamento agendamento = ar.findByCodigo(codigo);
        triagem.setAgendamento(agendamento);
        tr.save(triagem);
         return triagem;
    }

    @GetMapping("/triagem")
    public List<Triagem> listar(){

        return tr.findAll();

    }

    @GetMapping("/aptos")
    public List<Triagem> aptos(){
        return tr.aptos();

    }




    @GetMapping("triagem/{codigo}")
    @ApiOperation(value="retorna uma certa triagem")

    public Dador pesquisar(@PathVariable(value = "codigo") int codigo){

        return dr.findByCodigo(codigo);

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

    @PutMapping("/triagem")
    @ApiOperation(value="Edita uma certa triagem")
    public  Triagem editar(@RequestBody Triagem triagem){
        return tr.save(triagem);

    }








}
