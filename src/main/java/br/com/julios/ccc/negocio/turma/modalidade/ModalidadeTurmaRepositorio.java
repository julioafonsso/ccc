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
	
	public ModalidadeTurma getModalidade(ModalidadeDTO modalidade)
	{
		return new ModalidadeTurma(modalidade, this);
	}

	protected void cadastrar(ModalidadeTurma modalidadeTurma) {
		ModalidadeTurmaDO mod = new ModalidadeTurmaDO();
		mod.setNome(modalidadeTurma.getNome());
		modDAO.save(mod);
	}
	
	
	protected Integer qtdModalidadesPorNome(String nome)
	{
		return modDAO.countModalidadePorNome(nome);
	}
	
	
}
