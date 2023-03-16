package br.edu.ifpb.pratica02.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Value("${nome.usuario}")
    private String nomeUsuario;
    @RequestMapping()
    public String showHome(Model model){
        model.addAttribute("nome",nomeUsuario);
        model.addAttribute("hora",new Date());
        return "/home/home";
    }

    @RequestMapping("/form")
    public String form(Model model){
        return "/forms/formTributo";
    }

    @RequestMapping("/calcVt")
    public String calculeValorTributavel(@RequestParam("salBase") Double salBasem, @RequestParam("aliq") Double aliq, Model model){
        Double valorTributavel =aliq * salBasem;
        model.addAttribute("valorTributavel",valorTributavel);
        return "/forms/formTributo";
    }
}
