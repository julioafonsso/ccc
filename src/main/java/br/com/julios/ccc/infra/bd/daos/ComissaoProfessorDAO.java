package br.com.julios.ccc.infra.bd.daos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.infra.bd.model.ComissaoProfessorDO;
import br.com.julios.ccc.infra.bd.model.FuncionarioDO;
import br.com.julios.ccc.infra.bd.model.MesReferenciaDO;
import br.com.julios.ccc.infra.dto.funcionario.pagamentos.ConsultaComissaoDTO;
import br.com.julios.ccc.infra.dto.funcionario.pagamentos.ConsultaComissaoConsolidadaDTO;

@Repository
public interface ComissaoProfessorDAO extends JpaRepository<ComissaoProfessorDO, Long>{

	
	
	@Query("select new br.com.julios.ccc.infra.dto.funcionario.pagamentos.ConsultaComissaoDTO("
			+ " c.id, "
			+ " c.funcionario.id, "
			+ " c.funcionario.nome, "
			+ " c.mesReferencia.mes, "
			+ " c.mesReferencia.ano, "
			+ " c.valor , "
			+ " c.mensalidade.matricula.aluno.id, "
			+ " c.mensalidade.matricula.aluno.nome, "
			+ " c.percentual, "
			+ " c.mensalidade.pagamentoMensalidade.valor,"
			+ " c.mensalidade.matricula.turma.codigo,"
			+ " c.mensalidade.matricula.turma.modalidade.nome,"
			+ " c.mensalidade.valorMensalidade ,"
			+ " c.mensalidade.pagamentoMensalidade.data " 
			+ ")"
			+ " from ComissaoProfessorDO c where c.fluxoCaixa is null"
			+ " and c.funcionario.id = ?1 and"
			+ " c.mesReferencia.mes = ?2 and"
			+ " c.mesReferencia.ano = ?3 "
			+ " order by c.mensalidade.pagamentoMensalidade.id desc "
			)
	public List<ConsultaComissaoDTO> getComissoesPendentes(Long idProfessor, Long mes, Long ano);
	
	
	@Query("select new br.com.julios.ccc.infra.dto.funcionario.pagamentos.ConsultaComissaoDTO("
			+ " c.id, "
			+ " c.funcionario.id, "
			+ " c.funcionario.nome, "
			+ " c.mesReferencia.mes, "
			+ " c.mesReferencia.ano, "
			+ " c.valor , "
			+ " c.mensalidade.matricula.aluno.id, "
			+ " c.mensalidade.matricula.aluno.nome, "
			+ " c.percentual, "
			+ " c.mensalidade.pagamentoMensalidade.valor,"
			+ " c.mensalidade.matricula.turma.codigo,"
			+ " c.mensalidade.matricula.turma.modalidade.nome,"
			+ " c.mensalidade.valorMensalidade, "
			+ " c.mensalidade.pagamentoMensalidade.data " 
			+ ")"
			+ " from ComissaoProfessorDO c where c.fluxoCaixa.id = ?1 "
			+ " order by c.mensalidade.pagamentoMensalidade.id desc "
			)
	public List<ConsultaComissaoDTO> getDetalheComissao(Long idPagamento);
	
	@Query("select c from ComissaoProfessorDO c where c.fluxoCaixa is null"
			+ " and c.funcionario = ?1 and c.mesReferencia = ?2 ")
	public List<ComissaoProfessorDO> getComissoesPendentes(FuncionarioDO professor, MesReferenciaDO mes);

	@Query("select distinct new br.com.julios.ccc.infra.dto.funcionario.pagamentos.ConsultaComissaoConsolidadaDTO("
			+ " c.fluxoCaixa.id,"
			+ " c.fluxoCaixa.valor, "
			+ " c.fluxoCaixa.data " 
			+ ")"
			+ " from ComissaoProfessorDO c where c.fluxoCaixa is not null"
			+ " and c.funcionario.id = ?1 and "
			+ " c.fluxoCaixa.data between ?2 and ?3"
			)
	
	public List<ConsultaComissaoConsolidadaDTO> getComissoesRecebidasConsolidada(Long idProfessor, Date diaInicio, Date diaFim);
}
