package br.com.julios.ccc.componentes;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.stereotype.Component;

@Component
public class ExceptionValidacoes {

	
	public String getMessage(Set<ConstraintViolation<?>> erros){
		StringBuffer sb = new StringBuffer();
		for (ConstraintViolation<?> erro : erros) {
			sb.append(erro.getMessage() + "\n");
		}
		return sb.toString();
	}
}
