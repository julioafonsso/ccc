package br.com.julios.ccc.negocio;

import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.model.ComissaoProfessorDO;
import br.com.julios.ccc.infra.bd.model.FuncionarioDO;
import br.com.julios.ccc.infra.bd.model.MensalidadeDO;
import br.com.julios.ccc.infra.bd.model.MesReferenciaDO;

@Service
public class ComissaoRepositorio {

	public ComissaoProfessorDO getComissao(MensalidadeDO mensalidade, MesReferenciaDO mesReferencia, FuncionarioDO funcionario){
		ComissaoProfessorDO comissao = new ComissaoProfessorDO();
		comissao.setMensalidade(mensalidade);
		comissao.setMesReferencia(mesReferencia);
		comissao.setFuncionario(funcionario);
		
		
		return comissao;
	}
	
}
