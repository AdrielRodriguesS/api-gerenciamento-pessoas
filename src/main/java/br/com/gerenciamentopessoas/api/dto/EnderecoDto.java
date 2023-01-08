package br.com.gerenciamentopessoas.api.dto;

import br.com.gerenciamentopessoas.api.model.Endereco;
import br.com.gerenciamentopessoas.api.model.Pessoa;
import br.com.gerenciamentopessoas.api.service.PessoaService;

public class EnderecoDto {
	
	private Long id;
	private String logradouro;
	private String cep;
	private String numero;
	private String cidade;
	private boolean enderecoPrincipal;
	private String pessoaId;
	
	public Endereco converter(PessoaService pessoaService, String id) {
		Endereco endereco = new Endereco();
		endereco.setId(this.id);
		endereco.setLogradouro(this.logradouro);
		endereco.setCep(this.cep);
		endereco.setNumero(this.numero);
		endereco.setCidade(this.cidade);
		endereco.setEnderecoPrincipal(this.enderecoPrincipal);
		Pessoa pessoa = pessoaService.buscaPessoaPorId(pessoaId);
		endereco.setPessoa(pessoa);
		
		return endereco;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public boolean isEnderecoPrincipal() {
		return enderecoPrincipal;
	}
	public void setEnderecoPrincipal(boolean enderecoPrincipal) {
		this.enderecoPrincipal = enderecoPrincipal;
	}

	public String getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(String pessoaId) {
		this.pessoaId = pessoaId;
	}
	
}
