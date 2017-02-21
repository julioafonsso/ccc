package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import br.com.julios.ccc.facade.FileFacade;


@Controller
@ResponseBody
@RequestMapping("/")
public class FtpController {

	@Autowired
	FileFacade fileFacade;
	
	@RequestMapping(value = "foto/{id}", method = RequestMethod.POST)
	public String cadastrarFoto(@PathVariable("id") Long idAluno, @RequestBody MultipartFile file) throws Exception {
		return fileFacade.salvarFotoTmp(idAluno.toString(), file.getBytes());
	}
	
}
