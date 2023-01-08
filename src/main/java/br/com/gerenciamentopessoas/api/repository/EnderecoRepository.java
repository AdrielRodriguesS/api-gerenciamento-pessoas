package br.com.gerenciamentopessoas.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.gerenciamentopessoas.api.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	
	@Query("SELECT end FROM Endereco end WHERE end.pessoa.id = :id")
	List<Endereco> findAllByIdPessoa(Long id);

	@Query("SELECT end FROM Endereco end WHERE end.pessoa.id = :id "
			+ "AND enderecoPrincipal = true")
	Endereco findEnderecoPrincipalByIdPessoa(Long id);	

}
