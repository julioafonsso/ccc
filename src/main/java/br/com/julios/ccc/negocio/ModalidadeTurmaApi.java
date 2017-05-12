package br.com.julios.ccc.negocio;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.ModalidadeTurmaDAO;
import br.com.julios.ccc.infra.bd.model.ModalidadeTurmaDO;

@Service
public class ModalidadeTurmaApi {
	
	@Autowired
	ModalidadeTurmaDAO modalidadeTurmaDAO;

	@Autowired
	TurmaApi turmaApi;
	
	public Iterable<ModalidadeTurmaDO> getmodalidadeTurma() 
	{
//				return modalidadeTurmaDAO.findByDataExclusaoIsNull();
		return null;
	}

	public void cadastarModalidade(ModalidadeTurmaDO modalidadeTurma) 
	{
		modalidadeTurmaDAO.save(modalidadeTurma);
		
	}

	public void atualizarModalidade(ModalidadeTurmaDO modalidadeTurma) 
	{
		modalidadeTurmaDAO.save(modalidadeTurma);
		
	}

	public void apagarModalidade(ModalidadeTurmaDO modalidadeTurma) 
	{
		modalidadeTurma.setDataExclusao(new Date());
		modalidadeTurmaDAO.save(modalidadeTurma);
				
	}

	public ModalidadeTurmaDO getmodalidadeTurma(Long id) {
		return modalidadeTurmaDAO.findOne(id);
	}

	public void validaExisteTurmaAtiva(ModalidadeTurmaDO modalidade) throws Exception {
		if(!modalidade.getTurmas().isEmpty())
			throw new Exception("Modalidade não pode ser excluida! \n Existe turma com essa modalidade");
	}

}
