package br.com.julios.ccc.negocio;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.daos.MatriculaDAO;
import br.com.julios.ccc.domains.Matricula;

@Service
public class MatriculaApi {

	@Autowired
	MatriculaDAO matriculaDAO;
	
	public Matricula getMatricula(Long id)
	{
		return matriculaDAO.findOne(id);
	}
	
	public void matricularAluno(Matricula matricula) {
		matricula.setDataMatricula(new Date());
		matriculaDAO.save(matricula);
	}

	public void excluirMatricula(long id) {
		Matricula matricula = matriculaDAO.findOne(id);
		matricula.setDataExclusao(new Date());
		matriculaDAO.save(matricula);
	}
	

}
