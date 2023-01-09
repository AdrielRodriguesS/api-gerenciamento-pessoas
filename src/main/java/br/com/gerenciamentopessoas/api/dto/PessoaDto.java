package br.com.gerenciamentopessoas.api.dto;

import java.time.LocalDate;

import br.com.gerenciamentopessoas.api.model.Pessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public class PessoaDto {
	
	private Long id;
	@NotNull @NotBlank
	private String nome;
	@NotNull @Past
	private LocalDate dataNascimento;
		
	public Pessoa converter() {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(this.id);
		pessoa.setNome(this.nome);
		pessoa.setDataNascimento(dataNascimento);
		return pessoa;		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	

}
