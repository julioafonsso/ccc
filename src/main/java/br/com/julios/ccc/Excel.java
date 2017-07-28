package br.com.julios.ccc;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import br.com.julios.ccc.infra.bd.model.AlunoDO;
import br.com.julios.ccc.infra.bd.model.MesReferenciaDO;
import br.com.julios.ccc.infra.bd.model.TurmaColetivaDO;
import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableImage;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Excel {
	
	
	
	public byte[] getLista(TurmaColetivaDO turma, MesReferenciaDO mesRef) throws Exception {
		
		WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);
		WritableFont wfNegrito = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
		
		WritableCellFormat cfSemBorda = new WritableCellFormat(wf);
		cfSemBorda.setWrap(true);
		
		WritableCellFormat cfNegritoSemBorda = new WritableCellFormat(wfNegrito);
		cfSemBorda.setWrap(true);
		
		WritableCellFormat cfComBorda = new WritableCellFormat(wf);
		cfComBorda.setWrap(true);
		cfComBorda.setBorder(Border.ALL, BorderLineStyle.THIN);

		WritableCellFormat cfNegritoComBorda = new WritableCellFormat(wfNegrito);
		cfNegritoComBorda.setWrap(true);
		cfNegritoComBorda.setBorder(Border.ALL, BorderLineStyle.THIN);
		
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		WorkbookSettings ws = new WorkbookSettings();
		ws.setLocale(new Locale("en", "EN"));
		WritableWorkbook workbook = Workbook.createWorkbook(bos, ws);
		WritableSheet s = workbook.createSheet("Folha1", 0);
		
		s.setColumnView(0, 100);
		s.setColumnView(1, 20);
		
		
		// CABECALHO
		
		Label chamadaAlunos = new Label(0, 0, "CHAMADA ALUNOS", cfSemBorda);
		s.addCell(chamadaAlunos);

		Label codTurma = new Label(0, 1, "TURMA : " + turma.getCodigo() + " " + turma.getNomeModalidade(), cfSemBorda);
		s.addCell(codTurma);
		
		Label professores = new Label(0, 2, "PROFESORES: " + turma.getNomeProfessor1() + " - " + turma.getNomeProfessor2(), cfSemBorda);
		s.addCell(professores);
		
		Label mes = new Label(0, 3, mesRef.getNomeMes() + " " + mesRef.getAno(), cfNegritoSemBorda);
		s.addCell(mes);
		
		Label homens = new Label(0, 5, "HOMENS: " + turma.getQtdAlunos(), cfSemBorda);
		s.addCell(homens);

		
		Label mulheres = new Label(0, 6, "MULHERES: " + turma.getQtdAlunas(), cfSemBorda);
		s.addCell(mulheres);
		
		// Lista
		
		
		Label nome = new Label(0, 8, "Nome: ", cfNegritoComBorda);
		s.addCell(nome);
		
		Label telefone = new Label(1, 8, "Telefone: ", cfNegritoComBorda);
		s.addCell(telefone);
		
		List<Date> dias = turma.getDiasAulaMes(mesRef);
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		int count = 2;
		for (Date date : dias) {
			Label dia = new Label(count++, 8, sdf.format(date) , cfNegritoComBorda);
			s.addCell(dia);
		}

		List<AlunoDO> alunos = turma.getAlunos();
		count = 9;
		for (AlunoDO alunoDO : alunos) {
			nome = new Label(0, count, alunoDO.getNome(), cfComBorda);
			s.addCell(nome);
			
			telefone = new Label(1, count, alunoDO.getTelefone(), cfComBorda);
			s.addCell(telefone);
			count ++;
		}
		
		
		// Logo
		
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("imagem.png").getFile());
		WritableImage wi = new WritableImage(10, 0, 3, 5, file);
		s.addImage(wi);	
		
		
		
		workbook.write();
		workbook.close();
		return bos.toByteArray();
		
		
	}
}