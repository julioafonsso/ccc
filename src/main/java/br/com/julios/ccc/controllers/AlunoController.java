package br.com.julios.ccc.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

import br.com.julios.ccc.daos.AlunoDAO;
import br.com.julios.ccc.domains.Aluno;
import br.com.julios.ccc.domains.Matricula;
import br.com.julios.ccc.domains.Mensalidades;
import br.com.julios.ccc.negocio.AlunoApi;

@Controller
@ResponseBody
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	AlunoApi alunoApi;

	@Autowired
	private HttpServletRequest http;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Aluno> getAlunos(@RequestParam(value = "nome", required = false) String nome,
			@RequestParam(value = "cpf", required = false) String cpf,
			@RequestParam(value = "email", required = false) String email) {
		
		System.out.println(http.getHeader("token"));
		return alunoApi.getAlunos(nome, cpf, email);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Aluno cadastrarAluno(@RequestBody Aluno aluno) {
		return alunoApi.cadastrarAluno(aluno);
	}
	
	@RequestMapping(value="{id}/foto",  method = RequestMethod.POST)
	public void cadastrarFoto(@PathVariable("id") Long idAluno,  @RequestBody MultipartFile file) throws Exception {
		alunoApi.cadastrarFoto(idAluno, file);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void atualizarAluno(Aluno aluno) {
		alunoApi.atualizarAluno(aluno);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void apagarAluno(Aluno aluno) {
		alunoApi.apagarAluno(aluno);
	}

	@RequestMapping(value ="pagamento", method= RequestMethod.POST)
	public void efetuarPagamento(@RequestBody Mensalidades mensalidade){
		alunoApi.efetuarPagamento(mensalidade);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Aluno getAluno(@PathVariable("id") Long idAluno) {
		return alunoApi.getAluno(idAluno);
	}

	@RequestMapping(value = "{id}/turmas", method = RequestMethod.GET)
	public List<Matricula> getTurmas(@PathVariable("id") Long idAluno) {
		return alunoApi.getTurmas(idAluno);
	}

	@RequestMapping(value = "{id}/debitos", method = RequestMethod.GET)
	public List<Mensalidades> getDebitos(@PathVariable("id") Long idAluno) {
		return alunoApi.getMensalidadesParaPagar(idAluno);
	}

}
