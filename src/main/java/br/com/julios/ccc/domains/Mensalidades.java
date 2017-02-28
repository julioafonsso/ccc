package br.com.julios.ccc.domains;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "mensalidades")
public class Mensalidades {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private MesReferencia mesReferencia;

	@OneToOne
	private FluxoCaixa fluxoCaixa;

	@ManyToOne
	private Matricula matricula;

	@Transient
	private Double valorCalculado;
	
	@Transient
	private Double desconto;
	
	private Date dataExclusao;
	
	public Date getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(Date dataExclusao) {
		this.dataExclusao = dataExclusao;
	}

	public Double getDesconto(){
		if (matricula.getDesconto() != null)
			return matricula.getTurma().getMensalidade() * matricula.getDesconto().getValor()/100;
		return 0.0;
	}
	
	public Double getValorCalculado() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String strVencimento = matricula.getDiaVencimento() + "/" + mesReferencia.getMes() + "/"
				+ mesReferencia.getAno();
		Date hoje = new Date();
		Date vencimento = sdf.parse(strVencimento);

		if (vencimento.before(hoje)) {
			return matricula.getTurma().getMensalidade() * 1.1;
		} else {
			return matricula.getTurma().getMensalidade() - getDesconto();
		}
	}

	public void setValorCalculado(Double valorCalculado) {
		this.valorCalculado = valorCalculado;
	}

	public MesReferencia getMesReferencia() {
		return mesReferencia;
	}

	public void setMesReferencia(MesReferencia mesReferencia) {
		this.mesReferencia = mesReferencia;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public Long getId() {
		return id;
	}

	public FluxoCaixa getFluxoCaixa() {
		return fluxoCaixa;
	}

	public void setFluxoCaixa(FluxoCaixa fluxoCaixa) {
		this.fluxoCaixa = fluxoCaixa;
	}

	
}
