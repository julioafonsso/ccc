package br.com.julios.ccc.negocio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.daos.AlunoDAO;
import br.com.julios.ccc.daos.MensalidadesDAO;
import br.com.julios.ccc.daos.MesReferenciaDAO;
import br.com.julios.ccc.domains.Aluno;
import br.com.julios.ccc.domains.FluxoCaixa;
import br.com.julios.ccc.domains.Matricula;
import br.com.julios.ccc.domains.Mensalidades;
import br.com.julios.ccc.domains.MesReferencia;
import br.com.julios.ccc.util.Util;

@Service
public class AlunoApi {

	@Autowired
	AlunoDAO alunoDAO;

	@Autowired
	MesReferenciaDAO mesDAO;

	@Autowired
	MensalidadesDAO mensalidadeDAO;

	public void cadastrarAluno(Aluno aluno) throws Exception {
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

	public Iterable<Aluno> getAlunos(String nome, String cpf, String email) throws Exception {

		Aluno al = new Aluno();

		al.setNome(Util.parametroVazio(nome));
		al.setCpf(Util.parametroVazio(cpf));
		al.setEmail(Util.parametroVazio(email));

		Example<Aluno> ex = Example.of(al, ExampleMatcher.matching().withIgnoreCase(true)
				.withStringMatcher(StringMatcher.CONTAINING).withIgnoreNullValues().withIgnorePaths("id"));

		return alunoDAO.findAll(ex);
	}

	public Aluno getAluno(Long idAluno) {
		return alunoDAO.findOne(idAluno);

	}

	public List<Matricula> getMatriculas(Long idAluno) {
		Aluno a = alunoDAO.findOne(idAluno);
		return a.getMatriculas();
	}

	public List<Mensalidades> getMensalidadesParaPagar(Aluno aluno) {

		return mensalidadeDAO.getMensalidadesParaPagar(aluno);
	}

	public List<Mensalidades> criarMensalidadesFuturas(Aluno aluno) {
		List<Mensalidades> retorno = new ArrayList<Mensalidades>();
		SimpleDateFormat sdfMes = new SimpleDateFormat("MM");
		SimpleDateFormat sdfAno = new SimpleDateFormat("yyyy");

		List<Matricula> matriculas = aluno.getMatriculas();

		Date hoje = new Date();

		int mesAtual = new Integer(sdfMes.format(hoje));
		int anoAtual = new Integer(sdfAno.format(hoje));

		MesReferencia mesRefAtual = mesDAO.findByMesAndAno(mesAtual, anoAtual);
		MesReferencia mes;
		for (Matricula matricula : matriculas) {
			for (int i = 0; i < 3; i++) {
				mes = mesDAO.findOne(mesRefAtual.getId() + i);
				if (!existeMensalida(matricula, mes)) {
					Mensalidades mensalidade = new Mensalidades();
					mensalidade.setMatricula(matricula);
					mensalidade.setMesReferencia(mes);
					mensalidadeDAO.save(mensalidade);
					retorno.add(mensalidade);
				}

			}
		}
		return retorno;
	}

	private boolean existeMensalida(Matricula matricula, MesReferencia mes) {
		Mensalidades mensalidade = mensalidadeDAO.findByMesReferenciaAndMatricula(mes, matricula);
		return mensalidade != null;
	}

	public void pagarMensalidade(Mensalidades mensalidade, FluxoCaixa fluxo) {
		mensalidade.setFluxoCaixa(fluxo);

		mensalidadeDAO.save(mensalidade);

	}

	public List<Mensalidades> getMensalidadesParaPagar(Matricula matricula) {
		return mensalidadeDAO.getMensalidadesParaPagar(matricula);
	}

	public void exlcuirMensalidades(List<Mensalidades> mensalidades) {
		for (Mensalidades mensalidade : mensalidades) {
			mensalidade.setDataExclusao(new Date());
			mensalidadeDAO.save(mensalidade);
		}
	}

	public void validaCPF(Aluno aluno) throws Exception {
		Aluno a = alunoDAO.findByCpf(aluno.getCpfSemFormat());
		if(a !=  null)
		{
			throw new Exception("CPF já cadastrado!");
		}
		
	}

	public void validaEmail(Aluno aluno) throws Exception {
		Aluno a = alunoDAO.findByEmail(aluno.getEmail());
		if(a !=  null)
		{
			throw new Exception("E-mail já cadastrado!");
		}
		
	}

	public void validaRG(Aluno aluno)  throws Exception {
		Aluno a = alunoDAO.findByRg(aluno.getRg());
		if(a !=  null)
		{
			throw new Exception("RG já cadastrado!");
		}
		
	}
}
