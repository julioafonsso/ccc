package br.com.julios.ccc.negocio;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.AlunoDAO;
import br.com.julios.ccc.infra.bd.daos.MatriculaDAO;
import br.com.julios.ccc.infra.bd.model.AlunoDO;
import br.com.julios.ccc.infra.bd.model.MatriculaDO;
import br.com.julios.ccc.infra.bd.model.MensalidadeDO;
import br.com.julios.ccc.util.Util;

@Service
public class AlunoApi {

	@Autowired
	AlunoDAO alunoDAO;

	@Autowired
	MesApi mesApi;

//	@Autowired
//	MensalidadesDAO mensalidadeDAO;

	@Autowired
	MatriculaApi matriculaApi;
	
	@Autowired
	MatriculaDAO matriculaDAO;

	public void cadastrarAluno(AlunoDO aluno) throws Exception {
		alunoDAO.save(aluno);
	}

	public Iterable<AlunoDO> getAlunos() {
		return alunoDAO.findAll();
	}

	public AlunoDO getAlunoByCPF(String cpf) {
//		return alunoDAO.findByCpf(cpf);
		return null;
	}

	public void atualizarAluno(AlunoDO aluno) {
		alunoDAO.save(aluno);
	}

	public void apagarAluno(AlunoDO aluno) {
		alunoDAO.delete(aluno);
	}

	public Iterable<AlunoDO> getAlunos(String nome, String cpf, String email) throws Exception {

		AlunoDO al = new AlunoDO();

		al.setNome(Util.parametroVazio(nome));
		al.setCpf(Util.parametroVazio(cpf));
		al.setEmail(Util.parametroVazio(email));

		Example<AlunoDO> ex = Example.of(al, ExampleMatcher.matching().withIgnoreCase(true)
				.withStringMatcher(StringMatcher.CONTAINING).withIgnoreNullValues().withIgnorePaths("id"));

//		return alunoDAO.findAll(ex);
		return null;
	}

	public AlunoDO getAluno(Long idAluno) {
		return alunoDAO.findOne(idAluno);

	}

	public List<MatriculaDO> getMatriculas(Long idAluno) {
//		AlunoDO a = alunoDAO.findOne(idAluno);
//		
//		return matriculaDAO.getMatriculas(a, TipoTurmaDO.TURMA);
		return null;
	}

	public List<MensalidadeDO> getMensalidadesParaPagar(AlunoDO aluno) {

//		return mensalidadeDAO.getMensalidadesParaPagar(aluno);
		return null;
	}

	public void validaCPF(AlunoDO aluno) throws Exception {
//		CPFValidador cpfV = new CPFValidador();
//		if(!cpfV.isValid(aluno.getCpf(), null))
//			throw new Exception("CPF Invalido!");
//		AlunoDO a = alunoDAO.findByCpf(aluno.getCpfSemFormat());
//		if (a != null && a.getId() != aluno.getId() ) {
//			throw new Exception("CPF já cadastrado!");
//		}

	}

	public void validaEmail(AlunoDO aluno) throws Exception {
//		AlunoDO a = alunoDAO.findByEmail(aluno.getEmail());
//		if (a != null && a.getId() != aluno.getId()) {
//			throw new Exception("E-mail já cadastrado!");
//		}

	}

	public void validaRG(AlunoDO aluno) throws Exception {
//		AlunoDO a = alunoDAO.findByRg(aluno.getRg());
//		if (a != null && a.getId() != aluno.getId()) {
//			throw new Exception("RG já cadastrado!");
//		}

	}

	public List<MensalidadeDO> criarMensalidadesFuturas(AlunoDO aluno) throws Exception {
		return null;	}

	public List<MensalidadeDO> getPagamentos(AlunoDO aluno, Date diaInicio, Date diaFim) {
//		return mensalidadeDAO.getMensalidadesPaga(aluno, diaInicio, diaFim);
		return null;
	}

	
}
