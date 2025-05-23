package com.senac.projetofinal.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 

public class SiteController 
{   
    @GetMapping("/principal") 
    public String telaPrincipal(Model model) 
    { 
        return "EscolaMusica"; 
    }    
}