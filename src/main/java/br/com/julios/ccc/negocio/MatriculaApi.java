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
import br.com.julios.ccc.domains.Descontos;
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

	@Autowired
	TurmaApi turmaApi;

	public Matricula getMatricula(Long id) {
		return matriculaDAO.findOne(id);
	}

	public void matricularAluno(Matricula matricula) {
		if(matricula.getDesconto() != null && matricula.getDesconto().getId() == 0)
			matricula.setDesconto(null);
		matricula.setDataMatricula(new Date());
		matricula.setDataExclusao(matricula.getTurma().getDataTermino());
		matriculaDAO.save(matricula);
	}

	public void excluirMatricula(Matricula matricula) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		matricula.setDataExclusao(sdf.parse(sdf.format(new Date())));
		matriculaDAO.save(matricula);
	}

	public void validaExisteMatricula(Matricula matricula) throws Exception {
		Matricula m = matriculaDAO.getMatricula(matricula.getAluno(), matricula.getTurma());
		if (m != null)
			throw new Exception("Aluno já matriculado nessa turma!");
	}

	public boolean existeMensalidade(Matricula matricula, MesReferencia mes) {
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

	public Mensalidades criarMensalidade(Matricula matricula)throws ParseException{
		List<Mensalidades> mensalidades = mensalidadeDAO.getMensalidades(matricula);
		MesReferencia mes = null;
		if(!mensalidades.isEmpty())
			mes = mesApi.getProximoMes(mensalidades.get(0).getMesReferencia());
		else
			mes = mesApi.getMesAtual();

		return criarMensalidade(matricula,mes ,mesApi.getPrimeiroDia(mes) );
		
	}
	
	public Mensalidades criarMensalidade(Matricula matricula, MesReferencia mesAtual, Date dataInicio)
			throws ParseException {

		Turma turma = matricula.getTurma();

		int aulasTotais = 0;
		int aulasMatriculado = 0;

		Calendar c = Calendar.getInstance();

		c.setTime(mesApi.getPrimeiroDia(mesAtual));

		int idMes = c.get(Calendar.MONTH);
		int idMesAtual = idMes;

		while (idMes == idMesAtual) {
			int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
			if (turma.temAula(dayOfWeek)) {
				aulasTotais++;
				if (!c.getTime().before(dataInicio)
						&& (turma.getDataTermino() == null || !c.getTime().after(turma.getDataTermino())))
					aulasMatriculado++;

			}
			c.add(Calendar.DATE, 1);

			idMesAtual = c.get(Calendar.MONTH);
		}

		Double valorMensalidade = turma.getMensalidade() / aulasTotais * aulasMatriculado;

		MesReferencia mes = mesApi.getProximoMes();
		String strVencimento = matricula.getDiaVencimento() + "/" + mes.getMes() + "/" + mes.getAno();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

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

	public void apagarDesconto(Matricula matricula) {
		matricula.setDesconto(null);
		matriculaDAO.save(matricula);
	}

	public void alterarDesconto(Matricula matricula, Descontos desconto) {
		matricula.setDesconto(desconto);
		matriculaDAO.save(matricula);
	}

	

}
