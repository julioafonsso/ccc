package br.com.julios.ccc.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.julios.ccc.infra.bd.model.ModalidadeTurmaDO;
import br.com.julios.ccc.negocio.ModalidadeTurmaApi;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ModalidadeTurmaFacade {
	
	@Autowired
	ModalidadeTurmaApi modalidadeTurmaApi;
	
	
	
		
	public Iterable<ModalidadeTurmaDO> getmodalidadeTurma() {
		return modalidadeTurmaApi.getmodalidadeTurma();
	}


	public void cadastarModalidade(ModalidadeTurmaDO modalidade) {
		modalidadeTurmaApi.cadastarModalidade(modalidade);
	}


	public void atualizarModalidade(ModalidadeTurmaDO modalidadeTurma) {
		modalidadeTurmaApi.atualizarModalidade(modalidadeTurma);
		
	}


	public void apagarModalidade(Long id) throws Exception {
		ModalidadeTurmaDO modalidade = modalidadeTurmaApi.getmodalidadeTurma(id);
		modalidadeTurmaApi.validaExisteTurmaAtiva(modalidade);
		modalidadeTurmaApi.apagarModalidade(modalidade);
	}


	public ModalidadeTurmaDO getmodalidadeTurma(Long id) {
		return modalidadeTurmaApi.getmodalidadeTurma(id);
	}

	
}
