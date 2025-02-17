package br.com.kgm.ControleDContato.controller;

import java.util.List;
import java.util.Optional;


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
import org.springframework.web.bind.annotation.RestController;

import br.com.kgm.ControleDContato.dto.PessoasDTO;
import br.com.kgm.ControleDContato.model.Pessoas;
import br.com.kgm.ControleDContato.service.PessoasService;
import io.swagger.v3.oas.annotations.Operation;

@RestController 
@RequestMapping("/api/pessoa") //http://localhost:8084/api/pessoa/criar
public class PessoasController {

	@Autowired
	PessoasService pessoasService;
	@Operation(summary = "Adiciona um novo registro de pessoa.")
	@GetMapping("criar") //	
	public ResponseEntity<Pessoas> save(){
		Pessoas pessoa = new Pessoas ();
		pessoa.setId(1L);
		pessoa.setNome("karina");
		pessoa.setEndereço("avenida");
		pessoa.setCep("988676");
		pessoa.setCidade("sao paulo");
		pessoa.setUf("sp");
		
		Pessoas pessoaResposta = pessoasService.save(pessoa);
		if(pessoaResposta == null) {
			ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(pessoa);
	}
	@Operation(summary = "Lista todas as pessoas cadastradas.")
	@GetMapping //http://localhost:8084/api/pessoa
	public ResponseEntity<List<Pessoas>> findAllPessoas(){
		List<Pessoas> pessoas = pessoasService.findAll();
		if(pessoas == null) {
		return ResponseEntity.notFound().build();	
		}
		if(pessoas.size() == 0) {
		return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pessoas);			
	}
	@Operation(summary = "Busca pessoa registrada atrávez do Id")	
	@GetMapping("/{id}") //	
		public ResponseEntity<Optional<Pessoas>> findById(@PathVariable Long id){
			Optional<Pessoas> pessoa = pessoasService.findById(id);
			if(pessoa.isEmpty()) {
				return ResponseEntity.notFound().build();
			}
		return ResponseEntity.ok(pessoa);
	}
	@Operation(summary = "Armazena os registros de pessoas.")
	@PostMapping //http://localhost:8084/api/pessoa
	public ResponseEntity<Pessoas> save(@RequestBody Pessoas pessoa){
		Pessoas newPessoa = pessoasService.save(pessoa);
		if(newPessoa == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(newPessoa);
		}
	@Operation(summary = "Atualiza o registro de uma pessoa")
	@PutMapping
	public ResponseEntity<Pessoas> update(Pessoas pessoa){
		Pessoas updPessoa = pessoasService.update(pessoa);
		if(updPessoa == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(updPessoa);
		}
	@Operation(summary = "Deleta o registro de uma pessoa por Id")
	@DeleteMapping("/{id}") //http://localhost:8084/api/pessoa/10
	public ResponseEntity<?> delete(@PathVariable Long id) {
	    pessoasService.delete(id);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@Operation(summary = "Consulta uma lista com os dados da Pessoa e seu contato")
	@GetMapping("/pessoaAndContato") //http://localhost:8084/api/pessoa/pessoaAndContato
	public ResponseEntity<Object> findPessoaAndContato() {
	    List<PessoasDTO> pessoaDTOs = pessoasService.findPessoaAndContato();  
	    if (pessoaDTOs == null || pessoaDTOs.size() == 0) {
	        return ResponseEntity.notFound().build();    
	    }
	    return ResponseEntity.ok(pessoaDTOs);    
	}

}