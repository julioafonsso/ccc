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
		String nomeImagem = "imagens/" + new Long(new Date().getTime()).toString()
				+ new Double(Math.random() * 10000).intValue() + ".jpg";

		if (!(formato.toUpperCase().equals("JPG") || formato.toUpperCase().equals("JPEG")))
			throw new Exception("Formato da imagem invalido! ");

		FTPClient ftpClient = getFtp();
		String nome = ftpProperties.getPath() + "/" + nomeImagem;
		OutputStream out = ftpClient.storeFileStream(nome);

		out.write(diminuirImagem(file));

		out.close();

		return nomeImagem;
	}

	private FTPClient getFtp() throws IOException {
		FTPClient ftpClient = new FTPClient();
		ftpClient.connect(ftpProperties.getUrl(), 21);
		ftpClient.login(ftpProperties.getUser(), ftpProperties.getPassword());
		ftpClient.enterLocalPassiveMode();
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