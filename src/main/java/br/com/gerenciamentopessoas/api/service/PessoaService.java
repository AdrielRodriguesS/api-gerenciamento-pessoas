package br.com.gerenciamentopessoas.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.gerenciamentopessoas.api.model.Pessoa;
import br.com.gerenciamentopessoas.api.repository.PessoaRepository;

public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public List<Pessoa> buscaTodasPessoas() {

		List<Pessoa> pessoas = pessoaRepository.findAll();		
		return pessoas;
	}

	public Pessoa buscaPessoaPorId(String id) {

		Long idPessoa = Long.parseLong(id);
		return pessoaRepository.findById(idPessoa).get();
	}
	
	public void criarPessoa(Pessoa pessoa) {
		
	}
	
	public void editarPessoa(String id) {
		
	}
	
	public void apagarPessoa(String id) {
		
	}

}
