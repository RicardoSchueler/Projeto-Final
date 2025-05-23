package com.senac.projetofinal.data;

import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Id; 
import jakarta.persistence.Table; 
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank; 
import jakarta.validation.constraints.NotNull; 
import java.util.Date;
import lombok.Data; 

@Data 
@Entity 
@Table(name="aluno") 

public class AlunoEntity 
{ 
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Integer id; 
    
    @NotBlank(message="Nome obrigatório")  
    private String nome; 
    
    @NotBlank(message="CPF obrigatório")  
    private String cpf; 
    
    @NotBlank(message="Nº identidade obrigatório") 
    private String identidade;
    
    @NotBlank(message="UF da identidade obrigatória") 
    @Column(name="uf_identidade")
    private String ufIdentidade;
    
    @NotBlank(message="E-mail obrigatório") 
    private String email;   
    
    @NotNull(message="Data de nascimento obrigatória")
    @Column(name="dt_nascimento")
    private Date dtNascimento; 
    
    @Column(name="dt_cadastro")
    private Date dtCadastro; 
    
    private String telefones;
    
    @NotBlank(message="Endereco obrigatório") 
    private String endereco;        
    
} 