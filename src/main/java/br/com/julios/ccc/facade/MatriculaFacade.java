package br.com.julios.ccc.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.domains.Matricula;
import br.com.julios.ccc.negocio.MatriculaApi;

@Service
public class MatriculaFacade {

	@Autowired
	MatriculaApi matriculaApi;
	
	public void matricularAluno(Matricula matricula) {
		matriculaApi.matricularAluno(matricula);
	}

	public void excluirMatricula(long id) {
		matriculaApi.excluirMatricula(id);
		
	}

}
