package br.com.julios.ccc.negocio.turma.modalidade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.ModalidadeTurmaDAO;
import br.com.julios.ccc.infra.bd.daos.TurmaColetivaDAO;
import br.com.julios.ccc.infra.bd.model.ModalidadeTurmaDO;
import br.com.julios.ccc.infra.dto.turma.ModalidadeDTO;

@Service
public class ModalidadeTurmaRepositorio {

	@Autowired
	ModalidadeTurmaDAO modDAO;
	
	@Autowired TurmaColetivaDAO turmaDAO;
	
	public ModalidadeTurmaDO get(ModalidadeDTO cadastro) throws Exception
	{
		ModalidadeTurmaDO modalidade = new ModalidadeTurmaDO();
		modalidade.setNome(cadastro.getNome());
		
		return modalidade;
	}

	public ModalidadeTurmaDO get(Long id) throws Exception
	{
		return this.modDAO.findOne(id);
	}
	
	public void cadastrar(ModalidadeTurmaDO modalidadeTurma) {
		modDAO.save(modalidadeTurma);
	}
	
	
	

	public ModalidadeTurmaDO getModalidadePorNome(String nome) {
		return this.modDAO.getModalidadePorNome(nome);
		
	}

	public Long getQtdTurmasAtivas(ModalidadeTurmaDO modalidadeTurmaDO) {
		return this.turmaDAO.getQtdTurmaAtivas(modalidadeTurmaDO);
	}
	
	
}
