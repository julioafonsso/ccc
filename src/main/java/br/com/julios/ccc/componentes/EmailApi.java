package br.com.julios.ccc.componentes;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.model.AulaParticularDO;
import br.com.julios.ccc.infra.bd.model.ComissaoProfessorDO;
import br.com.julios.ccc.infra.bd.model.FluxoCaixaDO;
import br.com.julios.ccc.infra.bd.model.FuncionarioDO;
import br.com.julios.ccc.infra.bd.model.MatriculaDO;
import br.com.julios.ccc.infra.bd.model.MensagemEmailDO;
import br.com.julios.ccc.infra.bd.model.MensalidadeDO;

@Service
public class EmailApi {

	@Autowired
	EmailProperties emailProperties;
	
//	@Autowired
//	private MsgEmailDAO msgEmail;

	public static void main(String[] args) throws Exception {
		EmailApi e = new EmailApi();
		e.enviarEmailReciboMensalidade(null);
	}

	public void enviarEmailAulaParticular(MatriculaDO matricula, AulaParticularDO aula, FluxoCaixaDO fluxo) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		HtmlEmail email = getConfigHmlEmail();
		email.addTo(matricula.getEmailAluno());
		email.setSubject(
				"Recibo Pagamento Matricula " + matricula.getNomeModalidade() + " "
						+ matricula.getNomeNivel());


		
		StringBuilder builder = new StringBuilder();
		
		builder.append("<!doctype html><html xmlns='http://www.w3.org/1999/xhtml' xmlns:v='urn:schemas-microsoft-com:vml' xmlns:o='urn:schemas-microsoft-com:office:office'><head> <meta charset='UTF-8'> <meta http-equiv='X-UA-Compatible' content='IE=edge'> <meta name='viewport' content='width=device-width, initial-scale=1'> <title>{{titulo}}</title> <style type='text/css'> p{margin: 10px 0; padding: 0;}b{font-family: Helvetica; font-size: 14px;}table{border-collapse: collapse;}h1, h2, h3, h4, h5, h6{display: block; margin: 0; padding: 0;}body, #bodyTable, #bodyCell{height: 100%; margin: 0; padding: 0; width: 100%;}#templateBody{background-color: #FFFFFF; background-image: none; background-repeat: no-repeat; background-position: center; background-size: cover; border-top: 0; border-bottom: 0; padding-top: 9px; padding-bottom: 9px;}#templateBody .mcnTextContent, #templateBody .mcnTextContent p{color: #202020; font-family: Helvetica; font-size: 16px; line-height: 150%; text-align: left;}#templateBody .mcnTextContent a, #templateBody .mcnTextContent p a{color: #2BAADF; font-weight: normal; text-decoration: underline;}#templateColumns{background-color: #FFFFFF; background-image: none; background-repeat: no-repeat; background-position: center; background-size: cover; border-top: 0; border-bottom: 2px solid #EAEAEA; padding-top: 0; padding-bottom: 9px;}#templateColumns .columnContainer .mcnTextContent, #templateColumns .columnContainer .mcnTextContent p{color: #202020; font-family: Helvetica; font-size: 16px; line-height: 150%; text-align: left;}#templateColumns .columnContainer .mcnTextContent a, #templateColumns .columnContainer .mcnTextContent p a{color: #2BAADF; font-weight: normal; text-decoration: underline;}#templateFooter{background-color: #FAFAFA; background-image: none; background-repeat: no-repeat; background-position: center; background-size: cover; border-top: 0; border-bottom: 0; padding-top: 9px; padding-bottom: 9px;}#templateFooter .mcnTextContent, #templateFooter .mcnTextContent p{color: #656565; font-family: Helvetica; font-size: 12px; line-height: 150%; text-align: center;}#templateFooter .mcnTextContent a, #templateFooter .mcnTextContent p a{color: #656565; font-weight: normal; text-decoration: underline;}@media only screen and (min-width:768px){.templateContainer{width: 600px !important;}}@media only screen and (max-width: 480px){body, table, td, p, a, li, blockquote{-webkit-text-size-adjust: none !important;}}@media only screen and (max-width: 480px){body{width: 100% !important; min-width: 100% !important;}}@media only screen and (max-width: 480px){#bodyCell{padding-top: 10px !important;}}@media only screen and (max-width: 480px){.columnWrapper{max-width: 100% !important; width: 100% !important;}}@media only screen and (max-width: 480px){.mcnImage{width: 100% !important;}}@media only screen and (max-width: 480px){.mcnCartContainer, .mcnCaptionTopContent, .mcnRecContentContainer, .mcnCaptionBottomContent, .mcnTextContentContainer, .mcnBoxedTextContentContainer, .mcnImageGroupContentContainer, .mcnCaptionLeftTextContentContainer, .mcnCaptionRightTextContentContainer, .mcnCaptionLeftImageContentContainer, .mcnCaptionRightImageContentContainer, .mcnImageCardLeftTextContentContainer, .mcnImageCardRightTextContentContainer{max-width: 100% !important; width: 100% !important;}}@media only screen and (max-width: 480px){.mcnBoxedTextContentContainer{min-width: 100% !important;}}@media only screen and (max-width: 480px){.mcnImageGroupContent{padding: 9px !important;}}@media only screen and (max-width: 480px){.mcnCaptionLeftContentOuter .mcnTextContent, .mcnCaptionRightContentOuter .mcnTextContent{padding-top: 9px !important;}}@media only screen and (max-width: 480px){.mcnImageCardTopImageContent, .mcnCaptionBlockInner .mcnCaptionTopContent:last-child .mcnTextContent{padding-top: 18px !important;}}@media only screen and (max-width: 480px){.mcnImageCardBottomImageContent{padding-bottom: 9px !important;}}@media only screen and (max-width: 480px){.mcnImageGroupBlockInner{padding-top: 0 !important; padding-bottom: 0 !important;}}@media only screen and (max-width: 480px){.mcnImageGroupBlockOuter{padding-top: 9px !important; padding-bottom: 9px !important;}}@media only screen and (max-width: 480px){.mcnTextContent, .mcnBoxedTextContentColumn{padding-right: 18px !important; padding-left: 18px !important;}}@media only screen and (max-width: 480px){.mcnImageCardLeftImageContent, .mcnImageCardRightImageContent{padding-right: 18px !important; padding-bottom: 0 !important; padding-left: 18px !important;}}@media only screen and (max-width: 480px){.mcpreview-image-uploader{display: none !important; width: 100% !important;}}@media only screen and (max-width: 480px){h1{font-size: 22px !important; line-height: 125% !important;}}@media only screen and (max-width: 480px){h2{font-size: 20px !important; line-height: 125% !important;}}@media only screen and (max-width: 480px){h3{font-size: 18px !important; line-height: 125% !important;}}@media only screen and (max-width: 480px){h4{font-size: 16px !important; line-height: 150% !important;}}@media only screen and (max-width: 480px){.mcnBoxedTextContentContainer .mcnTextContent, .mcnBoxedTextContentContainer .mcnTextContent p{font-size: 14px !important; line-height: 150% !important;}}@media only screen and (max-width: 480px){#templatePreheader{display: block !important;}}@media only screen and (max-width: 480px){#templatePreheader .mcnTextContent, #templatePreheader .mcnTextContent p{font-size: 14px !important; line-height: 150% !important;}}@media only screen and (max-width: 480px){#templateHeader .mcnTextContent, #templateHeader .mcnTextContent p{font-size: 16px !important; line-height: 150% !important;}}@media only screen and (max-width: 480px){#templateBody .mcnTextContent, #templateBody .mcnTextContent p{font-size: 16px !important; line-height: 150% !important;}}@media only screen and (max-width: 480px){#templateColumns .columnContainer .mcnTextContent, #templateColumns .columnContainer .mcnTextContent p{font-size: 16px !important; line-height: 150% !important;}}@media only screen and (max-width: 480px){#templateFooter .mcnTextContent, #templateFooter .mcnTextContent p{font-size: 14px !important; line-height: 150% !important;}}</style></head><body> <center> <table align='left' border='0' height='100%' width='100%' id='bodyTable'> <tr> <td align='left' valign='top' id='templateHeader'> <table align='left' border='0' width='100%' class='templateContainer'> <tr> <td valign='top' class='headerContainer'> <table border='0' width='100%' class='mcnImageBlock' style='min-width:100%;'> <tbody class='mcnImageBlockOuter'> <tr> <td valign='top' style='padding:9px' class='mcnImageBlockInner'> <table align='left' width='100%' border='0' class='mcnImageContentContainer' style='min-width:100%;'> <tbody> <tr> <td class='mcnImageContent' valign='top' style='padding-right: 9px; padding-left: 9px; padding-top: 0; padding-bottom: 0; text-align:center;'><img align='left' alt='' src='http://controle-ccc.website/imagens/logo_email2.jpg' width='320' style='max-width:320px; padding-bottom: 0; display: inline !important; vertical-align: bottom;' class='mcnImage'></td></tr></tbody> </table> </td></tr></tbody> </table> </td></tr></table> </td></tr><tr> <td align='left' valign='top' id='templateBody'> <table align='left' border='0' width='100%' class='templateContainer'> <tr> <td valign='top' class='bodyContainer'> <table border='0' width='100%' class='mcnTextBlock' style='min-width:100%;'> <tbody class='mcnTextBlockOuter'> <tr> <td valign='top' class='mcnTextBlockInner' style='padding-top:9px;'> <table align='left' border='0' style='max-width:100%; min-width:100%;' width='100%' class='mcnTextContentContainer'> <tbody> <tr> <td valign='top' class='mcnTextContent' style='padding-top:0; padding-right:18px; padding-bottom:9px; padding-left:18px;'> <p style='font-family: Helvetica;font-size: 14px;'>&nbsp; &nbsp; Prezado Aluno, você está recebendo o seu comprovante de pagamento. Enquanto for aluno Dança CCC todos os seus pagamentos terão os recibos instantaneamente enviados para esse endereço de e-mail, que você forneceu paranós no ato da sua inscrição.</p><br><h2>Recibo de Aulas Particulares</h2> </td></tr></tbody> </table> </td></tr></tbody> </table> <table align='left' border='1' width='100%' class='templateContainer'> <tr> <td> <table align='left' width='100%' class='templateContainer'> <tr> <td> <table align='center ' border='1' width='100%' class='templateContainer'> <tr> <td><b>Modalidade</b>:{{modalidade}}</td><td><b>Qtd Aulas </b>:{{qtd}}</td><td><b>Professor</b>:{{professor}}</td></tr></table> </td></tr><tr> <td> <table align='left' border='1' width='100%' class='templateContainer'> <tr> <td> <p><b>Aluno:</b>{{aluno}}</p></td></tr></table> </td></tr></table> </td><td><b>Valor</b> <p>R${{valor}}</p></td></tr></table> <table align='left' width='100%'> <tr> <td style='text-align: right'><b> Data </b>{{data}}</td></tr></table> </td></tr></table> </td></tr><tr> <td align='left' valign='top' id='templateColumns'> <table border='0' width='100%' class='templateContainer'> <tr> <td valign='top'> <table align='left' border='0' width='200' class='columnWrapper'> <tr> <td valign='top' class='columnContainer'></td></tr></table> <table align='left' border='0' width='200' class='columnWrapper'> <tr> <td valign='top' class='columnContainer'></td></tr></table> <table align='left' border='0' width='200' class='columnWrapper'> <tr> <td valign='top' class='columnContainer'></td></tr></table> </td></tr></table> </td></tr><tr> <td align='left' valign='top' id='templateFooter'> <table align='left' border='0' width='100%' class='templateContainer'> <tr> <td valign='top' class='footerContainer'> <table border='0' width='100%' class='mcnFollowBlock' style='min-width:100%;'> <tbody class='mcnFollowBlockOuter'> <tr> <td align='left' valign='top' style='padding:9px' class='mcnFollowBlockInner'> <table border='0' width='100%' class='mcnFollowContentContainer' style='min-width:100%;'> <tbody> <tr> <td align='left' style='padding-left:9px;padding-right:9px;'> <table border='0' width='100%' style='min-width:100%;' class='mcnFollowContent'> <tbody> <tr> <td align='left' valign='top' style='padding-top:9px; padding-right:9px; padding-left:9px;'> <table align='left' border='0'> <tbody> <tr> <td align='left' valign='top'> <table align='left' border='0' style='display:inline;'> <tbody> <tr> <td valign='top' style='padding-right:10px; padding-bottom:9px;' class='mcnFollowContentItemContainer'> <table border='0' width='100%' class='mcnFollowContentItem'> <tbody> <tr> <td align='left' valign='middle' style='padding-top:5px; padding-right:10px; padding-bottom:5px; padding-left:9px;'> <table align='left' border='0' width=''> <tbody> <tr> <td align='left' valign='middle' width='24' class='mcnFollowIconContent'> <a href='http://www.twitter.com/' target='_blank'> <img src='https://cdn-images.mailchimp.com/icons/social-block-v2/color-twitter-48.png' style='display:block;' height='24' width='24' class=''></a> </td></tr></tbody> </table> </td></tr></tbody> </table> </td></tr></tbody> </table> <table align='left' border='0' style='display:inline;'> <tbody> <tr> <td valign='top' style='padding-right:10px; padding-bottom:9px;' class='mcnFollowContentItemContainer'> <table border='0' width='100%' class='mcnFollowContentItem'> <tbody> <tr> <td align='left' valign='middle' style='padding-top:5px; padding-right:10px; padding-bottom:5px; padding-left:9px;'> <table align='left' border='0' width=''> <tbody> <tr> <td align='left' valign='middle' width='24' class='mcnFollowIconContent'> <a href='http://www.facebook.com' target='_blank'> <img src='https://cdn-images.mailchimp.com/icons/social-block-v2/color-facebook-48.png' style='display:block;' height='24' width='24' class=''></a> </td></tr></tbody> </table> </td></tr></tbody> </table> </td></tr></tbody> </table> <table align='left' border='0' style='display:inline;'> <tbody> <tr> <td valign='top' style='padding-right:0; padding-bottom:9px;' class='mcnFollowContentItemContainer'> <table border='0' width='100%' class='mcnFollowContentItem'> <tbody> <tr> <td align='left' valign='middle' style='padding-top:5px; padding-right:10px; padding-bottom:5px; padding-left:9px;'> <table align='left' border='0' width=''> <tbody> <tr> <td align='left' valign='middle' width='24' class='mcnFollowIconContent'> <a href='http://mailchimp.com' target='_blank'> <img src='https://cdn-images.mailchimp.com/icons/social-block-v2/color-link-48.png' style='display:block;' height='24' width='24' class=''></a> </td></tr></tbody> </table> </td></tr></tbody> </table> </td></tr></tbody> </table> </td></tr></tbody> </table> </td></tr></tbody> </table> </td></tr></tbody> </table> </td></tr></tbody> </table> <table border='0' width='100%' class='mcnTextBlock' style='min-width:100%;'> <tbody class='mcnTextBlockOuter'> <tr> <td valign='top' class='mcnTextBlockInner' style='padding-top:9px;'> <table align='left' border='0' style='max-width:100%; min-width:100%;' width='100%' class='mcnTextContentContainer'> <tbody> <tr> <td valign='top' class='mcnTextContent' style='padding-top:0; padding-right:18px; padding-bottom:9px; padding-left:18px;'>&nbsp;Qualquer dúvida sobre como proceder com relação a assuntos ligados à sua matricula, click <a href='http://www.google.com' target='_blank'>aqui</a>&nbsp;ou ligue (21) 3176-1462 de segunda à sexta das 12:00hs às 21:00hs e fale com&nbsp;um de nossos funcionários.</td></tr></tbody> </table> </td></tr></tbody> </table> </td></tr></table> </td></tr></table> </td></tr></table> </center></body></html>");
		
		int index = builder.indexOf("{{modalidade}}");
		builder.replace( index, index +14 ,matricula.getNomeModalidade());
		
		index = builder.indexOf("{{qtd}}");
		builder.replace( index, index +7 ,aula.getQtdAulasContratadas().toString());
		
		index = builder.indexOf("{{professor}}");
		builder.replace( index, index +13 ,aula.getNomeProfessor());
		
		index = builder.indexOf("{{titulo}}");
		builder.replace( index, index +10,"Recibo Aula Particular");
		
		index = builder.indexOf("{{valor}}");
		builder.replace( index, index +9,new DecimalFormat("#.##").format(fluxo.getValor()));
		
		index = builder.indexOf("{{aluno}}");
		builder.replace( index, index +9,matricula.getNomeAluno());
		
		index = builder.indexOf("{{data}}");
		builder.replace( index, index +8,sdf.format(new Date()));
		
		email.setContent(builder.toString(), "text/html; charset=utf-8");
		email.send();
	}
	
	public void enviarEmailReciboMatricula(MatriculaDO matricula, FluxoCaixaDO fluxo) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		HtmlEmail email = getConfigHmlEmail();
		email.addTo(matricula.getEmailAluno());
		email.setSubject(
				"Recibo Pagamento Matricula " + matricula.getNomeModalidade() + " "
						+ matricula.getNomeNivel());

		StringBuilder builder = new StringBuilder();
		
		builder.append("<!doctype html><html xmlns='http:www.w3.org/1999/xhtml' xmlns:v='urn:schemas-microsoft-com:vml' xmlns:o='urn:schemas-microsoft-com:office:office'><head><meta charset='UTF-8'><meta http-equiv='X-UA-Compatible' content='IE=edge'><meta name='viewport' content='width=device-width, initial-scale=1'><title>{{titulo}}</title><style type='text/css'>p{margin: 10px 0;padding: 0;}b{font-family: Helvetica;font-size: 14px;}table{border-collapse: collapse;}h1,h2,h3,h4,h5,h6{display: block;margin: 0;padding: 0;}body,#bodyTable,#bodyCell{height: 100%;margin: 0;padding: 0;width: 100%;}#templateBody{background-color: #FFFFFF;background-image: none;background-repeat: no-repeat;background-position: center;background-size: cover;border-top: 0;border-bottom: 0;padding-top: 9px;padding-bottom: 9px;}#templateBody .mcnTextContent,#templateBody .mcnTextContent p{color: #202020;font-family: Helvetica;font-size: 16px;line-height: 150%;text-align: left;}#templateBody .mcnTextContent a,#templateBody .mcnTextContent p a{color: #2BAADF;font-weight: normal;text-decoration: underline;}#templateColumns{background-color: #FFFFFF;background-image: none;background-repeat: no-repeat;background-position: center;background-size: cover;border-top: 0;border-bottom: 2px solid #EAEAEA;padding-top: 0;padding-bottom: 9px;}#templateColumns .columnContainer .mcnTextContent,#templateColumns .columnContainer .mcnTextContent p{color: #202020;font-family: Helvetica;font-size: 16px;line-height: 150%;text-align: left;}#templateColumns .columnContainer .mcnTextContent a,#templateColumns .columnContainer .mcnTextContent p a{color: #2BAADF;font-weight: normal;text-decoration: underline;}#templateFooter{background-color: #FAFAFA;background-image: none;background-repeat: no-repeat;background-position: center;background-size: cover;border-top: 0;border-bottom: 0;padding-top: 9px;padding-bottom: 9px;}#templateFooter .mcnTextContent,#templateFooter .mcnTextContent p{color: #656565;font-family: Helvetica;font-size: 12px;line-height: 150%;text-align: center;}#templateFooter .mcnTextContent a,#templateFooter .mcnTextContent p a{color: #656565;font-weight: normal;text-decoration: underline;}@media only screen and (min-width:768px){.templateContainer{width: 600px !important;}}@media only screen and (max-width: 480px){body,table,td,p,a,li,blockquote{-webkit-text-size-adjust: none !important;}}@media only screen and (max-width: 480px){body{width: 100% !important;min-width: 100% !important;}}@media only screen and (max-width: 480px){#bodyCell{padding-top: 10px !important;}}@media only screen and (max-width: 480px){.columnWrapper{max-width: 100% !important;width: 100% !important;}}@media only screen and (max-width: 480px){.mcnImage{width: 100% !important;}}@media only screen and (max-width: 480px){.mcnCartContainer,.mcnCaptionTopContent,.mcnRecContentContainer,.mcnCaptionBottomContent,.mcnTextContentContainer,.mcnBoxedTextContentContainer,.mcnImageGroupContentContainer,.mcnCaptionLeftTextContentContainer,.mcnCaptionRightTextContentContainer,.mcnCaptionLeftImageContentContainer,.mcnCaptionRightImageContentContainer,.mcnImageCardLeftTextContentContainer,.mcnImageCardRightTextContentContainer{max-width: 100% !important;width: 100% !important;}}@media only screen and (max-width: 480px){.mcnBoxedTextContentContainer{min-width: 100% !important;}}@media only screen and (max-width: 480px){.mcnImageGroupContent{padding: 9px !important;}}@media only screen and (max-width: 480px){.mcnCaptionLeftContentOuter .mcnTextContent,.mcnCaptionRightContentOuter .mcnTextContent{padding-top: 9px !important;}}@media only screen and (max-width: 480px){.mcnImageCardTopImageContent,.mcnCaptionBlockInner .mcnCaptionTopContent:last-child .mcnTextContent{padding-top: 18px !important;}}@media only screen and (max-width: 480px){.mcnImageCardBottomImageContent{padding-bottom: 9px !important;}}@media only screen and (max-width: 480px){.mcnImageGroupBlockInner{padding-top: 0 !important;padding-bottom: 0 !important;}}@media only screen and (max-width: 480px){.mcnImageGroupBlockOuter{padding-top: 9px !important;padding-bottom: 9px !important;}}@media only screen and (max-width: 480px){.mcnTextContent,.mcnBoxedTextContentColumn{padding-right: 18px !important;padding-left: 18px !important;}}@media only screen and (max-width: 480px){.mcnImageCardLeftImageContent,.mcnImageCardRightImageContent{padding-right: 18px !important;padding-bottom: 0 !important;padding-left: 18px !important;}}@media only screen and (max-width: 480px){.mcpreview-image-uploader{display: none !important;width: 100% !important;}}@media only screen and (max-width: 480px){h1{font-size: 22px !important;line-height: 125% !important;}}@media only screen and (max-width: 480px){h2{font-size: 20px !important;line-height: 125% !important;}}@media only screen and (max-width: 480px){h3{font-size: 18px !important;line-height: 125% !important;}}@media only screen and (max-width: 480px){h4{font-size: 16px !important;line-height: 150% !important;}}@media only screen and (max-width: 480px){.mcnBoxedTextContentContainer .mcnTextContent,.mcnBoxedTextContentContainer .mcnTextContent p{font-size: 14px !important;line-height: 150% !important;}}@media only screen and (max-width: 480px){#templatePreheader{display: block !important;}}@media only screen and (max-width: 480px){#templatePreheader .mcnTextContent,#templatePreheader .mcnTextContent p{font-size: 14px !important;line-height: 150% !important;}}@media only screen and (max-width: 480px){#templateHeader .mcnTextContent,#templateHeader .mcnTextContent p{font-size: 16px !important;line-height: 150% !important;}}@media only screen and (max-width: 480px){#templateBody .mcnTextContent,#templateBody .mcnTextContent p{font-size: 16px !important;line-height: 150% !important;}}@media only screen and (max-width: 480px){#templateColumns .columnContainer .mcnTextContent,#templateColumns .columnContainer .mcnTextContent p{font-size: 16px !important;line-height: 150% !important;}}@media only screen and (max-width: 480px){#templateFooter .mcnTextContent,#templateFooter .mcnTextContent p{font-size: 14px !important;line-height: 150% !important;}}</style></head><body><center><table align='left' border='0' height='100%' width='100%' id='bodyTable'><tr><td align='left' valign='top' id='templateHeader'><table align='left' border='0' width='100%' class='templateContainer'><tr><td valign='top' class='headerContainer'><table border='0' width='100%' class='mcnImageBlock' style='min-width:100%;'><tbody class='mcnImageBlockOuter'><tr><td valign='top' style='padding:9px' class='mcnImageBlockInner'><table align='left' width='100%' border='0' class='mcnImageContentContainer' style='min-width:100%;'><tbody><tr><td class='mcnImageContent' valign='top' style='padding-right: 9px; padding-left: 9px; padding-top: 0; padding-bottom: 0; text-align:center;'><img align='left' alt='' src='http:controle-ccc.website/imagens/logo_email2.jpg' width='320' style='max-width:320px; padding-bottom: 0; display: inline !important; vertical-align: bottom;'class='mcnImage'></td></tr></tbody></table></td></tr></tbody></table></td></tr></table></td></tr><tr><td align='left' valign='top' id='templateBody'><table align='left' border='0' width='100%' class='templateContainer'><tr><td valign='top' class='bodyContainer'><table border='0' width='100%' class='mcnTextBlock' style='min-width:100%;'><tbody class='mcnTextBlockOuter'><tr><td valign='top' class='mcnTextBlockInner' style='padding-top:9px;'><table align='left' border='0' style='max-width:100%; min-width:100%;' width='100%' class='mcnTextContentContainer'><tbody><tr><td valign='top' class='mcnTextContent' style='padding-top:0; padding-right:18px; padding-bottom:9px; padding-left:18px;'><p style='font-family: Helvetica;font-size: 14px;'>&nbsp; &nbsp; Prezado Aluno, você está recebendo o seu comprovante de pagamento. Enquanto for aluno Dança CCC todos os seus pagamentos terão os recibos instantaneamente enviados para esse endereço de e-mail, que você forneceu paranós no ato da sua inscrição.</p><br><h2>Recibo de Mensalidade</h2></td></tr></tbody></table></td></tr></tbody></table><table align='left' border='1' width='100%' class='templateContainer'><tr><td><table align='left' width='100%' class='templateContainer'><tr><td><table align='center ' border='1' width='100%' class='templateContainer'><tr><td><b>Turma</b>:{{turma}}</td><td><b>Dias</b>:{{dias}}</td><td><b>Horarios</b>:{{horario}}</td></tr></table></td></tr><tr><td><table align='left' border='1' width='100%' class='templateContainer'><tr><td><p><b>Aluno:</b>{{aluno}}</p></td></tr></table></td></tr></table></td><td><b>Valor</b><p>R${{valor}}</p></td></tr></table><table align='left' width='100%'><tr><td><b>Cod:</b>{{codTurma}}</td><td style='text-align: center'><b> Data </b>{{data}}</td></tr></table></td></tr></table></td></tr><tr><td align='left' valign='top' id='templateColumns'><table border='0' width='100%' class='templateContainer'><tr><td valign='top'><table align='left' border='0' width='200' class='columnWrapper'><tr><td valign='top' class='columnContainer'></td></tr></table><table align='left' border='0' width='200' class='columnWrapper'><tr><td valign='top' class='columnContainer'></td></tr></table><table align='left' border='0' width='200' class='columnWrapper'><tr><td valign='top' class='columnContainer'></td></tr></table></td></tr></table></td></tr><tr><td align='left' valign='top' id='templateFooter'><table align='left' border='0' width='100%' class='templateContainer'><tr><td valign='top' class='footerContainer'><table border='0' width='100%' class='mcnFollowBlock' style='min-width:100%;'><tbody class='mcnFollowBlockOuter'><tr><td align='left' valign='top' style='padding:9px' class='mcnFollowBlockInner'><table border='0' width='100%' class='mcnFollowContentContainer' style='min-width:100%;'><tbody><tr><td align='left' style='padding-left:9px;padding-right:9px;'><table border='0' width='100%' style='min-width:100%;' class='mcnFollowContent'><tbody><tr><td align='left' valign='top' style='padding-top:9px; padding-right:9px; padding-left:9px;'><table align='left' border='0'><tbody><tr><td align='left' valign='top'><table align='left' border='0' style='display:inline;'><tbody><tr><td valign='top' style='padding-right:10px; padding-bottom:9px;' class='mcnFollowContentItemContainer'><table border='0' width='100%' class='mcnFollowContentItem'><tbody><tr><td align='left' valign='middle' style='padding-top:5px; padding-right:10px; padding-bottom:5px; padding-left:9px;'><table align='left' border='0' width=''><tbody><tr><td align='left' valign='middle' width='24' class='mcnFollowIconContent'><a href='http:www.twitter.com/' target='_blank'><img src='https:cdn-images.mailchimp.com/icons/social-block-v2/color-twitter-48.png'style='display:block;' height='24' width='24' class=''></a></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table><table align='left' border='0' style='display:inline;'><tbody><tr><td valign='top' style='padding-right:10px; padding-bottom:9px;' class='mcnFollowContentItemContainer'><table border='0' width='100%' class='mcnFollowContentItem'><tbody><tr><td align='left' valign='middle' style='padding-top:5px; padding-right:10px; padding-bottom:5px; padding-left:9px;'><table align='left' border='0' width=''><tbody><tr><td align='left' valign='middle' width='24' class='mcnFollowIconContent'><a href='http:www.facebook.com' target='_blank'><img src='https:cdn-images.mailchimp.com/icons/social-block-v2/color-facebook-48.png'style='display:block;' height='24' width='24' class=''></a></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table><table align='left' border='0' style='display:inline;'><tbody><tr><td valign='top' style='padding-right:0; padding-bottom:9px;' class='mcnFollowContentItemContainer'><table border='0' width='100%' class='mcnFollowContentItem'><tbody><tr><td align='left' valign='middle' style='padding-top:5px; padding-right:10px; padding-bottom:5px; padding-left:9px;'><table align='left' border='0' width=''><tbody><tr><td align='left' valign='middle' width='24' class='mcnFollowIconContent'><a href='http:mailchimp.com' target='_blank'><img src='https:cdn-images.mailchimp.com/icons/social-block-v2/color-link-48.png' style='display:block;'height='24' width='24' class=''></a></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table><table border='0' width='100%' class='mcnTextBlock' style='min-width:100%;'><tbody class='mcnTextBlockOuter'><tr><td valign='top' class='mcnTextBlockInner' style='padding-top:9px;'><table align='left' border='0' style='max-width:100%; min-width:100%;' width='100%' class='mcnTextContentContainer'><tbody><tr><td valign='top' class='mcnTextContent' style='padding-top:0; padding-right:18px; padding-bottom:9px; padding-left:18px;'>&nbsp;Qualquer dúvida sobre como proceder com relação a assuntos ligados à sua matricula, click <a href='http:www.google.com'target='_blank'>aqui</a>&nbsp;ou ligue (21) 3176-1462 de segunda à sexta das 12:00hs às 21:00hs e fale com&nbsp;um de nossos funcionários.</td></tr></tbody></table></td></tr></tbody></table></td></tr></table></td></tr></table></td></tr></table></center></body></html>");
		
		int index = builder.indexOf("{{turma}}");
		builder.replace( index, index +9,matricula.getNomeModalidade());
		
		index = builder.indexOf("{{dias}}"	);
		builder.replace( index, index +8,matricula.getDiasTurmas());
		
		index = builder.indexOf("{{horario}}");
		builder.replace( index, index +11,matricula.getHorarioTurma() );
		
		
		index = builder.indexOf("{{valor}}");
		builder.replace( index, index +9,new DecimalFormat("#.##").format(fluxo.getValor()));
		
		index = builder.indexOf("{{aluno}}");
		builder.replace( index, index +9,matricula.getNomeAluno());
		
		index = builder.indexOf("{{codTurma}}");
		builder.replace( index, index +12,matricula.getCodigoTurma());
		
		index = builder.indexOf("{{data}}");
		builder.replace( index, index +8,sdf.format(new Date()));
		
		index = builder.indexOf("{{titulo}}");
		builder.replace( index, index +10,"Recibo Mensalidade");
		
		System.out.println(builder.toString());
		email.setContent(builder.toString(), "text/html; charset=utf-8");
		email.send();
	}

	public void enviarEmailReciboMensalidade(MensalidadeDO mensalidade) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		HtmlEmail email = getConfigHmlEmail();
		email.addTo(mensalidade.getMatricula().getEmailAluno());
		email.setSubject(
				"Recibo Pagamento Mensalidade " + mensalidade.getMatricula().getNomeModalidade() + " "
						+ mensalidade.getMatricula().getNomeNivel() + " - Mes "
						+ mensalidade.getNomeMes());

		StringBuilder builder = new StringBuilder();
		
		builder.append("<!doctype html><html xmlns='http:www.w3.org/1999/xhtml' xmlns:v='urn:schemas-microsoft-com:vml' xmlns:o='urn:schemas-microsoft-com:office:office'><head><meta charset='UTF-8'><meta http-equiv='X-UA-Compatible' content='IE=edge'><meta name='viewport' content='width=device-width, initial-scale=1'><title>{{titulo}}</title><style type='text/css'>p{margin: 10px 0;padding: 0;}b{font-family: Helvetica;font-size: 14px;}table{border-collapse: collapse;}h1,h2,h3,h4,h5,h6{display: block;margin: 0;padding: 0;}body,#bodyTable,#bodyCell{height: 100%;margin: 0;padding: 0;width: 100%;}#templateBody{background-color: #FFFFFF;background-image: none;background-repeat: no-repeat;background-position: center;background-size: cover;border-top: 0;border-bottom: 0;padding-top: 9px;padding-bottom: 9px;}#templateBody .mcnTextContent,#templateBody .mcnTextContent p{color: #202020;font-family: Helvetica;font-size: 16px;line-height: 150%;text-align: left;}#templateBody .mcnTextContent a,#templateBody .mcnTextContent p a{color: #2BAADF;font-weight: normal;text-decoration: underline;}#templateColumns{background-color: #FFFFFF;background-image: none;background-repeat: no-repeat;background-position: center;background-size: cover;border-top: 0;border-bottom: 2px solid #EAEAEA;padding-top: 0;padding-bottom: 9px;}#templateColumns .columnContainer .mcnTextContent,#templateColumns .columnContainer .mcnTextContent p{color: #202020;font-family: Helvetica;font-size: 16px;line-height: 150%;text-align: left;}#templateColumns .columnContainer .mcnTextContent a,#templateColumns .columnContainer .mcnTextContent p a{color: #2BAADF;font-weight: normal;text-decoration: underline;}#templateFooter{background-color: #FAFAFA;background-image: none;background-repeat: no-repeat;background-position: center;background-size: cover;border-top: 0;border-bottom: 0;padding-top: 9px;padding-bottom: 9px;}#templateFooter .mcnTextContent,#templateFooter .mcnTextContent p{color: #656565;font-family: Helvetica;font-size: 12px;line-height: 150%;text-align: center;}#templateFooter .mcnTextContent a,#templateFooter .mcnTextContent p a{color: #656565;font-weight: normal;text-decoration: underline;}@media only screen and (min-width:768px){.templateContainer{width: 600px !important;}}@media only screen and (max-width: 480px){body,table,td,p,a,li,blockquote{-webkit-text-size-adjust: none !important;}}@media only screen and (max-width: 480px){body{width: 100% !important;min-width: 100% !important;}}@media only screen and (max-width: 480px){#bodyCell{padding-top: 10px !important;}}@media only screen and (max-width: 480px){.columnWrapper{max-width: 100% !important;width: 100% !important;}}@media only screen and (max-width: 480px){.mcnImage{width: 100% !important;}}@media only screen and (max-width: 480px){.mcnCartContainer,.mcnCaptionTopContent,.mcnRecContentContainer,.mcnCaptionBottomContent,.mcnTextContentContainer,.mcnBoxedTextContentContainer,.mcnImageGroupContentContainer,.mcnCaptionLeftTextContentContainer,.mcnCaptionRightTextContentContainer,.mcnCaptionLeftImageContentContainer,.mcnCaptionRightImageContentContainer,.mcnImageCardLeftTextContentContainer,.mcnImageCardRightTextContentContainer{max-width: 100% !important;width: 100% !important;}}@media only screen and (max-width: 480px){.mcnBoxedTextContentContainer{min-width: 100% !important;}}@media only screen and (max-width: 480px){.mcnImageGroupContent{padding: 9px !important;}}@media only screen and (max-width: 480px){.mcnCaptionLeftContentOuter .mcnTextContent,.mcnCaptionRightContentOuter .mcnTextContent{padding-top: 9px !important;}}@media only screen and (max-width: 480px){.mcnImageCardTopImageContent,.mcnCaptionBlockInner .mcnCaptionTopContent:last-child .mcnTextContent{padding-top: 18px !important;}}@media only screen and (max-width: 480px){.mcnImageCardBottomImageContent{padding-bottom: 9px !important;}}@media only screen and (max-width: 480px){.mcnImageGroupBlockInner{padding-top: 0 !important;padding-bottom: 0 !important;}}@media only screen and (max-width: 480px){.mcnImageGroupBlockOuter{padding-top: 9px !important;padding-bottom: 9px !important;}}@media only screen and (max-width: 480px){.mcnTextContent,.mcnBoxedTextContentColumn{padding-right: 18px !important;padding-left: 18px !important;}}@media only screen and (max-width: 480px){.mcnImageCardLeftImageContent,.mcnImageCardRightImageContent{padding-right: 18px !important;padding-bottom: 0 !important;padding-left: 18px !important;}}@media only screen and (max-width: 480px){.mcpreview-image-uploader{display: none !important;width: 100% !important;}}@media only screen and (max-width: 480px){h1{font-size: 22px !important;line-height: 125% !important;}}@media only screen and (max-width: 480px){h2{font-size: 20px !important;line-height: 125% !important;}}@media only screen and (max-width: 480px){h3{font-size: 18px !important;line-height: 125% !important;}}@media only screen and (max-width: 480px){h4{font-size: 16px !important;line-height: 150% !important;}}@media only screen and (max-width: 480px){.mcnBoxedTextContentContainer .mcnTextContent,.mcnBoxedTextContentContainer .mcnTextContent p{font-size: 14px !important;line-height: 150% !important;}}@media only screen and (max-width: 480px){#templatePreheader{display: block !important;}}@media only screen and (max-width: 480px){#templatePreheader .mcnTextContent,#templatePreheader .mcnTextContent p{font-size: 14px !important;line-height: 150% !important;}}@media only screen and (max-width: 480px){#templateHeader .mcnTextContent,#templateHeader .mcnTextContent p{font-size: 16px !important;line-height: 150% !important;}}@media only screen and (max-width: 480px){#templateBody .mcnTextContent,#templateBody .mcnTextContent p{font-size: 16px !important;line-height: 150% !important;}}@media only screen and (max-width: 480px){#templateColumns .columnContainer .mcnTextContent,#templateColumns .columnContainer .mcnTextContent p{font-size: 16px !important;line-height: 150% !important;}}@media only screen and (max-width: 480px){#templateFooter .mcnTextContent,#templateFooter .mcnTextContent p{font-size: 14px !important;line-height: 150% !important;}}</style></head><body><center><table align='left' border='0' height='100%' width='100%' id='bodyTable'><tr><td align='left' valign='top' id='templateHeader'><table align='left' border='0' width='100%' class='templateContainer'><tr><td valign='top' class='headerContainer'><table border='0' width='100%' class='mcnImageBlock' style='min-width:100%;'><tbody class='mcnImageBlockOuter'><tr><td valign='top' style='padding:9px' class='mcnImageBlockInner'><table align='left' width='100%' border='0' class='mcnImageContentContainer' style='min-width:100%;'><tbody><tr><td class='mcnImageContent' valign='top' style='padding-right: 9px; padding-left: 9px; padding-top: 0; padding-bottom: 0; text-align:center;'><img align='left' alt='' src='http:controle-ccc.website/imagens/logo_email2.jpg' width='320' style='max-width:320px; padding-bottom: 0; display: inline !important; vertical-align: bottom;'class='mcnImage'></td></tr></tbody></table></td></tr></tbody></table></td></tr></table></td></tr><tr><td align='left' valign='top' id='templateBody'><table align='left' border='0' width='100%' class='templateContainer'><tr><td valign='top' class='bodyContainer'><table border='0' width='100%' class='mcnTextBlock' style='min-width:100%;'><tbody class='mcnTextBlockOuter'><tr><td valign='top' class='mcnTextBlockInner' style='padding-top:9px;'><table align='left' border='0' style='max-width:100%; min-width:100%;' width='100%' class='mcnTextContentContainer'><tbody><tr><td valign='top' class='mcnTextContent' style='padding-top:0; padding-right:18px; padding-bottom:9px; padding-left:18px;'><p style='font-family: Helvetica;font-size: 14px;'>&nbsp; &nbsp; Prezado Aluno, você está recebendo o seu comprovante de pagamento. Enquanto for aluno Dança CCC todos os seus pagamentos terão os recibos instantaneamente enviados para esse endereço de e-mail, que você forneceu paranós no ato da sua inscrição.</p><br><h2>Recibo de Mensalidade</h2></td></tr></tbody></table></td></tr></tbody></table><table align='left' border='1' width='100%' class='templateContainer'><tr><td><table align='left' width='100%' class='templateContainer'><tr><td><table align='center ' border='1' width='100%' class='templateContainer'><tr><td><b>Turma</b>:{{turma}}</td><td><b>Dias</b>:{{dias}}</td><td><b>Horarios</b>:{{horario}}</td></tr></table></td></tr><tr><td><table align='left' border='1' width='100%' class='templateContainer'><tr><td><b>Ref:</b>{{mesReferencia}}<p><b>Aluno:</b>{{aluno}}</p></td></tr></table></td></tr></table></td><td><b>Valor</b><p>R${{valor}}</p></td></tr></table><table align='left' width='100%'><tr><td><b>Cod:</b>{{codTurma}}</td><td style='text-align: center'><b> Data </b>{{data}}</td></tr></table></td></tr></table></td></tr><tr><td align='left' valign='top' id='templateColumns'><table border='0' width='100%' class='templateContainer'><tr><td valign='top'><table align='left' border='0' width='200' class='columnWrapper'><tr><td valign='top' class='columnContainer'></td></tr></table><table align='left' border='0' width='200' class='columnWrapper'><tr><td valign='top' class='columnContainer'></td></tr></table><table align='left' border='0' width='200' class='columnWrapper'><tr><td valign='top' class='columnContainer'></td></tr></table></td></tr></table></td></tr><tr><td align='left' valign='top' id='templateFooter'><table align='left' border='0' width='100%' class='templateContainer'><tr><td valign='top' class='footerContainer'><table border='0' width='100%' class='mcnFollowBlock' style='min-width:100%;'><tbody class='mcnFollowBlockOuter'><tr><td align='left' valign='top' style='padding:9px' class='mcnFollowBlockInner'><table border='0' width='100%' class='mcnFollowContentContainer' style='min-width:100%;'><tbody><tr><td align='left' style='padding-left:9px;padding-right:9px;'><table border='0' width='100%' style='min-width:100%;' class='mcnFollowContent'><tbody><tr><td align='left' valign='top' style='padding-top:9px; padding-right:9px; padding-left:9px;'><table align='left' border='0'><tbody><tr><td align='left' valign='top'><table align='left' border='0' style='display:inline;'><tbody><tr><td valign='top' style='padding-right:10px; padding-bottom:9px;' class='mcnFollowContentItemContainer'><table border='0' width='100%' class='mcnFollowContentItem'><tbody><tr><td align='left' valign='middle' style='padding-top:5px; padding-right:10px; padding-bottom:5px; padding-left:9px;'><table align='left' border='0' width=''><tbody><tr><td align='left' valign='middle' width='24' class='mcnFollowIconContent'><a href='http:www.twitter.com/' target='_blank'><img src='https:cdn-images.mailchimp.com/icons/social-block-v2/color-twitter-48.png'style='display:block;' height='24' width='24' class=''></a></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table><table align='left' border='0' style='display:inline;'><tbody><tr><td valign='top' style='padding-right:10px; padding-bottom:9px;' class='mcnFollowContentItemContainer'><table border='0' width='100%' class='mcnFollowContentItem'><tbody><tr><td align='left' valign='middle' style='padding-top:5px; padding-right:10px; padding-bottom:5px; padding-left:9px;'><table align='left' border='0' width=''><tbody><tr><td align='left' valign='middle' width='24' class='mcnFollowIconContent'><a href='http:www.facebook.com' target='_blank'><img src='https:cdn-images.mailchimp.com/icons/social-block-v2/color-facebook-48.png'style='display:block;' height='24' width='24' class=''></a></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table><table align='left' border='0' style='display:inline;'><tbody><tr><td valign='top' style='padding-right:0; padding-bottom:9px;' class='mcnFollowContentItemContainer'><table border='0' width='100%' class='mcnFollowContentItem'><tbody><tr><td align='left' valign='middle' style='padding-top:5px; padding-right:10px; padding-bottom:5px; padding-left:9px;'><table align='left' border='0' width=''><tbody><tr><td align='left' valign='middle' width='24' class='mcnFollowIconContent'><a href='http:mailchimp.com' target='_blank'><img src='https:cdn-images.mailchimp.com/icons/social-block-v2/color-link-48.png' style='display:block;'height='24' width='24' class=''></a></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table><table border='0' width='100%' class='mcnTextBlock' style='min-width:100%;'><tbody class='mcnTextBlockOuter'><tr><td valign='top' class='mcnTextBlockInner' style='padding-top:9px;'><table align='left' border='0' style='max-width:100%; min-width:100%;' width='100%' class='mcnTextContentContainer'><tbody><tr><td valign='top' class='mcnTextContent' style='padding-top:0; padding-right:18px; padding-bottom:9px; padding-left:18px;'>&nbsp;Qualquer dúvida sobre como proceder com relação a assuntos ligados à sua matricula, click <a href='http:www.google.com'target='_blank'>aqui</a>&nbsp;ou ligue (21) 3176-1462 de segunda à sexta das 12:00hs às 21:00hs e fale com&nbsp;um de nossos funcionários.</td></tr></tbody></table></td></tr></tbody></table></td></tr></table></td></tr></table></td></tr></table></center></body></html>");
		
		int index = builder.indexOf("{{turma}}");
		builder.replace( index, index +9,mensalidade.getMatricula().getNomeModalidade());
		
		index = builder.indexOf("{{dias}}");
		builder.replace( index, index +8,mensalidade.getMatricula().getDiasTurmas());
		
		index = builder.indexOf("{{horario}}");
		builder.replace( index, index +11,mensalidade.getMatricula().getHorarioTurma() );
		
		index = builder.indexOf("{{mesReferencia}}");
		builder.replace( index, index +17, mensalidade.getNomeMes());
		
		index = builder.indexOf("{{valor}}");
		builder.replace( index, index +9,new DecimalFormat("#.##").format(mensalidade.getValorPago()));
		
		index = builder.indexOf("{{aluno}}");
		builder.replace( index, index +9,mensalidade.getMatricula().getNomeAluno());
		
		index = builder.indexOf("{{codTurma}}");
		builder.replace( index, index +12,mensalidade.getMatricula().getCodigoTurma());
		
		index = builder.indexOf("{{data}}");
		builder.replace( index, index +8,sdf.format(new Date()));
		
		index = builder.indexOf("{{titulo}}");
		builder.replace( index, index +10,"Recibo Mensalidade");
		
		System.out.println(builder.toString());
		email.setContent(builder.toString(), "text/html; charset=utf-8");
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
	
	public void enviarEmailPagametoProfessor(List<ComissaoProfessorDO> pagamentos, FluxoCaixaDO fluxo, FuncionarioDO professor) throws Exception{
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
		for (ComissaoProfessorDO pg : pagamentos) {
			builder.append("<tr>");
			builder.append("<td "+getStyleTD(i) + ">"+ pg.getMensalidade().getMatricula().getCodigoTurma() +"</td>");
			builder.append("<td "+getStyleTD(i) + ">"+ pg.getMensalidade().getMatricula().getNomeAluno() +"</td>");
			builder.append("<td "+getStyleTD(i) + "> R$ "+ new DecimalFormat("#.##").format(pg.getMensalidade().getValorPago()) +"</td>");
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

	private String montaEmail(String conteudo) {

		StringBuilder builder = new StringBuilder();
		
		builder.append("<html>");
		builder.append("<head>");
		builder.append("<title>Recibo Centro Cultura Carioca</title>");
		builder.append("</head>");
		builder.append("<body >");
		builder.append("<div>");
		builder.append("<div style='background-color: #f4a460 ;'>");
		builder.append("<div style='text-align: center'>");
		builder.append("<a href=\"https:dancaccc.com.br\">");
		builder.append(
				"<img width='60%' height='25%' src='http:controle-ccc.website/imagens/logo.jpg' >");
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
		builder.append("<div >");
		builder.append(
				"<a href=\"http:www.novorioantigo.com.br\" class=\"novo-rio\" target=\"_blank\"><img style=\"width: 100%;max-width: 513px;max-height: 162px;height: auto;display: table;margin: 34px auto 0 auto;\" src=\"https:dancaccc.com.br/wp-content/themes/site/library/i/logo-casas-03.png\"></a>");
		builder.append("</div>");
		builder.append("</div>");
		builder.append("</body>");
		builder.append("</html>");
		
		return builder.toString();
	}

	private String getMensagem() {
//		String msg = msgEmail.getMesage();
//		if(msg == null)
			return "";
//		return msg;
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

	public MensagemEmailDO getMensagemEmail() {
//		return msgEmail.getMensagemEmail();
		return null;
	}

	public void atualizarMensagem(MensagemEmailDO msg) {
//		msgEmail.save(msg);
	}
}