package br.com.kgm.ControleDContato.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kgm.ControleDContato.dto.PessoasDTO;
import br.com.kgm.ControleDContato.model.Pessoas;
import br.com.kgm.ControleDContato.repository.PessoasRepository;

	@Service
	public class PessoasService {

	@Autowired //injeção de dependência
	private PessoasRepository pessoasRepository;
	
	//CRUD - Create
	public Pessoas save(Pessoas pessoa) {
		
		if(pessoa.getNome() == null) {
			System.out.println("Nome está nulo");
			return null;
			
		}
		if(pessoa.getId() == null) {
		System.out.println("Nome está nuloS");
		return null;
		}
			
		return pessoasRepository.save(pessoa);
		}
	//CRUD - Read
	public List<Pessoas> findAll(){
		return pessoasRepository.findAll();
		
	}
	public Optional<Pessoas> findById(Long id) {
		return pessoasRepository.findById(id);
	}
	
	//CRUD - Update
	public Pessoas update(Pessoas pessoa) {
		Optional<Pessoas> findPessoa = pessoasRepository.findById(pessoa.getId());	
		if(findPessoa.isPresent()) {
		Pessoas updPessoa = findPessoa.get(); 
				updPessoa.setEndereço(pessoa.getEndereço());
				updPessoa.setNome(pessoa.getNome());
				updPessoa.setCep(pessoa.getCep());
				updPessoa.setCidade(pessoa.getCidade());
				updPessoa.setUf(pessoa.getUf());
				return pessoasRepository.save(updPessoa);
	}
	
		return pessoasRepository.save(pessoa);
			
	
	}
	
	//CRUD - Delete
		public void delete(Long id) {
		pessoasRepository.deleteById(id);
	}
	
	public List<PessoasDTO> findPessoaAndContato(){
		List<Object[]> listResult = pessoasRepository.PessoaAndContato();
		List<PessoasDTO> listPessoaDTO = new ArrayList<PessoasDTO>();
		
		for(Object[] obj:listResult) {
			PessoasDTO pDTO = returnBDPessoasDTO(obj);
			listPessoaDTO.add(pDTO);
		}
		
		return null;
	}
	
	private PessoasDTO returnBDPessoasDTO(Object[] resultado) {
		PessoasDTO pessoasDTO = new PessoasDTO();
		if(resultado != null) {
			pessoasDTO.setId(((Long)resultado[0]).longValue());
			pessoasDTO.setNome((String)resultado[1]);
			pessoasDTO.setEndereco((String)resultado[3]);
			pessoasDTO.setCep((String)resultado[4]);
			pessoasDTO.setCidade((String)resultado[5]);
			pessoasDTO.setUf((String)resultado[6]);
			pessoasDTO.setContato(((Integer)resultado[7]).intValue());
		}
		return pessoasDTO;
	}
}