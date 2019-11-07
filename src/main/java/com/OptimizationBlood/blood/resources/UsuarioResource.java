package com.OptimizationBlood.blood.resources;

import com.OptimizationBlood.blood.models.Dador;
import com.OptimizationBlood.blood.models.Sangue;
import com.OptimizationBlood.blood.models.Sms;
import com.OptimizationBlood.blood.models.Usuario;
import com.OptimizationBlood.blood.repository.SangueRepository;
import com.OptimizationBlood.blood.repository.UsuarioRepository;
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
@CrossOrigin("*")

public class UsuarioResource  {

@Autowired
UsuarioRepository us;


    @PostMapping ("log")
    public String entrar( @RequestBody Usuario usuario){

        List<Usuario> Usuario2 = new ArrayList<>();
        Usuario2 = us.findAll();

        for (Usuario usuario1 :Usuario2 ){

            if ((usuario.getPassword().equals(usuario1.getPassword()))  && (usuario.getEmail().equals(usuario1.getEmail()))  ) {


                return Long.toString(usuario1.getId());


            }
            else {
                return "senha incorreta";

            }
        }

        return "";
    }



        @GetMapping("/usuario")
        public List<Usuario> listar(){

            return us.findAll();

        }



        @PostMapping("/usuario")

        public Usuario guardar(@RequestBody Usuario usuario){

            return us.save(usuario);
        }






        @PutMapping("usuario")
        @ApiOperation(value="remove um certo dador")
        public Usuario editar(@RequestBody Usuario usuario){
        return     us.save(usuario);

        }



    }






