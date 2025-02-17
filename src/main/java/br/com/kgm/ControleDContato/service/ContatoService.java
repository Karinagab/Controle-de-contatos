package br.com.kgm.ControleDContato.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kgm.ControleDContato.model.Contato;
import br.com.kgm.ControleDContato.model.Pessoas;
import br.com.kgm.ControleDContato.repository.ContatoRepository;
import br.com.kgm.ControleDContato.repository.PessoasRepository;
import br.com.kgm.ControleDContato.service.interfaces.ContatosInterface;
@Service
public class ContatoService implements ContatosInterface{
	
	@Autowired
	private ContatoRepository contatoRepository;
	@Autowired
	private PessoasRepository pessoasRepository;

	@Override
	public Contato save(Contato contato) {
		
		if(contato.getPessoa().getId() != null) {
			Optional<Pessoas> findPessoa = pessoasRepository.
					findById(contato.getPessoa().getId());			
			if(!findPessoa.isEmpty()) {
				contato.setPessoa(findPessoa.get());
				return contatoRepository.save(contato);
			}else {
				System.out.println("Pessoa não encontrado pelo id: " + 
						contato.getPessoa().getId());
				return null;
			}
			
		}else {
			System.out.println("Pessoa não encontrada!");
			return null;
		}
	}


	@Override
	public Optional<Contato> finById(Long id) {
		return contatoRepository.findById(id);
	}

	@Override
	public List<Contato> findAll() {
		return contatoRepository.findAll();
	}

	@Override
	public Contato update(Contato contato) {
		Optional<Contato> findContato = contatoRepository.findById(contato.getId());
		
		if(findContato.isPresent()) {
			
			
			Contato updContato = findContato.get();
			updContato.setContato(contato.getContato());
			return contatoRepository.save(updContato); 
		}else {
			
			return save(contato);
		}
		
	}	

	@Override
	public void delete(Long id) {
		contatoRepository.deleteById(id);
		
	}

}