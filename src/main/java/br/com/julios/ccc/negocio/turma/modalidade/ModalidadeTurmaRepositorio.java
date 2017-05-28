package br.com.julios.ccc.negocio.turma.modalidade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.ModalidadeTurmaDAO;
import br.com.julios.ccc.infra.bd.model.ModalidadeTurmaDO;
import br.com.julios.ccc.infra.dto.turma.ModalidadeDTO;

@Service
public class ModalidadeTurmaRepositorio {

	@Autowired
	ModalidadeTurmaDAO modDAO;
	
	public ModalidadeTurmaDO getModalidade(ModalidadeDTO cadastro) throws Exception
	{
		ModalidadeTurmaDO modalidade = new ModalidadeTurmaDO();
		modalidade.setNome(cadastro.getNome());
		
		return modalidade;
	}

	public void cadastrar(ModalidadeTurmaDO modalidadeTurma) {
		modDAO.save(modalidadeTurma);
	}
	
	
	

	public ModalidadeTurmaDO getModalidadePorNome(String nome) {
		return this.modDAO.getModalidadePorNome(nome);
		
	}
	
	
}
