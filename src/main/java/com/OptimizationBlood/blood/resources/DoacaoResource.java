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


        List<Doacao> doa = new ArrayList<>();
         doa = dr.findAll();


        Triagem triagem = tr.findByCodigo(codigo);
        LocalDate data_coletada = LocalDate.now();
        


       if (doa.size() !=0){
           for(Doacao d : doa){


               if(d.getTriagem().getAgendamento().getDador().getCodigo() == triagem.getAgendamento().getDador().getCodigo() ){

                   if(d.getStatus().equalsIgnoreCase("nao verificada")) {


                       if (doacao.getData_coletada().isBefore(d.getData_coletada().plusMonths(3))) {


                            long dias = ChronoUnit.DAYS.between(data_coletada,d.getData_coletada().plusMonths(3));
                           return "O Dador ainda nao esta disponivel pra doar sangue, faltam " + dias + " dias " ;

                       } else {
                           doacao.setTriagem(triagem);
                           doacao.setValidade(data_coletada.plusDays(45));
                           if (doacao.getValidade().isAfter(LocalDate.now())){

                               doacao.setExpirado("Fora do prazo");
                           }
                           else {
                               doacao.setExpirado("Dentro do Prazo");
                           }

                           d.setStatus("efetuada");
                           dr.save(d);


                           dr.save(doacao);
                           return "Doacao efetuada";
                       }
                   }

               }
               else{
                   doacao.setTriagem(triagem);
                   doacao.setValidade(data_coletada.plusDays(45));
                 if (doacao.getValidade().isAfter(LocalDate.now())){

                       doacao.setExpirado("Fora do prazo");
                   }
                   else {
                       doacao.setExpirado("Dentro do Prazo");
                   }
                   dr.save(doacao);
                   return "Doacao efetuada";
               }

           }
       }
       else{
           doacao.setTriagem(triagem);
           doacao.setValidade(data_coletada.plusDays(45));
           if (doacao.getValidade().isAfter(LocalDate.now())){

               doacao.setExpirado("Fora do prazo");
           }
           else {
               doacao.setExpirado("Dentro do Prazo");
           }

           dr.save(doacao);

           return "Doacao efetuada";
       }




        return "ups";
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
