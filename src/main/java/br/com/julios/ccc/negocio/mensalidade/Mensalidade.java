package br.com.julios.ccc.negocio.mensalidade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.julios.ccc.infra.dto.menslidade.CadastroMensalidadeDTO;
import br.com.julios.ccc.negocio.desconto.Desconto;
import br.com.julios.ccc.negocio.fluxos.FluxoCaixa;
import br.com.julios.ccc.negocio.matricula.Matricula;
import br.com.julios.ccc.negocio.mes.MesReferencia;
import br.com.julios.ccc.negocio.turma.coletiva.TurmaColetiva;

public class Mensalidade {

	MensalidadeRepositorio repositorio;

	private Long id;
	private Long idMatricula;

	private Double valor;
	private Date dataVencimento;

	private MesReferencia mes;
	private Matricula matricula;
	private TurmaColetiva turma;
	private Desconto desconto;

	private FluxoCaixa pagamento;

	public Mensalidade(CadastroMensalidadeDTO cadastro, MensalidadeRepositorio mensalidadeRepositorio)
			throws ParseException {

		this.setRepositorio(mensalidadeRepositorio);
		this.setId(cadastro.getId());
		this.setIdMatricula(cadastro.getIdMatricula());
		this.setIdMesReferencia(cadastro.getIdMesReferecia());
		this.setDataVencimento();

	}

	public void criarMensalidade() throws ParseException {

		if (this.getRepositorio().getQtdMensalidadeMes(this.getIdMatricula() , this.getMes().getId()).longValue() > 0)
			this.getMes().nextMes();

		this.setDataVencimento();

		this.calculaValorMensalidade();

		if (this.getValor().doubleValue() > 0)
			this.repositorio.cadastrar(this);

	}

	private void calculaValorMensalidade() throws ParseException {

		Date primeiroDia = null;

		if (this.getId() != null)
			primeiroDia = this.getMes().getPrimeiroDia();
		else
			primeiroDia = new Date();

		Double percentualAulas = this.getTurma().getPercentualMes(this.getMes(), primeiroDia);

		this.valor = this.getTurma().getValorMensalidade() * percentualAulas;
		this.valor = this.valor - (this.valor * this.getDesconto().getValor() / 100);
	}

	private void setDataVencimento() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d1 = sdf.parse(sdf.format(this.getMatricula().getDataMatricula()));
		Date d2 = sdf.parse(sdf.format(new Date()));
		
		if(d1.before(d2))
		{
			this.dataVencimento = sdf.parse(this.getMatricula().getDiaVencimento().toString() + "/"
					+ this.getMes().getMes().toString() + "/" + this.getMes().getAno().toString());
		}
		else{
			this.dataVencimento = sdf.parse(this.getMatricula().getDiaVencimento().toString() + "/"
					+ this.getMes().getMesNext().toString() + "/" + this.getMes().getAnoNext().toString());
		}
	}

	private void setRepositorio(MensalidadeRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	protected MensalidadeRepositorio getRepositorio() {
		return repositorio;
	}

	protected Long getId() {
		return id;
	}

	protected Long getIdMatricula() {
		return idMatricula;
	}

	protected Double getValor() {
		return valor;
	}

	protected Date getDataVencimento() {
		return dataVencimento;
	}

	private void setId(Long id) {
		this.id = id;
	}

	private void setIdMatricula(Long idMatricula) {
		this.idMatricula = idMatricula;
	}

	private void setIdMesReferencia(Long idMesReferencia) {

		if (idMesReferencia == null)
			this.mes = this.getRepositorio().getMesAtual();
		else
			this.mes = this.getRepositorio().getMes(idMesReferencia);
	}

	private Matricula getMatricula() {
		if (this.matricula == null)
			this.matricula = this.getRepositorio().getMatricula(this.getIdMatricula());
		return matricula;
	}

	private TurmaColetiva getTurma() throws ParseException {
		if (this.turma == null)
			this.turma = this.getRepositorio().getTurmaColetiva(this.getMatricula().getIdTurma());
		return turma;
	}

	private Desconto getDesconto() {
		if (this.desconto == null)
			this.desconto = this.getRepositorio().getDesconto(this.getMatricula().getIdDesconto());
		return desconto;
	}

	protected MesReferencia getMes() {
		return mes;
	}

	protected FluxoCaixa getPagamento() {
		return pagamento;
	}

	public void pagar(Double valor) throws ParseException {
		this.pagamento = this.getRepositorio().getFluxo(valor);
		pagamento.cadastrar();
		this.getRepositorio().atualizarPagamento(this);
		this.criarMensalidade();
	}
}
