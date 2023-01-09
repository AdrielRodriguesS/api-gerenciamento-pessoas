package br.com.gerenciamentopessoas.api.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import br.com.gerenciamentopessoas.api.configuration.validation.MensagemErro;
import br.com.gerenciamentopessoas.api.dto.EnderecoDto;
import br.com.gerenciamentopessoas.api.model.Endereco;
import br.com.gerenciamentopessoas.api.service.EnderecoService;
import br.com.gerenciamentopessoas.api.service.PessoaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	EnderecoService enderecoService;
	
	@Autowired
	PessoaService pessoaService;
	
	@GetMapping("/buscar")
	public ResponseEntity<?> buscarTodosEnderecosPessoa (
			@RequestParam (value="pessoaId", defaultValue = "") String pessoaId){
		List<Endereco> enderecos = enderecoService.buscarTodosEnderecosPorPessoa(pessoaId);
		if(enderecos.isEmpty()) {
			MensagemErro errorMessage = new MensagemErro(
					LocalDate.now(), HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.getReasonPhrase());
			return ResponseEntity.badRequest().body(errorMessage);
		} else {
			return ResponseEntity.ok(enderecos);
		}
	}
	
	@GetMapping("/buscar/principal")
	public ResponseEntity<?> buscarEnderecoPrincipalPessoa (
			@RequestParam (value="pessoaId", defaultValue = "") String pessoaId){
		Endereco endereco = enderecoService.buscarEnderecoPrincipal(pessoaId);
		if(endereco == null) {
			MensagemErro errorMessage = new MensagemErro(
					LocalDate.now(), HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.getReasonPhrase());
			return ResponseEntity.badRequest().body(errorMessage);
		} else {
			return ResponseEntity.ok(endereco);
		}
	}
	
	@PostMapping("/criar")
	public ResponseEntity<Endereco> criarEndereco(@Valid @RequestBody EnderecoDto enderecoDto){
		Endereco endereco = enderecoDto.converter(pessoaService, enderecoDto.getPessoaId().toString());
		enderecoService.criarEndereco(endereco);
		return ResponseEntity.ok(endereco);
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Endereco> atualizarEndereco(@Valid @RequestBody EnderecoDto enderecoDto,
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
