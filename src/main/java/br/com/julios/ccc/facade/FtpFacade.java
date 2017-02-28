package br.com.julios.ccc.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.negocio.FtpApi;

@Service
public class FtpFacade {
	
	@Autowired
	FtpApi ftp;
	
	public String salvarFoto(byte[] file) throws Exception{
		return ftp.salvarFoto( file);
	}

}
