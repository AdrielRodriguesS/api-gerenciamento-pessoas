package br.com.gerenciamentopessoas.api.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.gerenciamentopessoas.api.model.Endereco;
import br.com.gerenciamentopessoas.api.util.PopularBancoTest;

@DataJpaTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EnderecoRepositoryTest {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	private PopularBancoTest popularBanco = new PopularBancoTest();
	
	@BeforeAll
	public void popularBanco() {
		popularBanco.popularBanco(pessoaRepository, enderecoRepository);
	}


	@Test
	public void deveriaRetornarDoisEnderecosDaPessoaComIdUm() {
		List<Endereco> enderecos = new ArrayList<>();
		enderecos = enderecoRepository.findAllByIdPessoa(1l);
		Assertions.assertEquals(enderecos.size(), 2);
	}
	
	@Test
	public void deveriaRetornarEnderecoComIdUm() {		
		Endereco endereco = new Endereco();
		endereco = enderecoRepository.findEnderecoPrincipalByIdPessoa(1l);
		System.out.println(endereco);
		Assertions.assertEquals(endereco.getId(), 1l);
	}
	

}
