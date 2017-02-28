package br.com.julios.ccc.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.domains.Aluno;
import br.com.julios.ccc.domains.Matricula;
import br.com.julios.ccc.domains.Mensalidades;
import br.com.julios.ccc.negocio.AlunoApi;
import br.com.julios.ccc.negocio.MatriculaApi;
import br.com.julios.ccc.negocio.ProfessorApi;

@Service
public class MatriculaFacade {

	@Autowired
	MatriculaApi matriculaApi;
	
	
	@Autowired
	ProfessorApi professorApi;
	
	@Autowired
	AlunoApi alunoApi;
	
	public void matricularAluno(Matricula matricula) throws Exception {
		Aluno aluno = alunoApi.getAluno(matricula.getAluno().getId());
		
		matriculaApi.validaExisteMatricula(matricula);
		matriculaApi.matricularAluno(matricula);
		List<Mensalidades> mensalidades = alunoApi.criarMensalidadesFuturas(aluno);
		
		professorApi.cadastarPagamentosFuturos(mensalidades, matricula.getTurma());
	}

	public void excluirMatricula(long id) {
		Matricula matricula = matriculaApi.getMatricula(id);
		List<Mensalidades> mensalidades =  alunoApi.getMensalidadesParaPagar(matricula);
		matriculaApi.excluirMatricula(matricula);
		professorApi.excluirPagamentosFuturos(mensalidades);
		alunoApi.exlcuirMensalidades(mensalidades);
		
	}

}
