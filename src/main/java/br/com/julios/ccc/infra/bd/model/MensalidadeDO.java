package br.com.julios.ccc.infra.bd.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.julios.ccc.infra.Contexto;
import br.com.julios.ccc.repositorios.MensalidadeRepositorio;

@Entity
@Table(name = "mensalidade")
public class MensalidadeDO {

	@Transient
	private MensalidadeRepositorio repositorio;

	public MensalidadeRepositorio getRepositorio() {
		if (this.repositorio == null)
			this.repositorio = Contexto.bean(MensalidadeRepositorio.class);
		return repositorio;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_mes_referencia")
	private MesReferenciaDO mesReferencia;

	@OneToOne
	@JoinColumn(name = "id_fluxo_caixa")
	private FluxoCaixaDO pagamentoMensalidade;

	@ManyToOne
	@JoinColumn(name = "id_matricula")
	private MatriculaDO matricula;

	@Column
	private Double valorMensalidade;

	@Column
	private Date dataVencimento;

	@Column
	private Date dataExclusao;

	@ManyToOne
	@JoinColumn(name = "id_desconto")
	private DescontosDO desconto;

	public DescontosDO getDesconto() {
		return desconto;
	}

	public void setDesconto(DescontosDO desconto) {
		this.desconto = desconto;
	}

	public Long getId() {
		return id;
	}

	public MesReferenciaDO getMesReferencia() {
		return mesReferencia;
	}

	public void setMesReferencia(MesReferenciaDO mesReferencia) {
		this.mesReferencia = mesReferencia;
	}

	public FluxoCaixaDO getPagamentoMensalidade() {
		return pagamentoMensalidade;
	}

	public void setPagamentoMensalidade(FluxoCaixaDO pagamentoMensalidade) {
		this.pagamentoMensalidade = pagamentoMensalidade;
	}

	public MatriculaDO getMatricula() {
		return matricula;
	}

	public void setMatricula(MatriculaDO matricula) {
		this.matricula = matricula;
	}

	public Double getValorMensalidade() {
		return valorMensalidade;
	}

	private void setValorMensalidade(Double valorMensalidade) {
		this.valorMensalidade = valorMensalidade;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(Date dataExclusao) {
		this.dataExclusao = dataExclusao;
	}

	public void cadastrar() throws ParseException {

		this.calculaValor();
		this.calcularVencimentoProximoMes();
		this.getRepositorio().cadastrar(this);

	}

	private void calculaValor() throws ParseException {

		Date primeiroDia = null;

		if (this.getId() != null)
			primeiroDia = this.getMesReferencia().getPrimeiroDia();
		else
			primeiroDia = new Date();

		this.setValorMensalidade(this.getMatricula().getValorMensalidade()
				* this.getMatricula().getPercentualDeAulasMes(this.getMesReferencia(), primeiroDia));

	}

	private void calcularVencimentoProximoMes() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		if (this.getMatricula().getDiaVencimento() == null) {
			this.setDataVencimento(new Date());
		} else {
			Date d1 = sdf.parse(sdf.format(this.getMatricula().getDataMatricula()));
			this.setDataVencimento(sdf.parse(this.getMatricula().getDiaVencimento().toString() + "/"
					+ this.getMesReferencia().getMesFormatado()));

			if (this.getDataVencimento().before(d1)) {

				this.setDataVencimento(this.dataVencimento = sdf.parse(this.getMatricula().getDiaVencimento().toString()
						+ "/" + this.getMesReferencia().getProximoMesFormatado()));
			}
		}
	}

	public String getNomeAluno() {
		return this.getMatricula().getNomeAluno();
	}

	public TurmaDO getTurma() {

		return this.getMatricula().getTurma();
	}

	public void cadastrarPagamento(FluxoCaixaDO pagamento) {
		this.setPagamentoMensalidade(pagamento);
		this.getRepositorio().cadastrar(this);

	}

	public Double getPercentualFuncionario(FuncionarioDO professor) {
		return this.getMatricula().getPercentualProfessor(professor);
	}

	public Double getValorPago() {
		return this.getPagamentoMensalidade().getValor();
	}
}
