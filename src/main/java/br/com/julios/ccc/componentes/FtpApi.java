package br.com.julios.ccc.componentes;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FtpApi {

	@Autowired
	FtpProperties ftpProperties;

	public String salvarFoto(byte[] file, String formato) throws Exception {
		String nomeImagem = "imagens/" + new Long(new Date().getTime()).toString()
				+ new Double(Math.random() * 10000).intValue() + ".jpg" ;

		if (!(formato.toUpperCase().equals("JPG") || formato.toUpperCase().equals("JPEG")))
			throw new Exception("Formato da imagem invalido! ");

		FTPClient ftpClient = getFtp();
		String nome = ftpProperties.getPath() + "/" + nomeImagem;
		OutputStream out = ftpClient.storeFileStream(nome);

		out.write(file);

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
}