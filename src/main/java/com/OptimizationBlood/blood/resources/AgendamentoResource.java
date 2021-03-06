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

        String msg = "Ola " + agendamento.getDador().getNome()  + " , Tem um agendamento para o dia " +agendamento.getData_agendada()+ " as "
                + agendamento.getHora() + " , Entre no Sistema para confirmar ou recusar "  ;

        if (agendamentos.size()!=0) {

            for (Agendamento a : agendamentos) {


                if ( (a.getDador().getCodigo() == dador.getCodigo()) && a.getStatus().equalsIgnoreCase("marcada")) {



                    return "O dador ja tem um agendamento marcado!!!";


                } else {


                    if(agendamento.getData_agendada().isBefore(hoje)){


                        return  "Data invalida";
                    }
                    else {
                        a.setStatus("marcada");
                        ar.save(agendamento);
                        emailService.sendMail(agendamento.getDador().getEmail(), " Agendamento para ", msg);
                           a.setStatus("marcada");

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
    
//   @DeleteMapping("sangue/{codigo}")
//     @ApiOperation(value="remove um certo dador")
//     public Sangue deletar(@PathVariable(value = "codigo") int codigo){
//     Agendamento agendamento1 = ar.findByCodigo(codigo);

//         sr.delete(sangue);
//         return sangue;
//     }



    @DeleteMapping("/agendamento/{codigo}")
    @ApiOperation(value="remove uma certo agendamento")
    public String deletar(@PathVariable(value = "codigo") int codigo){
    Agendamento agendamento1 = ar.findByCodigo(codigo);

        try {
            
            ar.delete(agendamento1);
            return "agendamento removido";
        } catch (Exception e){
            return "Algo inexperado aconteceu";
        }
    }

    @PutMapping("/agendamento")
    @ApiOperation(value="Edita um  agendamento")
    public String editar(@RequestBody Agendamento agendamento){

        Agendamento agendamento1 = ar.findByCodigo(agendamento.getCodigo());

        String msg = "Ola " + agendamento.getDador().getNome()  + " , O agendamnento marcado para o dia  " +agendamento.getData_agendada()+ " as "
                + agendamento.getHora() + " , foi cancelado "  ;

        if(agendamento.getData_agendada() == null)

        {
            agendamento1.setStatus("cancelado");
            agendamento1.setDescricao(agendamento.getDescricao());
            ar.save(agendamento1);
            emailService.sendMail(agendamento.getDador().getEmail(), "Cancelamento de agendamento", msg);

            return "Agendamento cancelado";
        }
        else{
            agendamento1.setStatus("adiado");


            ar.save(agendamento1);
            return  "agendamento adiado";


    }


    




}}
