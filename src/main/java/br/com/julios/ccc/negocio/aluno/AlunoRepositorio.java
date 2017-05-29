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

	public AlunoDO getAluno(CadastroAlunoDTO cadastro) throws Exception {

		AlunoDO aluno = new AlunoDO();
		aluno.setCpf(cadastro.getCpf());
		aluno.setNome(cadastro.getNome());
		aluno.setRg(cadastro.getRg());
		aluno.setEmail(cadastro.getEmail());
		aluno.setEndereco(cadastro.getEndereco());
		aluno.setNumero(cadastro.getNumero());
		aluno.setComplemento(cadastro.getComplemento());
		aluno.setBairro(bairroDAO.findOne(cadastro.getIdBairro()));
		aluno.setCidade(cadastro.getCidade());
		aluno.setDataNascimento(cadastro.getDataNascimento());
		aluno.setEstadoCivil(estadoCivilDAO.findOne(cadastro.getIdEstadoCivil()));
		aluno.setProfissao(cadastro.getProfissao());
		aluno.setConheceEscola(conheceEscolaDAO.findOne(cadastro.getIdConheceEscola()));
		aluno.setSexo(cadastro.getSexo());
		aluno.setTelefone(cadastro.getTelefone());
		aluno.setObservacao(cadastro.getObservacao());
		aluno.setFoto(cadastro.getFoto());

		return aluno;

	}

	public AlunoDO getAluno(Long idAluno) throws Exception {
		AlunoDO aluno = alunoDAO.findOne(idAluno);
		return aluno;
	}

	public Long qtdAlunoComCPF(String cpf) {
		return alunoDAO.countByCpf(cpf);
	}

	public Long qtdAlunoComRG(String rg) {
		return alunoDAO.countByRg(rg);
	}

	public Long qtdAlunoComEmail(String email) {
		return alunoDAO.countByEmail(email);
	}

	public void cadastrar(AlunoDO aluno) throws Exception {
		alunoDAO.save(aluno);

	}

}
