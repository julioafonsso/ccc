package br.com.julios.ccc.negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.daos.MatriculaDAO;
import br.com.julios.ccc.daos.MensalidadesDAO;
import br.com.julios.ccc.domains.FluxoCaixa;
import br.com.julios.ccc.domains.Matricula;
import br.com.julios.ccc.domains.Mensalidades;
import br.com.julios.ccc.domains.MesReferencia;
import br.com.julios.ccc.domains.Turma;

@Service
public class MatriculaApi {

	@Autowired
	MatriculaDAO matriculaDAO;

	@Autowired
	MesApi mesApi;

	@Autowired
	MensalidadesDAO mensalidadeDAO;

	public Matricula getMatricula(Long id) {
		return matriculaDAO.findOne(id);
	}

	public void matricularAluno(Matricula matricula) {
		matricula.setDataMatricula(new Date());
		matriculaDAO.save(matricula);
	}

	public void excluirMatricula(Matricula matricula) {
		matricula.setDataExclusao(new Date());
		matriculaDAO.save(matricula);
	}

	public void validaExisteMatricula(Matricula matricula) throws Exception {
		Matricula m = matriculaDAO.findByAlunoAndTurmaAndDataExclusaoIsNull(matricula.getAluno(), matricula.getTurma());
		if (m != null)
			throw new Exception("Aluno já matriculado nessa turma!");
	}

	public Mensalidades criarMensalidade(Matricula matricula, MesReferencia mes) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String strVencimento = matricula.getDiaVencimento() + "/" + mes.getMes() + "/" + mes.getAno();

		Date vencimento = sdf.parse(strVencimento);

		if (!existeMensalidade(matricula, mes)) {
			Mensalidades mensalidade = new Mensalidades();
			mensalidade.setValorMensalidade(matricula.getTurma().getMensalidade());
			mensalidade.setMatricula(matricula);
			mensalidade.setMesReferencia(mes);
			mensalidade.setDataVencimento(vencimento);
			mensalidadeDAO.save(mensalidade);
			return mensalidade;
		}
		return null;

	}

	private boolean existeMensalidade(Matricula matricula, MesReferencia mes) {
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

	public Mensalidades criarMensalidadeCalculadoPeriodo(Matricula matricula, MesReferencia mesAtual)
			throws ParseException {
		Turma turma = matricula.getTurma();

		int aulasTotais = 0;
		int aulasMatriculado = 0;

		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		String primeiroDia = "01" + "/" + mesAtual.getMes() + "/" + mesAtual.getAno();

		c.setTime(sdf.parse(primeiroDia));

		int idMes = c.get(Calendar.MONTH);
		int idMesAtual = idMes;

		while (idMes == idMesAtual) {
			int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
			if (turma.temAula(dayOfWeek)) {
				aulasTotais++;
				if (c.getTime().after(new Date()))
					aulasMatriculado++;
			}
			c.add(Calendar.DATE, 1);
			idMesAtual = c.get(Calendar.MONTH);
		}

		Double valorMensalidade = turma.getMensalidade() / aulasTotais * aulasMatriculado;

		MesReferencia mes = mesApi.getProximoMes();
		String strVencimento = matricula.getDiaVencimento() + "/" + mes.getMes() + "/" + mes.getAno();

		Mensalidades mensalidade = new Mensalidades();
		mensalidade.setValorMensalidade(valorMensalidade);
		mensalidade.setMatricula(matricula);
		mensalidade.setMesReferencia(mesAtual);
		mensalidade.setDataVencimento(sdf.parse(strVencimento));
		mensalidadeDAO.save(mensalidade);
		return mensalidade;
	}

	public void exlcuirMensalidades(List<Mensalidades> mensalidades) {
		for (Mensalidades mensalidade : mensalidades) {
			mensalidade.setDataExclusao(new Date());
			mensalidadeDAO.save(mensalidade);
		}
	}

}
