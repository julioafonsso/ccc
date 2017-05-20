package br.com.julios.ccc.facade;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.julios.ccc.infra.bd.model.DescontosDO;
import br.com.julios.ccc.infra.bd.model.MatriculaDO;
import br.com.julios.ccc.infra.bd.model.MensalidadeDO;
import br.com.julios.ccc.negocio.AlunoApi;
import br.com.julios.ccc.negocio.DescontosApi;
import br.com.julios.ccc.negocio.EmailApi;
import br.com.julios.ccc.negocio.FluxoCaixaApi;
import br.com.julios.ccc.negocio.MatriculaApi;
import br.com.julios.ccc.negocio.MesApi;
import br.com.julios.ccc.negocio.ProfessorApi;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class MatriculaFacade {

	@Autowired
	MatriculaApi matriculaApi;

	@Autowired
	ProfessorApi professorApi;

	@Autowired
	AlunoApi alunoApi;

	@Autowired
	FluxoCaixaApi fluxoApi;

	@Autowired
	MesApi mesApi;
	
	@Autowired
	EmailApi email;
	
	@Autowired
	DescontosApi descontoApi;

	public void matricularAluno(MatriculaDO matricula) throws Exception {
//		AlunoDO aluno = alunoApi.getAluno(matricula.getAluno().getId());

		matriculaApi.validaExisteMatricula(matricula);

//		FluxoCaixaDO pagamentoMatricula = fluxoApi.lancamentoMatricula(aluno, matricula.getTurma(), matricula.getValor());

//		matricula.setPagamentroMatricula(pagamentoMatricula);
		
		matriculaApi.matricularAluno(matricula);

		matriculaApi.criarMensalidade(matricula, mesApi.getMesAtual(), new Date());

		matriculaApi.criarMensalidade(matricula, mesApi.getProximoMes(), mesApi.getPrimeiroDia(mesApi.getProximoMes()));
		
//		email.enviarEmailReciboMatricula(matricula, pagamentoMatricula);

	}

	public void excluirMatricula(long id) throws ParseException {
		MatriculaDO matricula = matriculaApi.getMatricula(id);
		List<MensalidadeDO> mensalidades = matriculaApi.getMensalidadesParaPagar(matricula);
		matriculaApi.excluirMatricula(matricula);
		matriculaApi.exlcuirMensalidades(mensalidades);

	}

	public void apagarDesconto(long id) {
		MatriculaDO matricula = matriculaApi.getMatricula(id);
		matriculaApi.apagarDesconto(matricula);
	}

	public void alterarDesconto(long id, long idDesconto) {
		MatriculaDO matricula = matriculaApi.getMatricula(id);
		DescontosDO desconto = descontoApi.getdesconto(idDesconto);
		matriculaApi.alterarDesconto(matricula, desconto);
		
	}

}
