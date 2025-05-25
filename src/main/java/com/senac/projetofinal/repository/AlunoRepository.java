package com.senac.projetofinal.repository;

import com.senac.projetofinal.data.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoEntity, Integer> 
{
//    AlunoEntity findByAvaliacao(String avaliacao);     
//
//    List<AlunoEntity> findByAvaliacaoStartingWith(String avaliacao); 
//
//    List<AlunoEntity> findByAvaliacaoEndingWith(String avaliacao); 
//
//    List<AlunoEntity> findByAvaliacaoContaining(String avaliacao); 
//
//    List<AlunoEntity> findByOrderByAvaliacaoAsc(); 
//
//    List<AlunoEntity> findByOrderByAvaliacaoDesc();    
}