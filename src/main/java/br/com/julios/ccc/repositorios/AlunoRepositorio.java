package br.com.julios.ccc.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.AlunoDAO;
import br.com.julios.ccc.infra.bd.daos.BairroDAO;
import br.com.julios.ccc.infra.bd.daos.ConheceEscolaDAO;
import br.com.julios.ccc.infra.bd.daos.EstadoCivilDAO;
import br.com.julios.ccc.infra.bd.model.AlunoDO;
import br.com.julios.ccc.infra.bd.model.BairroDO;
import br.com.julios.ccc.infra.bd.model.ConheceEscolaDO;
import br.com.julios.ccc.infra.bd.model.EstadoCivilDO;
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

	public AlunoDO getAluno(CadastroAlunoDTO cadastro) throws Exception {

		AlunoDO aluno = new AlunoDO();
		aluno.setCpf(cadastro.getCpf());
		aluno.setNome(cadastro.getNome());
		aluno.setRg(cadastro.getRg());
		aluno.setEmail(cadastro.getEmail());
		aluno.setEndereco(cadastro.getEndereco());
		aluno.setNumero(cadastro.getNumero());
		aluno.setComplemento(cadastro.getComplemento());
		aluno.setBairro(this.getBairro(cadastro.getIdBairro()));
		aluno.setCidade(cadastro.getCidade());
		aluno.setDataNascimento(cadastro.getDataNascimento());
		aluno.setEstadoCivil(this.getEstadoCivil(cadastro.getIdEstadoCivil()));
		aluno.setProfissao(cadastro.getProfissao());
		aluno.setConheceEscola(this.getConheceEscola(cadastro.getIdConheceEscola()));
		aluno.setSexo(cadastro.getSexo());
		aluno.setTelefone(cadastro.getTelefone());
		aluno.setObservacao(cadastro.getObservacao());
		aluno.setFoto(cadastro.getFoto());

		return aluno;

	}

	public EstadoCivilDO getEstadoCivil(Long idEstadoCivil) {
		return estadoCivilDAO.findOne(idEstadoCivil);
	}

	public AlunoDO getAluno(Long idAluno) throws Exception {
		AlunoDO aluno = alunoDAO.findOne(idAluno);
		return aluno;
	}


	public void cadastrar(AlunoDO aluno) throws Exception {
		alunoDAO.save(aluno);

	}

	public BairroDO getBairro(Long idBairro) {
		return this.bairroDAO.findOne(idBairro);
	}

	public ConheceEscolaDO getConheceEscola(Long idConheceEscola) {
		return conheceEscolaDAO.findOne(idConheceEscola);
	}

	public AlunoDO getAlunoPorRG(String rg) {
		return this.alunoDAO.getPorRG(rg);
	}

}
