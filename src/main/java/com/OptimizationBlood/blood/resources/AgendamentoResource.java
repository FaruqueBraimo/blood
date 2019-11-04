package com.OptimizationBlood.blood.resources;


import com.OptimizationBlood.blood.config.EmailService;
import com.OptimizationBlood.blood.models.Agendamento;
import com.OptimizationBlood.blood.models.Dador;
import com.OptimizationBlood.blood.models.Triagem;
import com.OptimizationBlood.blood.repository.AgendamentoRepository;
import com.OptimizationBlood.blood.repository.DadorRepository;
import com.OptimizationBlood.blood.repository.TriagemRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class AgendamentoResource {

    @Autowired
    private DadorRepository dr;
    @Autowired
    private EmailService emailService;

    @Autowired
     private   AgendamentoRepository ar;

    @PostMapping("agendamento/{codigo}")
    public String guardar(@PathVariable(value = "codigo") int codigo , @RequestBody Agendamento agendamento){

        Dador dador = dr.findByCodigo(codigo);
        agendamento.setDador(dador);


         LocalDate hoje = LocalDate.now();


        List<Agendamento> agendamentos = new ArrayList<>();

        agendamentos = ar.findAll();

        String msg = "Ola " + agendamento.getDador().getNome()  + " , Marcaste um agendamento para o dia " +agendamento.getData_agendada()+ " as "
                + agendamento.getHora() + " , até la "  ;

        if (agendamentos.size()!=0) {

            for (Agendamento a : agendamentos) {


                if ( (a.getDador().getCodigo() == dador.getCodigo()) && a.getStatus().equalsIgnoreCase("nao marcada")) {



                    return "O dador ja tem um agendamento marcado!!!";


                } else {


                    if(agendamento.getData_agendada().isBefore(hoje)){


                        return  "Data invalida";
                    }
                    else {
                        a.setStatus("marcada");
                        ar.save(agendamento);
                        emailService.sendMail(agendamento.getDador().getEmail(), " Agendamento para doacaao", msg);

                        return  "agendamento marcado";
                    }

                }


            }


        }else {
            if(agendamento.getData_agendada().isBefore(LocalDate.now())){


                return  "Data invalida";
            }
            else {

                ar.save(agendamento);


               emailService.sendMail(agendamento.getDador().getEmail(), "Agendamento para doacao", msg);

                return  "agendamento marcado";
            }
        }






      return  "";
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


    @GetMapping("contagem")
    public String contagem(){

        return ar.contagem();

    }

    @GetMapping("realizados")
    public String agendamentoRealizados(){

        return ar.realizados();

    }

      @GetMapping("porrealizar")
    public List<Agendamento> agendamentos(){

        return ar.agendamento();

    }



    @GetMapping("dadoragendamento/{codigo}")
    @ApiOperation(value="retorna um cert agendamento")

    public Agendamento pesquisarAgendamento(@PathVariable(value = "codigo") int id){

        return ar.agendamentoDador(id);

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
    public String editar(@RequestBody Agendamento agendamento){

        Agendamento agendamento1 = ar.findByCodigo(agendamento.getCodigo());



         if(agendamento.getData_agendada() == null) 
         
         {
        agendamento1.setStatus("cancelado");
        agendamento1.setDescricao(agendamento.getDescricao());
        ar.save(agendamento1);
        return "Agendamento cancelado";  
         }
        else{
        agendamento1.setStatus("adiado");
        agendamento1.setData_agendada(agendamento.getData_agendada());
        agendamento1.setHora(agendamento.getHora());
        
        ar.save(agendamento1);
        return  "agendamento adiado";
            
        }

    }


    




}
