package com.OptimizationBlood.blood.resources;


import com.OptimizationBlood.blood.models.Dador;
import com.OptimizationBlood.blood.models.Doacao;
import com.OptimizationBlood.blood.models.Triagem;
import com.OptimizationBlood.blood.repository.DoacaoRepository;
import com.OptimizationBlood.blood.repository.TriagemRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public Doacao   guardar(@PathVariable(value = "codigo") int codigo , @RequestBody Doacao doacao){


        List<Doacao> doa = new ArrayList<>();
         doa = dr.findAll();
         LocalDate mesQueVem = LocalDate.now().plusMonths(3);
        LocalDate hoje = LocalDate.now().plusMonths(1);
        Triagem triagem = tr.findByCodigo(codigo);

       if (doa.size() !=0){
           for(Doacao d : doa){
               if (triagem.getData_triagem().isBefore(d.getTriagem().getData_triagem().plusMonths(3))) {
                   System.out.println("Ainda nao esta disponivel pra doar sangue");
               }
               else{
                   doacao.setTriagem(triagem);
                   dr.save(doacao);
               }


           }
       }
       else{
           doacao.setTriagem(triagem);
           dr.save(doacao);
           System.out.println("Doacao efetuada");
       }




        return doacao;
    }

    @GetMapping("/doacoes")
    public List<Doacao> listar(){

        return dr.findAll();



    }

    @GetMapping("doacao/{codigo}")
    @ApiOperation(value="retorna uma certa doacao")

    public Doacao pesquisar(@PathVariable(value = "codigo") int codigo){

        return dr.findByCodigo(codigo);




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

    @PutMapping("/doacao")
    @ApiOperation(value="Edita uma certa doacao")
    public  Doacao editar(@RequestBody Doacao doacao){
        return dr.save(doacao);

    }



}
