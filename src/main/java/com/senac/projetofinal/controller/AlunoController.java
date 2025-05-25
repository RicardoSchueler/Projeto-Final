package com.senac.projetofinal.controller;

import com.senac.projetofinal.data.AlunoEntity;
import com.senac.projetofinal.service.AlunoService;
import jakarta.validation.Valid; 
//import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String viewHomePage(Model model) 
    {
        model.addAttribute("listarAlunos", alunoService.listarTodosAlunos()); 
        return "ListagemAluno"; 
    } 
    
    @GetMapping("/deletarAluno/{id}") 
    public String deletarAluno(@PathVariable(value = "id") Integer id) 
    { 
        alunoService.deletarAluno(id); 
        return "redirect:/listarAlunosForm"; 
    } 

    @GetMapping("/criarAlunoForm") 
    public String criarAlunoForm(Model model) 
    { 
        AlunoEntity aluno = new AlunoEntity(); 
        model.addAttribute("aluno", aluno); 
        return "CadastroAluno"; 
    } 

    @PostMapping("/salvarAluno") 
    public String salvarAluno(@Valid @ModelAttribute("aluno") AlunoEntity aluno, BindingResult result) 
    { 
        if (result.hasErrors()) 
        { 
            return "CadastroAluno";             
            //JOptionPane.showMessageDialog(null, result.hasErrors());
        } 

        if (aluno.getId()==null) 
        { 
            alunoService.criarAluno(aluno); 
            //return "TrataErros";
        } 
        else 
        { 
            alunoService.atualizarAluno(aluno.getId(), aluno);              
        } 

        return "redirect:/listarAlunosForm"; 
    } 

    @GetMapping("/atualizarAlunoForm/{id}") 
    public String atualizarAlunoForm(@PathVariable(value = "id") Integer id, Model model) 
    {         
        AlunoEntity aluno = alunoService.getAlunoId(id); 
        model.addAttribute("aluno", aluno); 
        return "AtualizarAluno"; 
    } 
}
