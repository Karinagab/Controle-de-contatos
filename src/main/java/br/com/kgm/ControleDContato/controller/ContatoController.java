package br.com.kgm.ControleDContato.controller;

import java.util.Optional;

import org.hibernate.mapping.List;
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

import br.com.kgm.ControleDContato.model.Contato;
import br.com.kgm.ControleDContato.service.ContatoService;
import br.com.kgm.ControleDContato.model.Contato;
import br.com.kgm.ControleDContato.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/cadastro")
public class ContatoController<contatoService> {
	@Autowired
	private ContatoService contatoService;
	@Operation(summary = "Adiciona um novo contato a uma pessoa")
	@PostMapping
	public ResponseEntity<Contato> save(@RequestBody Contato contato){
		Contato newContato = contatoService.save(contato);
		if(newContato == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(newContato);
	}
	@Operation(summary = "Retorna o contato de uma pessoa")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Contato>> findById(@PathVariable Long id){
		Optional<Contato> findContato = contatoService.finById(id);
		if(findContato == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(findContato);
	}
	@Operation(summary = "Lista todos os contados de uma pessoa")
	@GetMapping
	public ResponseEntity<List> findAll(){
		List contatos = (List) contatoService.findAll();
		if(contatos == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(contatos);
	}
	@Operation(summary = "Atualiza o contato de uma pessoa")
	@PutMapping
	public ResponseEntity<Contato> update(@RequestBody Contato contato){
		Contato updContato = contatoService.update(contato);
		if(updContato == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(updContato);
	}
	@Operation(summary = "Deleta o contato de uma pessoa")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		contatoService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}