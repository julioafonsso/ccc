package br.com.julios.ccc.negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.Util;
import br.com.julios.ccc.daos.AlunoDAO;
import br.com.julios.ccc.daos.FluxoCaixaDAO;
import br.com.julios.ccc.daos.MatriculaDAO;
import br.com.julios.ccc.daos.MensalidadesDAO;
import br.com.julios.ccc.daos.MensalidadesPagasDAO;
import br.com.julios.ccc.daos.MesReferenciaDAO;
import br.com.julios.ccc.daos.TipoFluxoCaixaDAO;
import br.com.julios.ccc.domains.Aluno;
import br.com.julios.ccc.domains.FluxoCaixa;
import br.com.julios.ccc.domains.Matricula;
import br.com.julios.ccc.domains.Mensalidades;
import br.com.julios.ccc.domains.MensalidadesPagas;
import br.com.julios.ccc.domains.MesReferencia;
import br.com.julios.ccc.domains.TipoFluxoCaixa;

@Service
public class AlunoApi {

	@Autowired
	AlunoDAO alunoDAO;
	
	@Autowired 
	MensalidadesDAO mensalidadeDAO;

	@Autowired
	MensalidadesPagasDAO mensalidadesPagasDAO;
	
	@Autowired
	TipoFluxoCaixaDAO tipoFluxoDAO;
	
	@Autowired 
	FluxoCaixaDAO fluxoCaixaDAO;
	
	@Autowired
	MesReferenciaDAO mesReferenciaDAO;
	
	@Autowired
	MatriculaDAO matriculaDAO;
	
	public void cadastrarAluno(Aluno aluno)
	{
		alunoDAO.save(aluno);
	}

	public Iterable<Aluno> getAlunos() {
		return alunoDAO.findAll();
	}

	public Aluno getAlunoByCPF(String cpf) {
		return alunoDAO.findByCpf(cpf);
	}

	public void atualizarAluno(Aluno aluno) {
		alunoDAO.save(aluno);
	}

	public void apagarAluno(Aluno aluno) {
		alunoDAO.delete(aluno);
	}

	public Iterable<Aluno> getAlunos(String nome, String cpf, String email) {
		
		Aluno al = new Aluno();
		
		al.setNome(Util.parametroVazio(nome));
		al.setCpf(Util.parametroVazio(cpf));
		al.setEmail(Util.parametroVazio(email));
		
		Example<Aluno> ex = Example.of(al, ExampleMatcher.
				matching().withIgnoreCase(true).withStringMatcher(StringMatcher.CONTAINING).
				withIgnoreNullValues().withIgnorePaths("id"));
		
		
		return alunoDAO.findAll(ex);
	}

	public Aluno getAluno(Long idAluno) {
		return alunoDAO.findOne(idAluno);	
		
	}

	public List<Matricula> getTurmas(Long idAluno) {
		Aluno a = alunoDAO.findOne(idAluno);
		return a.getMatriculas();
	}

	public List<Mensalidades> getMensalidadesParaPagar(Long idAluno) {
		List<String> situacoes = new ArrayList<String>();
		situacoes.add(Mensalidades.PAGO);
		return mensalidadeDAO.findByAlunoAndSituacaoNotIn(idAluno, situacoes);
	}

	public void efetuarPagamento(Mensalidades mensalidade) {
		
		TipoFluxoCaixa tipoFluxoMensalidade = tipoFluxoDAO.findOne(TipoFluxoCaixa.MENSALIDADE);
		
		FluxoCaixa fluxo = new FluxoCaixa();
		fluxo.setDataFluxo(new Date());
		fluxo.setDescricao("Recebimento Mensalidade ");
		fluxo.setTipoFluxo(tipoFluxoMensalidade);
		fluxo.setValor(mensalidade.getValorParaPagar());
		
		fluxoCaixaDAO.save(fluxo);
		MensalidadesPagas mensalidadePaga = new MensalidadesPagas();
		
		Matricula matricula = matriculaDAO.findOne(mensalidade.getMatricula());
		MesReferencia mes = mesReferenciaDAO.findOne(mensalidade.getMes());
		
		mensalidadePaga.setFluxoCaixa(fluxo);
		mensalidadePaga.setMatricula(matricula);
		mensalidadePaga.setMesReferencia(mes);
		
		mensalidadesPagasDAO.save(mensalidadePaga);
		
	}
	
}
