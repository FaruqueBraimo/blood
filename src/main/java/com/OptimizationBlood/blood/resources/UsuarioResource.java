package com.OptimizationBlood.blood.resources;

import com.OptimizationBlood.blood.models.Usuario;
import com.OptimizationBlood.blood.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class UsuarioResource  {

@Autowired
UsuarioRepository us;

    @GetMapping("usuarios")
    public List<Usuario> u(){
        return us.findAll();

    }





}
