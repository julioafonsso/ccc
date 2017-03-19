package br.com.julios.ccc.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.domains.ModalidadeTurma;
import br.com.julios.ccc.negocio.ModalidadeTurmaApi;

@Service
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


	public void apagarModalidade(ModalidadeTurma modalidadeTurma) {
		modalidadeTurmaApi.apagarModalidade(modalidadeTurma);
	}


	public ModalidadeTurma getmodalidadeTurma(Long id) {
		return modalidadeTurmaApi.getmodalidadeTurma(id);
	}

	
}
