package com.senac.projetofinal.service;

import com.senac.projetofinal.data.AlunoEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import eu.xenit.alfresco.client.api.exception.ResourceNotFoundException;
import com.senac.projetofinal.repository.AlunoRepository;
import java.util.Calendar;

@Service

public class AlunoService 
{
    @Autowired   
        
    private AlunoRepository alunoRepository;
    
    public AlunoEntity criarAluno(AlunoEntity aluno) 
    { 
        aluno.setId(null); 
        aluno.setDtCadastro(Calendar.getInstance().getTime());  
        alunoRepository.save(aluno); 
        return aluno; 
    } 

    public AlunoEntity atualizarAluno(Integer alunoId, AlunoEntity alunoRequest) 
    { 
        AlunoEntity aluno = getAlunoId(alunoId); 
        aluno.setNome(alunoRequest.getNome());
        aluno.setCpf(alunoRequest.getCpf());
        aluno.setIdentidade(alunoRequest.getIdentidade()); 
        aluno.setUfIdentidade(alunoRequest.getUfIdentidade()); 
        aluno.setEmail(alunoRequest.getEmail());        
        aluno.setDtNascimento(alunoRequest.getDtNascimento());   
        aluno.setDtCadastro(alunoRequest.getDtCadastro()); 
        aluno.setTelefones(alunoRequest.getTelefones()); 
        aluno.setEndereco(alunoRequest.getEndereco());          
        alunoRepository.save(aluno); 
        return aluno; 
    } 

    public AlunoEntity getAlunoId(Integer alunoId) 
    { 
        return alunoRepository.findById(alunoId).orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado: " + alunoId)); 
    } 
    
    public List<AlunoEntity> listarTodosAlunos() 
    { 
        return alunoRepository.findAll(); 
    } 

    public void deletarAluno(Integer alunoId) 
    { 
        AlunoEntity aluno = getAlunoId(alunoId); 
        alunoRepository.deleteById(aluno.getId()); 
    } 
}
