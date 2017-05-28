package br.com.julios.ccc.infra.bd.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.infra.bd.model.BairroDO;
import br.com.julios.ccc.infra.dto.bairro.ConsultaBairroDTO;

@Repository
public interface BairroDAO extends JpaRepository<BairroDO, Long> {

	@Query("select new br.com.julios.ccc.infra.dto.bairro.ConsultaBairroDTO(b.id, b.nome, b.zona) from BairroDO b")
	public List<ConsultaBairroDTO> getBairros();

	@Query("select b from BairroDO b where upper(b.nome) = upper(?1) ")
	public BairroDO getBairroPorNome(String nome);
	
}
