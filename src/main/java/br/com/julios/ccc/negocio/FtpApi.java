package br.com.julios.ccc.negocio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.componentes.FtpProperties;

@ConfigurationProperties(prefix = "ftp")
@Service
public class FtpApi {

	@Autowired
	FtpProperties ftpProperties;

	private String pathImagemTmp = "/controle-ccc.website/webapps/ROOT/imagens/tmp";
	private String pathImagem = "/controle-ccc.website/webapps/ROOT/imagens";

	public String salvarFotoTmp(String nomeImagem, byte[] file) throws Exception {

		String nome = pathImagemTmp + "/" + nomeImagem;

		FTPClient ftpClient = getFtp();
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

		OutputStream out = ftpClient.storeFileStream(nome);

		out.write(file);

		out.close();

		return nome;
	}

	public boolean moveImage(String nomeImagem) throws Exception {
		FTPClient ftpClient = getFtp();
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		return ftpClient.rename(pathImagemTmp + "/" + nomeImagem, pathImagem + "/" + nomeImagem);
	}

	private FTPClient getFtp() throws IOException {
		FTPClient ftpClient = new FTPClient();
		ftpClient.connect(ftpProperties.getUrl(), 21);
		ftpClient.login(ftpProperties.getUser(), ftpProperties.getPassword());
		ftpClient.enterLocalPassiveMode();
		return ftpClient;
	}
}
