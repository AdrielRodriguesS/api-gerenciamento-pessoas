package br.com.gerenciamentopessoas.api.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.gerenciamentopessoas.api.model.Endereco;
import br.com.gerenciamentopessoas.api.model.Pessoa;
import br.com.gerenciamentopessoas.api.repository.EnderecoRepository;
import br.com.gerenciamentopessoas.api.repository.PessoaRepository;

public class PopularBancoTest {
	
public void popularBanco(PessoaRepository pessoaRepository, EnderecoRepository enderecoRepository) {
		
		List<Endereco> enderecosPessoaUm = new ArrayList<>();
		List<Endereco> enderecosPessoaDois = new ArrayList<>();
		List<Endereco> enderecosPessoaTres = new ArrayList<>();
		
		Pessoa pessoaUm = new Pessoa(1l, "PessoaUm", LocalDate.now());
		Pessoa pessoaDois = new Pessoa(2l, "PessoaDois", LocalDate.now());
		Pessoa pessoaTres = new Pessoa(3l, "PessoaTres", LocalDate.now());
		
		Endereco EnderecoUmUm = new Endereco(1l, "Rua um_um", "11111-001", "001", "CidadeUm", true, pessoaUm);
		Endereco EnderecoUmDois = new Endereco(2l, "Rua dois_um", "11111-111", "111", "CidadeUm", false, pessoaUm);
		Endereco EnderecoDoisUm = new Endereco(3l, "Rua dois_um", "22222-002", "002", "CidadeDois", true, pessoaDois);
		Endereco EnderecoDoisDois = new Endereco(4l, "Rua dois_dois", "22222-222", "222", "CidadeDois", false, pessoaDois);
		Endereco EnderecoTresUm = new Endereco(5l, "Rua tres_um", "33333-003", "003", "CidadeTres", true, pessoaDois);
		Endereco EnderecoTresDois = new Endereco(6l, "Rua tres_dois", "33333-333", "333", "CidadeTres", false, pessoaDois);
		
		enderecosPessoaUm.add(EnderecoUmUm);
		enderecosPessoaUm.add(EnderecoUmDois);

		enderecosPessoaDois.add(EnderecoDoisUm);
		enderecosPessoaDois.add(EnderecoDoisDois);
		
		enderecosPessoaTres.add(EnderecoTresUm);
		enderecosPessoaTres.add(EnderecoTresDois);
		
		pessoaRepository.save(pessoaUm);
		pessoaRepository.save(pessoaDois);
		pessoaRepository.save(pessoaTres);
		
		enderecoRepository.save(EnderecoUmUm);
		enderecoRepository.save(EnderecoUmDois);
		enderecoRepository.save(EnderecoDoisUm);
		enderecoRepository.save(EnderecoDoisDois);
		enderecoRepository.save(EnderecoTresUm);
		enderecoRepository.save(EnderecoTresDois);
		
	}

}
