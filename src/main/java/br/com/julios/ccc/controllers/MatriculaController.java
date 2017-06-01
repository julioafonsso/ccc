package br.com.julios.ccc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.infra.bd.model.ComissaoProfessorDO;
import br.com.julios.ccc.infra.bd.model.FluxoCaixaDO;
import br.com.julios.ccc.infra.bd.model.FuncionarioDO;
import br.com.julios.ccc.infra.bd.model.MatriculaDO;
import br.com.julios.ccc.infra.bd.model.MensalidadeDO;
import br.com.julios.ccc.infra.dto.matricula.CadastroMatriculaDTO;
import br.com.julios.ccc.repositorios.FluxoCaixaRepositorio;
import br.com.julios.ccc.repositorios.MatriculaRepositorio;
import br.com.julios.ccc.repositorios.MensalidadeRepositorio;
import br.com.julios.ccc.repositorios.MesRerefenciaRepositorio;
import br.com.julios.ccc.repositorios.PagamentoFuncionarioRepositorio;

@Controller
@ResponseBody
@Transactional(propagation = Propagation.REQUIRED)
@RequestMapping("/matriculas")
public class MatriculaController {
	
	@Autowired
	MatriculaRepositorio matriculaRepositorio;
	
	@Autowired
	MensalidadeRepositorio mensalidadeRepositorio;
	
	@Autowired
	FluxoCaixaRepositorio fluxoRepositorio;
	
	@Autowired
	FluxoCaixaRepositorio pagamentoRepositorio;
	
	@Autowired
	PagamentoFuncionarioRepositorio comissaoRepositorio;
	
	@Autowired
	MesRerefenciaRepositorio mesRepositorio;
	
	
	@RequestMapping(method = RequestMethod.POST)
	public void matricular(@RequestBody CadastroMatriculaDTO cadastro) throws Exception{
		MatriculaDO matricula =  matriculaRepositorio.getMatricula(cadastro);

		FluxoCaixaDO pagamento = fluxoRepositorio.getFluxoPagamentoMatricula(matricula, cadastro.getValor());
		
		if(pagamento != null)
		{
			matricula.setPagamentroMatricula(pagamento);
			pagamento.cadastrar();	
		}
		
		matricula.cadastrar();
		
		MensalidadeDO mensalidade = mensalidadeRepositorio.getMensalidade(matricula);
		mensalidade.cadastrar();
		if(matricula.turmaEhWorkShop())
		{
			FluxoCaixaDO pagamentoMensalidade = pagamentoRepositorio.getPagamentoWorkShop(mensalidade);

			pagamentoMensalidade.cadastrar();

			mensalidade.cadastrarPagamento(pagamentoMensalidade);

			List<FuncionarioDO> professores = matricula.getProfessores();;

			for (FuncionarioDO func : professores) {
				ComissaoProfessorDO comissao = comissaoRepositorio.getComissao(mensalidade, this.mesRepositorio.getMesAtual(), func);
				comissao.cadastrar();
			}

		}
	}

}
