package br.com.julios.ccc.componentes;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FtpApi {

	@Autowired
	FtpProperties ftpProperties;

	public String salvarFoto(byte[] file, String formato) throws Exception {
		String nomeImagem =  new Long(new Date().getTime()).toString()
				+ new Double(Math.random() * 10000).intValue() + ".jpg";
		return 	this.salvarFoto(file, formato, nomeImagem,true);
		
	}
	
	public String salvarFotoEmail(byte[] file, String formato) throws Exception {
		String nomeImagem =  "email/" + new Long(new Date().getTime()).toString()
				+ new Double(Math.random() * 10000).intValue() + ".jpg";
		return 	this.salvarFoto(file, formato, nomeImagem,false);
		
	}
	
	
	private String salvarFoto(byte[] file, String formato, String nomeFoto, boolean diminuir) throws Exception {
		String nomeImagem = "imagens/" + nomeFoto;

		if (!(formato.toUpperCase().equals("JPG") || formato.toUpperCase().equals("JPEG")))
			throw new Exception("Formato da imagem invalido! ");

		FTPClient ftpClient = getFtp();
		String nome = ftpProperties.getPath() + "/" + nomeImagem;
		System.out.println(ftpClient.isConnected());
		OutputStream out = ftpClient.storeFileStream(nome);

		if(diminuir)
			out.write(diminuirImagem(file));
		else 
			out.write(file);

		out.close();
		
		ftpClient.logout();
		return nomeImagem;
	}


	private FTPClient getFtp() throws IOException {
		FTPClient ftpClient = new FTPClient();
		ftpClient.connect(ftpProperties.getUrl(), 21);
		ftpClient.login(ftpProperties.getUser(), ftpProperties.getPassword());
		ftpClient.enterLocalPassiveMode();
		
//		FTPClient ftpClient = new FTPClient();
//		ftpClient.connect("ftp.controle-danca-ccc.website", 21);
//		ftpClient.login("controlecc", "Isnard@333");
//		ftpClient.enterLocalActiveMode();
		return ftpClient;
	}

	private static final int IMG_WIDTH = 800;
	private static final int IMG_HEIGHT = 800;
	
	private byte[] diminuirImagem(byte[] imagemData) {

		ByteArrayOutputStream baOut = new ByteArrayOutputStream();
		try {

			ByteArrayInputStream baIn = new ByteArrayInputStream(imagemData);
			
			BufferedImage originalImage = ImageIO.read(baIn);
			
			
			int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

			BufferedImage resizeImageJpg = resizeImage(originalImage, type);
			
			
			
			ImageIO.write(resizeImageJpg, "jpg", baOut);
			
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return baOut.toByteArray();
	}

	private static BufferedImage resizeImage(BufferedImage originalImage, int type) {
		BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
		g.dispose();

		return resizedImage;
	}

}