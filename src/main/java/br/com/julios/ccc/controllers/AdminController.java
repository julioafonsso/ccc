package br.com.julios.ccc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.infra.bd.daos.ComissaoProfessorDAO;
import br.com.julios.ccc.infra.bd.model.ComissaoProfessorDO;
import br.com.julios.ccc.infra.bd.model.TurmaDO;

@Controller
@ResponseBody
@Transactional(propagation = Propagation.REQUIRED)
@RequestMapping("/admin")
public class AdminController {

	
	@Autowired
	ComissaoProfessorDAO comissaoDAO;
	
	@RequestMapping(value = "atualiza-percentuais", method = RequestMethod.GET)
	public void atualiarPercentuais() {
		List<ComissaoProfessorDO>  comissoes = this.comissaoDAO.getComissoesPendentes();
		
		for (ComissaoProfessorDO comissaoProfessorDO : comissoes) {
			if(comissaoProfessorDO.getMensalidade() != null) {
				TurmaDO turma = comissaoProfessorDO.getMensalidade().getTurma();
				Double novoPercentual = turma.getPercentual(comissaoProfessorDO.getFuncionario());
				comissaoProfessorDO.alterarPercentual(novoPercentual);
			}
		}
	}
	
	@RequestMapping(value = "recalcular-comissao", method = RequestMethod.GET)
	public void recalcularComissao() {
		List<ComissaoProfessorDO>  comissoes = this.comissaoDAO.getComissoesPendentes();
		
		for (ComissaoProfessorDO comissaoProfessorDO : comissoes) {
//			if(comissaoProfessorDO.getMensalidade() != null) {
//				TurmaDO turma = comissaoProfessorDO.getMensalidade().getTurma();
//				Double novoPercentual = turma.getPercentual(comissaoProfessorDO.getFuncionario());
//				comissaoProfessorDO.alterarPercentual(novoPercentual);
//			}
			comissaoProfessorDO.cadastrar();
		}
	}
	
}
