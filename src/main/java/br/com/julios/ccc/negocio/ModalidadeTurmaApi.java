package br.com.julios.ccc.negocio;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.daos.ModalidadeTurmaDAO;
import br.com.julios.ccc.domains.ModalidadeTurma;

@Service
public class ModalidadeTurmaApi {
	
	@Autowired
	ModalidadeTurmaDAO modalidadeTurmaDAO;

	@Autowired
	TurmaApi turmaApi;
	
	public Iterable<ModalidadeTurma> getmodalidadeTurma() 
	{
				return modalidadeTurmaDAO.findByDataExclusaoIsNull();
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
		modalidadeTurma.setDataExclusao(new Date());
		modalidadeTurmaDAO.save(modalidadeTurma);
				
	}

	public ModalidadeTurma getmodalidadeTurma(Long id) {
		return modalidadeTurmaDAO.findOne(id);
	}

	public void validaExisteTurmaAtiva(ModalidadeTurma modalidade) throws Exception {
		if(!modalidade.getTurmas().isEmpty())
			throw new Exception("Modalidade não pode ser excluida! \n Existe turma com essa modalidade");
	}

}
