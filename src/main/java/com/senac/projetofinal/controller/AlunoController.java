package com.senac.projetofinal.controller;

import com.senac.projetofinal.data.AlunoEntity;
import com.senac.projetofinal.service.AlunoService;
import jakarta.validation.Valid; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.validation.BindingResult; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AlunoController 
{
    @Autowired
    
    private AlunoService alunoService;
    
    @GetMapping("/listarAlunosForm")
    public String viewHomePage(@CookieValue(name="pref-estilo", defaultValue="claro")String tema, Model model) 
    {
        model.addAttribute("css", tema); 
        model.addAttribute("listarAlunos", alunoService.listarTodosAlunos()); 
        return "index"; 
    } 
    
    @GetMapping("/deletarAluno/{id}") 
    public String deletarAluno(@PathVariable(value = "id") Integer id) 
    { 
        alunoService.deletarAluno(id); 
        return "redirect:/listarAlunosForm"; 
    } 

    @GetMapping("/criarAlunoForm") 
    public String criarAlunoForm(@CookieValue(name="pref-estilo", defaultValue="claro")String tema, Model model) 
    { 
        model.addAttribute("css", tema);  
        AlunoEntity aluno = new AlunoEntity(); 
        model.addAttribute("aluno", aluno); 
        return "inserir"; 
    } 

    @PostMapping("/salvarAluno") 
    public String salvarAluno(@Valid @ModelAttribute("aluno") AlunoEntity aluno, BindingResult result) 
    { 
        if (result.hasErrors()) 
        { 
            return "inserir"; 
        } 

        if (aluno.getId()==null) 
        { 
            alunoService.criarAluno(aluno); 
        } 
        else 
        { 
            alunoService.atualizarAluno(aluno.getId(), aluno); 
        } 

        return "redirect:/listarAlunosForm"; 
    } 

    @GetMapping("/atualizarAlunoForm/{id}") 
    public String atualizarAlunoForm(@PathVariable(value = "id") Integer id, @CookieValue(name="pref-estilo", defaultValue="claro")String tema, Model model) 
    { 
        model.addAttribute("css", tema); 
        AlunoEntity aluno = alunoService.getAlunoId(id); 
        model.addAttribute("aluno", aluno); 
        return "atualizar"; 
    } 
}
