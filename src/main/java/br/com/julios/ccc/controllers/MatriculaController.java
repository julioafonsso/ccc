package br.com.julios.ccc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.componentes.EmailApi;
import br.com.julios.ccc.infra.bd.model.ComissaoProfessorDO;
import br.com.julios.ccc.infra.bd.model.DescontosDO;
import br.com.julios.ccc.infra.bd.model.FluxoCaixaDO;
import br.com.julios.ccc.infra.bd.model.FuncionarioDO;
import br.com.julios.ccc.infra.bd.model.MatriculaDO;
import br.com.julios.ccc.infra.bd.model.MensalidadeDO;
import br.com.julios.ccc.infra.dto.DescontoDTO;
import br.com.julios.ccc.infra.dto.matricula.CadastroMatriculaDTO;
import br.com.julios.ccc.repositorios.DescontoRepositorio;
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
	
	@Autowired
	DescontoRepositorio descontoRepositorio;
	
	@Autowired
	EmailApi email;
	
	@RequestMapping(value = "{idMatricula}/desconto", method = RequestMethod.PUT)
	public void alterarDesconto(@PathVariable("idMatricula") Long idMatricula, @RequestBody DescontoDTO descontoDTO) throws Exception{
		DescontosDO desconto = this.descontoRepositorio.getDesconto(descontoDTO.getId());
		MatriculaDO matricula = this.matriculaRepositorio.getMatricula(idMatricula);
		matricula.alterarDesconto(desconto);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public void matricular(@RequestBody CadastroMatriculaDTO cadastro) throws Exception{
		MatriculaDO matricula =  matriculaRepositorio.getMatricula(cadastro);

		FluxoCaixaDO pagamento = fluxoRepositorio.getFluxoPagamentoMatricula(matricula, cadastro.getValor());
		
		if(pagamento.getValor().longValue() > 0)
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
			email.enviarEmailReciboMensalidade(mensalidade);
		}
		else{
			email.enviarEmailReciboMatricula(matricula, pagamento);
		}
		
		
	}
	
	

}
