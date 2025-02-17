package br.com.kgm.ControleDContato.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.kgm.ControleDContato.model.Contato;

public interface ContatosInterface {

		Contato save(Contato cadastro);
		Optional<Contato> finById(Long id);
		List<Contato> findAll();
		Contato update(Contato contato);
		void delete(Long id);
}