package br.com.julios.ccc.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.daos.ModalidadeTurmaDAO;
import br.com.julios.ccc.domains.ModalidadeTurma;

@Service
public class ModalidadeTurmaApi {
	
	@Autowired
	ModalidadeTurmaDAO modalidadeTurmaDAO;

	public Iterable<ModalidadeTurma> getmodalidadeTurma() 
	{
				return modalidadeTurmaDAO.findAll();
	}

	public void cadastarModalidade(ModalidadeTurma modalidadeTurma) 
	{
		modalidadeTurmaDAO.save(modalidadeTurma);
		
	}

	public void atualizarModalidade(ModalidadeTurma modalidadeTurma) 
	{
		modalidadeTurmaDAO.save(modalidadeTurma);
		
	}

	public void apagarModalidade(ModalidadeTurma modalidadeTurma) 
	{
		modalidadeTurmaDAO.delete(modalidadeTurma);
				
	}

	public ModalidadeTurma getmodalidadeTurma(Long id) {
		return modalidadeTurmaDAO.findOne(id);
	}

}
