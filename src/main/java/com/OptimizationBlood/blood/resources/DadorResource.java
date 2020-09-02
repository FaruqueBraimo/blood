package com.OptimizationBlood.blood.resources;


import com.OptimizationBlood.blood.models.Dador;
import com.OptimizationBlood.blood.models.Sangue;
import com.OptimizationBlood.blood.models.Triagem;
import com.OptimizationBlood.blood.repository.DadorRepository;
import com.OptimizationBlood.blood.repository.Example;
import com.OptimizationBlood.blood.repository.SangueRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping( value = "/api")
@Api(value = " Sistema de banco de sangue", description = "Este recurso é responsaval por todas as operacoes sobre dadores" )
@CrossOrigin(origins = "*")

public class DadorResource {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private DadorRepository dr;
    @Autowired
    private SangueRepository sr;

    @ApiOperation(value = "Visualizar a lista de dadores", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/dadores")
    public List<Dador> listar(){

        return dr.findAll();

    }

    @GetMapping("dadores/{codigo}")
    @ApiOperation(value="retorna um certo dador")

    public Dador listarDadorUnico(@PathVariable(value = "codigo") long codigo){

        return dr.buscar(codigo);

    }

    @PostMapping("dador/{codigo}")
    public String guardar(@PathVariable(value = "codigo") int codigo , @RequestBody Dador  dador){

        Sangue sangue = sr.findByCodigo(codigo);

        long idade = ChronoUnit.YEARS.between(dador.getData_nasc(),LocalDate.now());


        if ( (idade > 18)  && (idade < 65)){

            dador.setSangue(sangue);
            dr.save(dador);

            return  "Dador gravado ";


        }else{
            return "A idade do dador deve estar compreendida ente 18 a 65";
        }


    }

    @DeleteMapping("dadores/{codigo}")
   @ApiOperation(value="remove um certo dador")
   public Dador deletar(@PathVariable(value = "codigo") int codigo){
        Dador dador = dr.findByCodigo(codigo);
        dr.delete(dador);
        return dador;
   }

    @PutMapping("dador")
    @ApiOperation(value="remove um certo dador")
    public Dador editar(@RequestBody  Dador dador){
        dr.save(dador);
        return dador;
    }


    @PostMapping ("/login")

    public String entrar( @RequestBody Dador  dador){

        List<Dador> dador2 = new ArrayList<>();
        dador2 = dr.findAll();

        for (Dador dador1 :dador2 ){

            if ((dador.getSenha().equals(dador1.getSenha()))  && (dador.getEmail().equals(dador1.getEmail()))  ) {


              return Long.toString(dador1.getCodigo());


            }
            else {
                return "senha incorreta";

            }
        }

        return "";
    }





}
