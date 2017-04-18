package br.com.julios.ccc.negocio;

import java.text.DecimalFormat;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.componentes.EmailProperties;
import br.com.julios.ccc.daos.MsgEmailDAO;
import br.com.julios.ccc.domains.FluxoCaixa;
import br.com.julios.ccc.domains.Matricula;
import br.com.julios.ccc.domains.MensagemEmail;
import br.com.julios.ccc.domains.Mensalidades;
import br.com.julios.ccc.domains.PagamentoProfessor;
import br.com.julios.ccc.domains.Professor;
import br.com.julios.ccc.domains.Turma;

@Service
public class EmailApi {

	@Autowired
	EmailProperties emailProperties;
	
	@Autowired
	MsgEmailDAO msgEmail;

	public static void main(String[] args) throws Exception {
		SimpleEmail sm = new EmailApi().getConfigEmail();
		sm.addTo("julioafonsso@gmail.com");
		sm.send();
	}

	public void enviarEmailReciboMatricula(Matricula matricula, FluxoCaixa fluxo) throws Exception {

		HtmlEmail email = getConfigHmlEmail();
		email.addTo(matricula.getAluno().getEmail());
		email.setSubject("Recibo Pagamento Matricula - " + matricula.getTurma().getModalidade().getNome() + " "
				+ matricula.getTurma().getNivel().getNome());

		StringBuilder builder = new StringBuilder();
		
		builder.append("<h2 " + getStyleCabecalho()+">Recibo de Matricula</h2>");
		builder.append("<br>");
		builder.append("<br>");
		builder.append("<div "+getStyleDivDDados() +">");
		builder.append("<label " + getStyleLabel()+"> Aluno Matriculado : " + matricula.getAluno().getNome() + "</label><br>");
		builder.append("<label " + getStyleLabel()+">Turma de           : " + matricula.getTurma().getModalidade().getNome() + " " + matricula.getTurma().getNivel().getNome() + "</label><br>");
		builder.append("<label " + getStyleLabel()+">Dias               : " + getDiasTurma(matricula.getTurma()) + "</label><br>");
		builder.append("<label " + getStyleLabel()+">Horario            : " + matricula.getTurma().getHorarioInicial() + " - " + matricula.getTurma().getHorarioFinal() + "</label><br>");
		builder.append("<label " + getStyleLabel()+">Valor Pago         : R$ " + new DecimalFormat("#.##").format(fluxo.getValor()) + "</label><br>");
		builder.append("</div>");
		
		System.out.println(montaEmail(builder.toString()));
		email.setContent(montaEmail(builder.toString()), "text/html; charset=utf-8");
		email.send();

	}

	public void enviarEmailReciboMensalidade(Mensalidades mensalidade) throws Exception {

		HtmlEmail email = getConfigHmlEmail();
		email.addTo(mensalidade.getMatricula().getAluno().getEmail());
		email.setSubject(
				"Recibo Pagamento Mensalidade " + mensalidade.getMatricula().getTurma().getModalidade().getNome() + " "
						+ mensalidade.getMatricula().getTurma().getNivel().getNome() + " - Mes "
						+ mensalidade.getMesReferencia().getMes() + "/" + mensalidade.getMesReferencia().getAno());

		StringBuilder builder = new StringBuilder();

		builder.append("<h2 " + getStyleCabecalho()+">Recibo de Mensalidade</h2>");
		builder.append("<br>");
		builder.append("<br>");
		builder.append("<div "+getStyleDivDDados() +">");
		builder.append("<label " + getStyleLabel()+">Aluno Matriculado : " + mensalidade.getMatricula().getAluno().getNome() + "</label><br>");
		builder.append("<label " + getStyleLabel()+">Turma de          : " + mensalidade.getMatricula().getTurma().getModalidade().getNome() + " " + mensalidade.getMatricula().getTurma().getNivel().getNome() + "</label><br>");
		builder.append("<label " + getStyleLabel()+">Dias              : " + getDiasTurma(mensalidade.getMatricula().getTurma()) + "</label><br>");
		builder.append("<label " + getStyleLabel()+">Horario           : " + mensalidade.getMatricula().getTurma().getHorarioInicial() + " - " + mensalidade.getMatricula().getTurma().getHorarioFinal() + "</label><br>");
		builder.append("<label " + getStyleLabel()+">Mês Referencia    : " + mensalidade.getMesReferencia().getMes() + "/" + mensalidade.getMesReferencia().getAno() + "</label><br>");
		builder.append("<label " + getStyleLabel()+">Valor Pago        : R$ " + new DecimalFormat("#.##").format(mensalidade.getFluxoCaixa().getValor()) + "</label><br>");
		builder.append("</div>");
		
		System.out.println(montaEmail(builder.toString()));
		email.setContent(montaEmail(builder.toString()), "text/html; charset=utf-8");
		email.send();

	}

	private String getStyleTD(int i){
		if(i%2==0)
			return "style='border: 1px solid ;background-color: #f9f9f9'";
		else 
			return "style='border: 1px solid ;background-color: #eee5de'";
	}
	
	private String getStyleTH(){
		return "style='border: 1px solid #ddd;'";
	}
	
	private String getStyleCabecalho()
	{
		return "style='text-align: center; color: #FF6347'";
	}
	
	private String getStyleLabel(){
		return "style='display: inline-block; max-width: 100%; margin-bottom: 5px; font-weight: bold; color:#000000'";
	}
	
	public void enviarEmailPagametoProfessor(List<PagamentoProfessor> pagamentos, FluxoCaixa fluxo, Professor professor) throws Exception{
		HtmlEmail email = getConfigHmlEmail();
		email.addTo(professor.getEmail());
		email.setSubject("Detalhe de Pagamentos ");
		
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("<h2 " + getStyleCabecalho()+">Recibo de Pagamento</h2>");
		builder.append("<br>");
		builder.append("<br>");
		builder.append("<div "+getStyleDivDDados() +">");
		builder.append("<label "+getStyleLabel() + ">Professor      : " + professor.getNome() + "</label><br>");
		builder.append("<label "+getStyleLabel() + ">CPF            : " + professor.getCpf() + "</label><br>");
		builder.append("<label "+getStyleLabel() + ">Valor Recebido : R$ " + new DecimalFormat("#.##").format(fluxo.getValor()  * -1) + "</label><br>");
		
		builder.append("<br><br><br><br>");
		builder.append("</div>");
		builder.append("<h4 " + getStyleCabecalho()+">Detalhes</h4>");
		
		builder.append(" <table "+getStyleTable() + ">");
		builder.append("<thead>");
		builder.append("<th "+getStyleTH() + ">Codigo Turma</th>");
		builder.append("<th "+getStyleTH() + ">Aluno</th>");
		builder.append("<th "+getStyleTH() + ">Valor Pago</th>");
		builder.append("<th "+getStyleTH() + ">Percentual</th>");
		builder.append("<th "+getStyleTH() + ">Valor Recebido</th>");
		builder.append("</thead>");
		builder.append("<tbody>");
		int i =0;
		for (PagamentoProfessor pg : pagamentos) {
			builder.append("<tr>");
			builder.append("<td "+getStyleTD(i) + ">"+ pg.getMensalidade().getMatricula().getTurma().getCodigo() +"</td>");
			builder.append("<td "+getStyleTD(i) + ">"+ pg.getMensalidade().getMatricula().getAluno().getNome() +"</td>");
			builder.append("<td "+getStyleTD(i) + "> R$ "+ new DecimalFormat("#.##").format(pg.getMensalidade().getFluxoCaixa().getValor()) +"</td>");
			builder.append("<td "+getStyleTD(i) + ">"+ pg.getPercentual() +" %</td>");
			
			 
			builder.append("<td "+getStyleTD(i) + "> R$ "+ new DecimalFormat("#.##").format(pg.getFluxoCaixa().getValor() *-1) +"</td>");
			builder.append("</tr>");
			i++;
		}
		
		builder.append("</tbody>");
		builder.append("</table>");

		System.out.println(montaEmail(builder.toString()));

		email.setContent(montaEmail(builder.toString()), "text/html; charset=utf-8");

		email.send();
	}
	
	private String getStyleDivDDados() {
		return "style='text-align: center;'";
	}

	private String getStyleTable() {
		return "style='width: 100%; max-width: 100%; margin-bottom: 20px; border: 1px solid #ddd;'";
	}

	private String getDiasTurma(Turma turma) {
		StringBuilder sb = new StringBuilder();
		String separador = "";
		if (turma.isDomingo()) {
			sb.append(separador).append("Domingo");
			separador = " - ";
		}

		if (turma.isSegunda()) {
			sb.append(separador).append("Segunda");
			separador = " - ";
		}

		if (turma.isTerca()) {
			sb.append(separador).append("Terça");
			separador = " - ";
		}

		if (turma.isQuarta()) {
			sb.append(separador).append("Quarta");
			separador = " - ";
		}

		if (turma.isQuinta()) {
			sb.append(separador).append("Quinta");
			separador = " - ";
		}

		if (turma.isSexta()) {
			sb.append(separador).append("Sexta");
			separador = " - ";
		}

		if (turma.isSabado()) {
			sb.append(separador).append("Sabado");
			separador = " - ";
		}

		return sb.toString();
	}

	private String montaEmail(String conteudo) {

		StringBuilder builder = new StringBuilder();
		
		builder.append("<html>");
		builder.append("<head>");
		builder.append("<title>Recibo Centro Cultura Carioca</title>");
		builder.append("</head>");
		builder.append("<body >");
		builder.append("<div>");
//		builder.append("<div style='background-color: #f4a460 ;'>");
		builder.append("<div style='text-align: center'>");
		builder.append("<a href=\"https://dancaccc.com.br\">");
		builder.append(
				"<img width='60%' height='25%' src='http://controle-ccc.website/imagens/logo.jpg' >");
		builder.append("</a>");
		builder.append("</div>");
		builder.append(conteudo);
		builder.append("<div>");
		builder.append("<h2 style=\"text-align: center; color: #FF6347\">");
		builder.append("*** ");
		builder.append(getMensagem());
		builder.append(" *** ");
		builder.append("</h2>");
		builder.append("</div>");
//		builder.append("<div >");
//		builder.append(
//				"<a href=\"http://www.novorioantigo.com.br\" class=\"novo-rio\" target=\"_blank\"><img style=\"width: 100%;max-width: 513px;max-height: 162px;height: auto;display: table;margin: 34px auto 0 auto;\" src=\"https://dancaccc.com.br/wp-content/themes/site/library/i/logo-casas-03.png\"></a>");
//		builder.append("</div>");
//		builder.append("</div>");
		builder.append("</body>");
		builder.append("</html>");
		
		return builder.toString();
	}

	private String getMensagem() {
		String msg = msgEmail.getMesage();
		if(msg == null)
			return "";
		return msg;
	}

	private HtmlEmail getConfigHmlEmail() throws Exception {
		HtmlEmail email = new HtmlEmail();
		email.setSSLOnConnect(false);
		email.setHostName(emailProperties.getHost());
		email.setSslSmtpPort(emailProperties.getPort());
		email.setSmtpPort(new Integer(emailProperties.getPort()));
		email.setAuthenticator(new DefaultAuthenticator(emailProperties.getOrigem(), emailProperties.getPassword()));
		email.setFrom(emailProperties.getOrigem());
		
		return email;
	}

	private SimpleEmail getConfigEmail() throws Exception {
		SimpleEmail email = new SimpleEmail();
		email.setSSLOnConnect(false);
		
		email.setHostName("smtp.controle-ccc.website");
		email.setSslSmtpPort("547");
		email.setSmtpPort(547);
		email.setAuthenticator(new DefaultAuthenticator("recibos@controle-ccc.website", "IsNarDCCC"));
		email.setFrom("recibos@controle-ccc.website");
		return email;

	}

	public MensagemEmail getMensagemEmail() {
		return msgEmail.getMensagemEmail();
	}

	public void atualizarMensagem(MensagemEmail msg) {
		msgEmail.save(msg);
	}
}
