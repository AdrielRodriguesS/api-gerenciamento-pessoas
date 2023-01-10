package br.com.gerenciamentopessoas.api.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import br.com.gerenciamentopessoas.api.model.Endereco;

@Sql(value = "/data-test.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
//@Sql(scripts = "classpath:data.sql")
@DataJpaTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EnderecoRepositoryTest {
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Test
	public void deveriaRetornarDoisEnderecosDaPessoaComIdUm() {
		
		List<Endereco> enderecos = new ArrayList<>();
		enderecos = enderecoRepository.findAllByIdPessoa(1l);
		Assertions.assertEquals(enderecos.size(), 2);
	}
	
	@Test
	public void deveriaRetornarEnderecoComIdQuatro() {
		Endereco endereco = new Endereco();
		enderecoRepository.findEnderecoPrincipalByIdPessoa(3l);
		Assertions.assertEquals(endereco.getId(), 5);
	}
	

}
