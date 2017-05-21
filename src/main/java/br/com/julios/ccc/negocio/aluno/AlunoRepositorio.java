package br.com.julios.ccc.negocio.aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.AlunoDAO;
import br.com.julios.ccc.infra.bd.daos.BairroDAO;
import br.com.julios.ccc.infra.bd.daos.ConheceEscolaDAO;
import br.com.julios.ccc.infra.bd.daos.EstadoCivilDAO;
import br.com.julios.ccc.infra.bd.model.AlunoDO;
import br.com.julios.ccc.infra.dto.aluno.CadastroAlunoDTO;

@Service
public class AlunoRepositorio {

	@Autowired
	private AlunoDAO alunoDAO;
	
	@Autowired
	private BairroDAO bairroDAO;
	
	@Autowired
	private EstadoCivilDAO estadoCivilDAO;
	
	@Autowired
	private ConheceEscolaDAO conheceEscolaDAO;

	public Aluno getAluno(CadastroAlunoDTO cadastro){
		return new Aluno(cadastro, this);
	}
	
	public Aluno getAluno(Long idAluno) throws Exception {
		AlunoDO alunoDO = this.alunoDAO.findOne(idAluno);
		CadastroAlunoDTO cadastro = new CadastroAlunoDTO();
		
		cadastro.setCidade(alunoDO.getCidade());
		cadastro.setComplemento(alunoDO.getComplemento());
		cadastro.setCpf(alunoDO.getCpf());
		cadastro.setDataNascimento(alunoDO.getDataNascimento());
		cadastro.setEmail(alunoDO.getEmail());
		cadastro.setEndereco(alunoDO.getEndereco());
		cadastro.setFoto(cadastro.getFoto());
		cadastro.setId(alunoDO.getId());
		cadastro.setIdBairro(alunoDO.getBairro().getId());
		cadastro.setIdConheceEscola(alunoDO.getConheceEscola().getId());
		cadastro.setIdEstadoCivil(alunoDO.getEstadoCivil().getId());
		cadastro.setNome(alunoDO.getNome());
		cadastro.setNumero(alunoDO.getNumero());
		cadastro.setObservacao(alunoDO.getObservacao());
		cadastro.setProfissao(alunoDO.getProfissao());
		cadastro.setRg(alunoDO.getRg());
		cadastro.setSexo(alunoDO.getSexo());
		cadastro.setTelefone(alunoDO.getTelefone());
		
		return getAluno(cadastro);
	}

	protected Long qtdAlunoComCPF(String cpf) {
		return alunoDAO.countByCpf(cpf);
	}

	protected Long qtdAlunoComRG(String rg) {
		return alunoDAO.countByRg(rg);
	}

	protected Long qtdAlunoComEmail(String email) {
		return alunoDAO.countByEmail(email);
	}

	protected void cadastrar(Aluno aluno) throws Exception {
		AlunoDO alunoDO = new AlunoDO();
		
		alunoDO.setId(aluno.getId());
		alunoDO.setNome(aluno.getNome());
		alunoDO.setCpf(aluno.getCpf());
		alunoDO.setRg(aluno.getRg());
		alunoDO.setEmail(aluno.getEmail());
		alunoDO.setNumero(aluno.getNumero());
		alunoDO.setEndereco(aluno.getEndereco());
		alunoDO.setComplemento(aluno.getComplemento());
		alunoDO.setBairro(bairroDAO.findOne(aluno.getIdBairro()));
		alunoDO.setCidade(aluno.getCidade());
		alunoDO.setDataNascimento(aluno.getDataNascimento());
		alunoDO.setEstadoCivil(estadoCivilDAO.findOne(aluno.getIdEstadoCivil()));
		alunoDO.setProfissao(aluno.getProfissao());
		alunoDO.setConheceEscola(conheceEscolaDAO.findOne(aluno.getIdConheceEscola()));
		alunoDO.setSexo(aluno.getSexo());
		alunoDO.setTelefone(aluno.getTelefone());
		alunoDO.setObservacao(aluno.getObservacao());
		alunoDO.setFoto(aluno.getFoto());
		
		alunoDAO.save(alunoDO);
		
	}

	
}
