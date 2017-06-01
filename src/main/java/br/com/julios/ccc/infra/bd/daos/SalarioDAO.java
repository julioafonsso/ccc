package br.com.julios.ccc.infra.bd.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.infra.bd.model.MesReferenciaDO;
import br.com.julios.ccc.infra.bd.model.SalarioDO;
import br.com.julios.ccc.infra.dto.funcionario.pagamentos.ConsultaSalarioDTO;

@Repository
public interface SalarioDAO extends JpaRepository<SalarioDO, Long>{

	@Query("select new br.com.julios.ccc.infra.dto.funcionario.pagamentos.ConsultaSalarioDTO("
			+ " s.id,"
			+ " s.mesReferencia.mes,"
			+ " s.mesReferencia.ano, "
			+ " s.valor,"
			+ " p.data ,"
			+ " p.valor) from SalarioDO s "
			+ "  LEFT OUTER JOIN s.fluxoCaixa AS p"
			+ " where s.funcionario.id = ?1 and s.mesReferencia = ?2")
	public List<ConsultaSalarioDTO> getSalarios(Long idProfessor, MesReferenciaDO mesDO);

}
