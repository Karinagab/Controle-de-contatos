package br.com.kgm.ControleDContato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kgm.ControleDContato.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{

}