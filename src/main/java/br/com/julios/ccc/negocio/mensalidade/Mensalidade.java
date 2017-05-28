package br.com.julios.ccc.negocio.mensalidade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.julios.ccc.infra.dto.menslidade.CadastroMensalidadeDTO;
import br.com.julios.ccc.negocio.fluxos.FluxoCaixa;
import br.com.julios.ccc.negocio.matricula.Matricula;
import br.com.julios.ccc.negocio.mes.MesReferencia;

public class Mensalidade {
//
//	MensalidadeRepositorio repositorio;
//
//	private Long id;
//	private Long idMatricula;
//
//	private Double valor;
//	private Date dataVencimento;
//
//	private MesReferencia mes;
//	private Matricula matricula;
//
//	private FluxoCaixa pagamento;
//
//	public Mensalidade(CadastroMensalidadeDTO cadastro, MensalidadeRepositorio mensalidadeRepositorio)
//			throws ParseException {
//
//		this.setRepositorio(mensalidadeRepositorio);
//		this.setId(cadastro.getId());
//		this.setIdMatricula(cadastro.getIdMatricula());
//		this.setIdMesReferencia(cadastro.getIdMesReferecia());
//		this.setDataVencimento(cadastro.getDataVencimento());
//
//	}
//
//	private void setMatricula(Matricula matricula) {
//		this.matricula = matricula;
//	}
//
//	private void setValor(Double valor) {
//		this.valor = valor;
//	}
//
//	private void setMes(MesReferencia mes) {
//		this.mes = mes;
//	}
//
//	private void setPagamento(FluxoCaixa pagamento) {
//		this.pagamento = pagamento;
//	}
//
//	private void setDataVencimento(Date dataVencimento) {
//		this.dataVencimento = dataVencimento;
//
//	}
//
//	public void criarMensalidade() throws ParseException {
//
//		if (this.getRepositorio().getQtdMensalidadeMes(this.getIdMatricula(), this.getMes().getId()).longValue() > 0)
//			this.getMes().nextMes();
//
//		this.calcularVencimentoProximoMes();
//
//		this.calculaValorMensalidade();
//
//		if (this.getValor().doubleValue() > 0)
//			this.repositorio.cadastrar(this);
//
//	}
//
//	public void criarMensalidade(Double valor) throws Exception {
//		this.setDataVencimento(new Date());
//		this.setMes(this.getRepositorio().getMesAtual());
//		this.setValor(valor);
//		this.getRepositorio().cadastrar(this);
//	}
//
//	private void calculaValorMensalidade() throws ParseException {
//
//		Date primeiroDia = null;
//
//		if (this.getId() != null)
//			primeiroDia = this.getMes().getPrimeiroDia();
//		else
//			primeiroDia = new Date();
//
//		Double percentualAulas = this.getMatricula().getTurma().getPercentualMes(this.getMes(), primeiroDia);
//
//		this.setValor(this.getMatricula().getTurma().getValorMensalidade() * percentualAulas);
//	}
//
//	private void calcularVencimentoProximoMes() throws ParseException {
//
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//
//		Date d1 = sdf.parse(sdf.format(this.getMatricula().getDataMatricula()));
//		this.setDataVencimento(this.dataVencimento = sdf.parse(this.getMatricula().getDiaVencimento().toString() + "/"
//				+ this.getMes().getMes().toString() + "/" + this.getMes().getAno().toString()));
//
//		if (this.getDataVencimento().before(d1)) {
//			this.setDataVencimento(this.dataVencimento = sdf.parse(this.getMatricula().getDiaVencimento().toString()
//					+ "/" + this.getMes().getMesNext().toString() + "/" + this.getMes().getAnoNext().toString()));
//		}
//	}
//
//	private void setRepositorio(MensalidadeRepositorio repositorio) {
//		this.repositorio = repositorio;
//	}
//
//	protected MensalidadeRepositorio getRepositorio() {
//		return repositorio;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public Long getIdMatricula() {
//		return idMatricula;
//	}
//
//	public Double getValor() {
//		return valor;
//	}
//
//	public Date getDataVencimento() {
//		return dataVencimento;
//	}
//
//	protected void setId(Long id) {
//		this.id = id;
//	}
//
//	private void setIdMatricula(Long idMatricula) {
//		this.idMatricula = idMatricula;
//	}
//
//	private void setIdMesReferencia(Long idMesReferencia) {
//
//		if (idMesReferencia == null)
//			this.setMes(this.getRepositorio().getMesAtual());
//		else
//			this.setMes(this.getRepositorio().getMes(idMesReferencia));
//	}
//
//	public Matricula getMatricula() {
//		if (this.matricula == null)
//			this.setMatricula(getRepositorio().getMatricula(this.getIdMatricula()));
//		return matricula;
//	}
//
//	public MesReferencia getMes() {
//		return mes;
//	}
//
//	public FluxoCaixa getPagamento() {
//		return pagamento;
//	}
//
//	public void pagar(FluxoCaixa pagamento) throws Exception {
//		this.setPagamento(pagamento);
//		this.getRepositorio().atualizarPagamento(this);
//	}
	
}
