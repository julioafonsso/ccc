package br.com.julios.ccc.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.julios.ccc.domains.ModalidadeTurma;
import br.com.julios.ccc.negocio.ModalidadeTurmaApi;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ModalidadeTurmaFacade {
	
	@Autowired
	ModalidadeTurmaApi modalidadeTurmaApi;
	
	
	
		
	public Iterable<ModalidadeTurma> getmodalidadeTurma() {
		return modalidadeTurmaApi.getmodalidadeTurma();
	}


	public void cadastarModalidade(ModalidadeTurma modalidade) {
		modalidadeTurmaApi.cadastarModalidade(modalidade);
	}


	public void atualizarModalidade(ModalidadeTurma modalidadeTurma) {
		modalidadeTurmaApi.atualizarModalidade(modalidadeTurma);
		
	}


	public void apagarModalidade(Long id) throws Exception {
		ModalidadeTurma modalidade = modalidadeTurmaApi.getmodalidadeTurma(id);
		modalidadeTurmaApi.validaExisteTurmaAtiva(modalidade);
		modalidadeTurmaApi.apagarModalidade(modalidade);
	}


	public ModalidadeTurma getmodalidadeTurma(Long id) {
		return modalidadeTurmaApi.getmodalidadeTurma(id);
	}

	
}
