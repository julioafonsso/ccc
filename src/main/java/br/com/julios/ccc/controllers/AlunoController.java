package br.com.julios.ccc.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import br.com.julios.ccc.domains.Aluno;
import br.com.julios.ccc.domains.Matricula;
import br.com.julios.ccc.domains.Mensalidades;
import br.com.julios.ccc.facade.AlunoFacade;
import br.com.julios.ccc.facade.FileFacade;
import br.com.julios.ccc.facade.MensalidadeFacade;

@Controller
@ResponseBody
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	AlunoFacade alunoFacade;

	@Autowired
	FileFacade fileFacade;

	@Autowired
	MensalidadeFacade mensalidadeFacade;

	@Autowired
	private HttpServletRequest http;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Aluno> getAlunos(@RequestParam(value = "nome", required = false) String nome,
			@RequestParam(value = "cpf", required = false) String cpf,
			@RequestParam(value = "email", required = false) String email) throws Exception {

		return alunoFacade.getAlunos(nome, cpf, email);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarAluno(@RequestBody Aluno aluno) throws Exception {
		alunoFacade.cadastrarAluno(aluno);
	}

	

	@RequestMapping(method = RequestMethod.PUT)
	public void atualizarAluno(Aluno aluno) {
		alunoFacade.atualizarAluno(aluno);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void apagarAluno(Aluno aluno) {
		alunoFacade.apagarAluno(aluno);
	}

	@RequestMapping(value = "pagamento", method = RequestMethod.POST)
	public void efetuarPagamento(@RequestBody Mensalidades mensalidade) {
		mensalidadeFacade.efetuarPagamento(mensalidade);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Aluno getAluno(@PathVariable("id") Long idAluno) {
		return alunoFacade.getAluno(idAluno);
	}

	@RequestMapping(value = "{id}/turmas", method = RequestMethod.GET)
	public List<Matricula> getTurmas(@PathVariable("id") Long idAluno) {
		return alunoFacade.getMatriculas(idAluno);
	}

	@RequestMapping(value = "{id}/debitos", method = RequestMethod.GET)
	public List<Mensalidades> getDebitos(@PathVariable("id") Long idAluno) {
		return alunoFacade.getDebitos(idAluno);
	}

}
