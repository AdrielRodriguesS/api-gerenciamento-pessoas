package br.com.gerenciamentopessoas.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciamentopessoas.api.model.Endereco;
import br.com.gerenciamentopessoas.api.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<Endereco> buscarTodosEnderecosPorPessoa(String idPessoa){
	
		Long id = Long.parseLong(idPessoa);
		return enderecoRepository.findAllByIdPessoa(id);
	}
	
	public Endereco buscarEnderecoPrincipal(String idPessoa, boolean isPrincipal) {
		Long id = Long.parseLong(idPessoa);
		return enderecoRepository.findEnderecoPrincipalByIdPessoa(id, isPrincipal);
	}
	
	public Endereco criarEndereco(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	public Endereco editarEndereco(String idEndereco){
		
		Long id = Long.parseLong(idEndereco);
		Endereco endereco = enderecoRepository.findById(id).get();
		return enderecoRepository.save(endereco);
	}
	
	public void apagarEndereco(String idEndereco) {
		Long id = Long.parseLong(idEndereco);
		enderecoRepository.deleteById(id);
	}
	
}
