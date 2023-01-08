package br.com.gerenciamentopessoas.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciamentopessoas.api.dto.EnderecoDto;
import br.com.gerenciamentopessoas.api.model.Endereco;
import br.com.gerenciamentopessoas.api.service.EnderecoService;
import br.com.gerenciamentopessoas.api.service.PessoaService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	EnderecoService enderecoService;
	
	@Autowired
	PessoaService pessoaService;
	
	@GetMapping("/buscar")
	public ResponseEntity<List<Endereco>> buscarTodosEnderecosPessoa (
			@RequestParam (value="pessoaId", defaultValue = "") String pessoaId){
		List<Endereco> enderecos = enderecoService.buscarTodosEnderecosPorPessoa(pessoaId);
		return ResponseEntity.ok(enderecos);
	}
	
	@GetMapping("/buscar/principal")
	public ResponseEntity<Endereco> buscarEnderecoPrincipalPessoa (
			@RequestParam (value="pessoaId", defaultValue = "") String pessoaId){
		Endereco endereco = enderecoService.buscarEnderecoPrincipal(pessoaId);
		return ResponseEntity.ok(endereco);
	}
	
	@PostMapping("/criar")
	public ResponseEntity<Endereco> criarEndereco(@RequestBody EnderecoDto enderecoDto){
		Endereco endereco = enderecoDto.converter(pessoaService, enderecoDto.getPessoaId().toString());
		enderecoService.criarEndereco(endereco);
		return ResponseEntity.ok(endereco);
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Endereco> atualizarEndereco(@RequestBody EnderecoDto enderecoDto,
			@PathVariable String id){
		
		Endereco endereco = enderecoService.buscarEnderecoPorId(id);
		endereco = enderecoDto.converter(pessoaService, enderecoDto.getPessoaId().toString());
		endereco.setId(Long.parseLong(id));
		enderecoService.editarEndereco(endereco);
		return ResponseEntity.ok(endereco);
	}
	
	@DeleteMapping("/apagar/{id}")
	public ResponseEntity<Endereco> apagarEndereco(@PathVariable String id){
		Endereco endereco = enderecoService.buscarEnderecoPorId(id);
		enderecoService.apagarEndereco(endereco.getId().toString());
		return ResponseEntity.ok(endereco);
	}
	
}
