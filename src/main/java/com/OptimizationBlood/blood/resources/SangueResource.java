package com.OptimizationBlood.blood.resources;


import com.OptimizationBlood.blood.models.Dador;
import com.OptimizationBlood.blood.models.Sangue;
import com.OptimizationBlood.blood.repository.DadorRepository;
import com.OptimizationBlood.blood.repository.SangueRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping( value = "api")
@Api(value = " Sistema de banco de sangue", description = "Este recurso é responsaval por todas as operacoes sobre dadores" )
@CrossOrigin("*")
public class SangueResource {

    @Autowired
    private SangueRepository sr;

    @ApiOperation(value = "Visualizar a lista de dadores", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/sangue")
    public List<Sangue> listar(){

        return sr.findAll();

    }

    @GetMapping("sangue/{codigo}")
    @ApiOperation(value="retorna um certo tipo de sangue")

    public Sangue pesquisar(@PathVariable(value = "codigo") int codigo){

        return sr.findByCodigo(codigo);

    }

    @GetMapping("sang")
    @ApiOperation(value="retorna um certo tipo de sangue")
    public String obterdador(){



        List<Sangue> sangues = new ArrayList<>();
        sangues = sr.findAll();
        for (Sangue s : sangues){


            for (Dador d : s.getDador()){
                return  d.getNome();
            }

        }

            return "null";
    }

    @PostMapping("/sangue")

    @ApiOperation(value="grava sangue")
    public Sangue guardar(@RequestBody Sangue sangue){

        return sr.save(sangue);
    }


    @DeleteMapping("sangue/{codigo}")
    @ApiOperation(value="remove um certo dador")
    public Sangue deletar(@PathVariable(value = "codigo") int codigo){
        Sangue sangue = sr.findByCodigo(codigo);
        sr.delete(sangue);
        return sangue;
    }


    @PutMapping("sangue")
    @ApiOperation(value="remove um certo dador")
    public Sangue editar(@RequestBody Sangue sangue){
        sr.save(sangue);
        return sangue;
    }



}
