package br.com.julios.ccc.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.domains.Aluno;
import br.com.julios.ccc.domains.FluxoCaixa;
import br.com.julios.ccc.domains.Matricula;
import br.com.julios.ccc.domains.Mensalidades;
import br.com.julios.ccc.negocio.AlunoApi;
import br.com.julios.ccc.negocio.FluxoCaixaApi;
import br.com.julios.ccc.negocio.MatriculaApi;
import br.com.julios.ccc.negocio.MesApi;
import br.com.julios.ccc.negocio.ProfessorApi;

@Service
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
	
	
	
	public void matricularAluno(Matricula matricula) throws Exception {
		Aluno aluno = alunoApi.getAluno(matricula.getAluno().getId());
		
		matriculaApi.validaExisteMatricula(matricula);
		
		FluxoCaixa pagamentoMatricula = fluxoApi.lancamentoMatricula(aluno, matricula.getTurma(), matricula.getValor());
		
		matricula.setPagamentroMatricula(pagamentoMatricula);
		
		matriculaApi.matricularAluno(matricula);

//		Mensalidades mensalidadeMesAtual = 
				matriculaApi.criarMensalidadeCalculadoPeriodo(matricula, mesApi.getMesAtual());
		
//		professorApi.cadastarPagamentosFuturos(mensalidadeMesAtual, matricula.getTurma());
		
//		Mensalidades mensalidadeProximoMes = 
				matriculaApi.criarMensalidade(matricula, mesApi.getProximoMes());
		
//		professorApi.cadastarPagamentosFuturos(mensalidadeProximoMes, matricula.getTurma());
	}

	public void excluirMatricula(long id) {
		Matricula matricula = matriculaApi.getMatricula(id);
		List<Mensalidades> mensalidades =  matriculaApi.getMensalidadesParaPagar(matricula);
		matriculaApi.excluirMatricula(matricula);
//		professorApi.excluirPagamentosFuturos(mensalidades);
		matriculaApi.exlcuirMensalidades(mensalidades);
		
	}

}
