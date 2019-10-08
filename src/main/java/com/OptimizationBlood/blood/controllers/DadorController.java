package com.OptimizationBlood.blood.controllers;


import com.OptimizationBlood.blood.models.Dador;
import com.OptimizationBlood.blood.repository.DadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DadorController {

@Autowired
private DadorRepository dr;

    @RequestMapping(value = "/RegistoDador"  , method = RequestMethod.GET)
    public String form() {
        return "Dador/dador";
    }

    @RequestMapping(value = "/RegistoDador"  , method = RequestMethod.POST)
    public String form(Dador dador) {

        dr.save(dador);
        return "redirect:/RegistoDador";
    }


 @RequestMapping("/Dadores")
    public ModelAndView listarDador(){

     ModelAndView mv = new ModelAndView("index");
    Iterable<Dador>  dadores = dr.findAll();
    mv.addObject("dadores", dadores);
    return  mv;
    }

    @RequestMapping("/{codigo}")
    public  ModelAndView detalhesDador(@PathVariable("codigo") long codigo){
        ModelAndView mv = new ModelAndView("detalhesDador");
        Dador dador = dr.findByCodigo(codigo);
        mv.addObject("dador",dador);
        return mv;

    }




}
