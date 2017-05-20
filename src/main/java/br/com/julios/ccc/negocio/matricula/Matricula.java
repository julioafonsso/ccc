package br.com.julios.ccc.negocio.matricula;

import java.text.ParseException;
import java.util.Date;

import br.com.julios.ccc.infra.dto.matricula.CadastroMatriculaDTO;

public class Matricula {

	
	
	private Long id;
	private Long idAluno;
	private Long idTurma;
	private Double valor;
	private Long diaVencimento;
	private Long idDesconto;
	private Date dataMatricula;
	MatriculaRepositorio repositorio;
	
	public Matricula(CadastroMatriculaDTO cadastro, MatriculaRepositorio matriculaRepositorio) {
		this.setDiaVencimento(cadastro.getDiaVencimento());
		this.setIdAluno(cadastro.getIdAluno());
		this.setIdDesconto(cadastro.getIdDesconto());
		this.setIdTurma(cadastro.getIdTurma());
		this.setValor(cadastro.getValor());
		this.setDataMatricula(cadastro.getDataMatricula());
		this.repositorio = matriculaRepositorio;
	}

	public Long getId(){
		return id;
	}
	
	protected void setId(Long id) {
		this.id = id;
	}
	
	public Long getIdAluno() {
		return idAluno;
	}

	public Long getIdTurma() {
		return idTurma;
	}

	public Double getValor() {
		return valor;
	}

	public Long getDiaVencimento() {
		return diaVencimento;
	}

	public Long getIdDesconto() {
		return idDesconto;
	}

	protected void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}

	protected void setIdTurma(Long idTurma) {
		this.idTurma = idTurma;
	}

	protected void setValor(Double valor) {
		this.valor = valor;
	}

	protected void setDiaVencimento(Long diaVencimento) {
		this.diaVencimento = diaVencimento;
	}

	protected void setIdDesconto(Long idDesconto) {
		this.idDesconto = idDesconto;
	}

	protected void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public Date getDataMatricula() {
		return dataMatricula;
	}

	protected MatriculaRepositorio getRepositorio() {
		return repositorio;
	}

	public void cadastrar() throws ParseException{
		this.repositorio.cadastrar(this);
		this.cadastrarPagamentoMatricula();
		this.cadastrarMensalidade();
	}
	
	private void cadastrarMensalidade() throws ParseException {
		
		this.repositorio.getMensalidade(this).criarMensalidade();;
	}

	private void cadastrarPagamentoMatricula()
	{
		this.repositorio.getFluxoPagamentoMatricula(this.getValor()).cadastrar();
	}
	
}
