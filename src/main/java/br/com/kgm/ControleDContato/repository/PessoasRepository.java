package br.com.kgm.ControleDContato.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.kgm.ControleDContato.model.Pessoas;

@Repository
public interface PessoasRepository extends JpaRepository<Pessoas, Long>{

	@Query(value = "select tp.id,tp.nome,tp.endereço,tp.cep,"
			+ "tp.cidade,tp.uf from tb_pessoa tp inner join cadastro te on tp.id = te.pessoa_id",
			nativeQuery = true)
	List<Object[]> PessoaAndContato();
	
}