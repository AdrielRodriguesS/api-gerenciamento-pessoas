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
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciamentopessoas.api.dto.PessoaDto;
import br.com.gerenciamentopessoas.api.model.Pessoa;
import br.com.gerenciamentopessoas.api.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	PessoaService pessoaService;
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> BuscarTodasPessoas(){
		
		List<Pessoa> pessoas = pessoaService.buscaTodasPessoas();
		return ResponseEntity.ok(pessoas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> BuscarPessoaPorId(@PathVariable String id){
		
		Pessoa pessoa = pessoaService.buscaPessoaPorId(id);
		return ResponseEntity.ok(pessoa);
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> criarPessoa(@RequestBody PessoaDto pessoaDto){
		
		Pessoa pessoa = pessoaDto.converter();
		pessoaService.criarPessoa(pessoa);
		return ResponseEntity.ok(pessoa);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> atualizarPessoa(@RequestBody PessoaDto pessoaDto, @PathVariable String id){
		
		Pessoa pessoa = pessoaService.buscaPessoaPorId(id);		
		pessoa = pessoaDto.converter();
		pessoa.setId(Long.parseLong(id));
		pessoaService.editarPessoa(pessoa);
		
		return ResponseEntity.ok(pessoa);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Pessoa> apagarPessoa(@PathVariable String id){
		Pessoa pessoa = pessoaService.buscaPessoaPorId(id);
		pessoaService.apagarPessoa(pessoa.getId().toString());
		return ResponseEntity.ok(pessoa);
		
	}

}
