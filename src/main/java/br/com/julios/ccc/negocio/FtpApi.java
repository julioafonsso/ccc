package br.com.julios.ccc.negocio;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.componentes.FtpProperties;

@Service
public class FtpApi {

	@Autowired
	FtpProperties ftpProperties;

	

	public String salvarFoto(byte[] file) throws Exception {
		String nomeImagem = "imagens/" + new Long(new Date().getTime()).toString() + new Double (Math.random() * 10000).intValue();
		

		FTPClient ftpClient = getFtp();
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		String nome = ftpProperties.getPath() + "/" + nomeImagem;
		System.out.println("vou salvar a imagem no diretorio " + nome);
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
