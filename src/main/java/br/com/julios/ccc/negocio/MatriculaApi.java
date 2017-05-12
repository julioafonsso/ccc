package br.com.julios.ccc.negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.MatriculaDAO;
import br.com.julios.ccc.infra.bd.model.AlunoDO;
import br.com.julios.ccc.infra.bd.model.DescontosDO;
import br.com.julios.ccc.infra.bd.model.FluxoCaixaDO;
import br.com.julios.ccc.infra.bd.model.MatriculaDO;
import br.com.julios.ccc.infra.bd.model.MensalidadeDO;
import br.com.julios.ccc.infra.bd.model.MesReferenciaDO;
import br.com.julios.ccc.infra.bd.model.TurmaDO;

@Service
public class MatriculaApi {

	@Autowired
	MatriculaDAO matriculaDAO;

	@Autowired
	MesApi mesApi;

//	@Autowired
//	MensalidadesDAO mensalidadeDAO;

	@Autowired
	TurmaApi turmaApi;
	
	public MatriculaDO getMatricula(Long id) {
		return matriculaDAO.findOne(id);
	}

	public MatriculaDO matricularAluno(MatriculaDO matricula) {
//		if (matricula.getDesconto() != null && matricula.getDesconto().getId() == 0)
//			matricula.setDesconto(null);
//		matricula.setDataMatricula(new Date());
//		matricula.setDataExclusao(matricula.getTurma().getDataTermino());
//		return matriculaDAO.save(matricula);
		return null;
	}

	public void excluirMatricula(MatriculaDO matricula) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		matricula.setDataExclusao(sdf.parse(sdf.format(new Date())));
		matriculaDAO.save(matricula);
	}

	public void validaExisteMatricula(MatriculaDO matricula) throws Exception {
//		MatriculaDO m = matriculaDAO.getMatricula(matricula.getAluno(), matricula.getTurma());
//		if (m != null)
//			throw new Exception("Aluno já matriculado nessa turma!");
	}

	public boolean existeMensalidade(MatriculaDO matricula, MesReferenciaDO mes) {
//		MensalidadeDO mensalidade = mensalidadeDAO.findByMesReferenciaAndMatricula(mes, matricula);
//		return mensalidade != null;
		return true;
	}

	public void pagarMensalidade(MensalidadeDO mensalidade, FluxoCaixaDO fluxo) {
//		mensalidade.setFluxoCaixa(fluxo);
//
//		mensalidadeDAO.save(mensalidade);

	}

	public List<MensalidadeDO> getMensalidadesParaPagar(MatriculaDO matricula) {
//		return mensalidadeDAO.getMensalidadesParaPagar(matricula);
		return null;
	}

	public MensalidadeDO criarMensalidade(MatriculaDO matricula) throws ParseException {
//		List<MensalidadeDO> mensalidades = mensalidadeDAO.getMensalidades(matricula);
//		MesReferenciaDO mes = null;
//		if (!mensalidades.isEmpty())
//			mes = mesApi.getProximoMes(mensalidades.get(0).getMesReferencia());
//		else
//			mes = mesApi.getMesAtual();
//
//		return criarMensalidade(matricula, mes, mesApi.getPrimeiroDia(mes));

		return null;
	}

	public MensalidadeDO criarMensalidade(MatriculaDO matricula, MesReferenciaDO mesAtual, Date dataInicio)
			throws ParseException {

//		TurmaDO turma = matricula.getTurma();
//		double valorMensalidade = turma.getMensalidade();
//		
//		if(turma.getTipo().getId() == TipoTurmaDO.TURMA)
//			valorMensalidade = calculaMensalidade(dataInicio, turma, mesAtual);
//		
//
//		MesReferenciaDO mes = mesApi.getProximoMes();
//		String strVencimento = matricula.getDiaVencimento() + "/" + mes.getMes() + "/" + mes.getAno();
//
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//
//		MensalidadeDO mensalidade = new MensalidadeDO();
//		mensalidade.setValorMensalidade(valorMensalidade);
//		mensalidade.setMatricula(matricula);
//		mensalidade.setMesReferencia(mesAtual);
//		mensalidade.setDataVencimento(sdf.parse(strVencimento));
//		mensalidadeDAO.save(mensalidade);
//		return mensalidade;
		return null;
	}

	private Double calculaMensalidade(Date dataInicio, TurmaDO turma, MesReferenciaDO mesAtual ) throws ParseException{
//		int aulasTotais = 0;
//		int aulasMatriculado = 0;
//
//		Calendar c = Calendar.getInstance();
//
//		c.setTime(mesApi.getPrimeiroDia(mesAtual));
//
//		int idMes = c.get(Calendar.MONTH);
//		int idMesAtual = idMes;
//
//		while (idMes == idMesAtual) {
//			int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
//			if (turma.temAula(dayOfWeek)) {
//				aulasTotais++;
//				if (!c.getTime().before(dataInicio)
//						&& (turma.getDataTermino() == null || !c.getTime().after(turma.getDataTermino())))
//					aulasMatriculado++;
//
//			}
//			c.add(Calendar.DATE, 1);
//
//			idMesAtual = c.get(Calendar.MONTH);
//		}
//
//		Double valorMensalidade = turma.getMensalidade() / aulasTotais * aulasMatriculado;
//		return valorMensalidade;
		return null;
	}
	
	
	public void exlcuirMensalidades(List<MensalidadeDO> mensalidades) {
//		for (MensalidadeDO mensalidade : mensalidades) {
//			mensalidade.setDataExclusao(new Date());
//			mensalidadeDAO.save(mensalidade);
//		}
	}

	public void apagarDesconto(MatriculaDO matricula) {
		matricula.setDesconto(null);
		matriculaDAO.save(matricula);
	}

	public void alterarDesconto(MatriculaDO matricula, DescontosDO desconto) {
		matricula.setDesconto(desconto);
		matriculaDAO.save(matricula);
	}

	public MatriculaDO matricularAluno(TurmaDO turma, AlunoDO aluno) {
		MatriculaDO matricula = new MatriculaDO();
		matricula.setAluno(aluno);
		matricula.setTurma(turma);
		matricula.setDesconto(null);
		return matricularAluno(matricula);

	}

	public List<MensalidadeDO> getAulasParticulares(AlunoDO aluno, Date diaInicio, Date diaFim) {
		
//		return mensalidadeDAO.getPagamentoAulaParticular(aluno,  diaInicio, diaFim);
		return null;
	}

}
