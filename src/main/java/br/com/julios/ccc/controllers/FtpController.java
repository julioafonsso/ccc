package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import br.com.julios.ccc.facade.FtpFacade;


@Controller
@ResponseBody
@RequestMapping("/ftp")
public class FtpController {

	@Autowired
	FtpFacade fileFacade;
	
	@RequestMapping(value = "foto/", method = RequestMethod.POST)
	public String cadastrarFoto(@RequestBody MultipartFile file) throws Exception {
		return fileFacade.salvarFoto(file.getBytes());
	}
	
}
