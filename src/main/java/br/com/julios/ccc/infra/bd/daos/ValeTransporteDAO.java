package br.com.julios.ccc.infra.bd.daos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.infra.bd.model.ValeTransporteDO;
import br.com.julios.ccc.infra.dto.funcionario.ConsultaRecebimentosDTO;

@Repository
public interface ValeTransporteDAO extends JpaRepository<ValeTransporteDO, Long>{

	@Query("select new br.com.julios.ccc.infra.dto.funcionario.ConsultaRecebimentosDTO("
			+ " p.mesReferencia.mes, "
			+ " p.mesReferencia.ano, "
			+ " p.fluxoCaixa.data, "
			+ " p.fluxoCaixa.valor, "
			+ " 'VT', "
			+ " p.fluxoCaixa.id "
			+ ") from  ValeTransporteDO p where p.funcionario.id = ?1 and "
			+ " p.fluxoCaixa.data between ?2 and ?3")
	List<ConsultaRecebimentosDTO> getRecebimentos(Long idFunc, Date diaInicio, Date diaFim);

}
