package br.com.gerenciamentopessoas.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciamentopessoas.api.model.Pessoa;
import br.com.gerenciamentopessoas.api.repository.PessoaRepository;

@Service
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
	
	public Pessoa criarPessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	public Pessoa editarPessoa(Pessoa pessoa) {		
		return pessoaRepository.save(pessoa);
	}
	
	public void apagarPessoa(String id) {
		
		Long idPessoa = Long.parseLong(id);
		pessoaRepository.deleteById(idPessoa);
	}

}
