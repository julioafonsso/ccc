package br.com.julios.ccc.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.negocio.FtpApi;

@Service
public class FileFacade {
	
	@Autowired
	FtpApi ftp;
	
	public String salvarFotoTmp(String nomeFoto, byte[] file) throws Exception{
		return ftp.salvarFotoTmp(nomeFoto, file);
	}

}
