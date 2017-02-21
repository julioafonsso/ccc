package br.com.julios.ccc.componentes.cpf;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CPFValidador implements ConstraintValidator<CPF, String> {

	private boolean validaDigito(String cpf) {
		String digitos = getDigitoVerificador(cpf, 1) + getDigitoVerificador(cpf, 2);
		return cpf.endsWith(digitos);
	}

	private String getDigitoVerificador(String cpf, int numDigito) {
		int peso = 0;
		if (numDigito == 1) {
			peso = 10;
		} else if (numDigito == 2) {
			peso = 11;
		}

		int soma = 0;
		for (int i = 0; i < cpf.length(); i++) {
			if (peso < 2)
				break;
			soma += Integer.valueOf(cpf.substring(i, i + 1)).intValue() * peso;
			peso--;
		}

		int resto = soma % 11;
		if (11 - resto > 9)
			return "0";
		return String.valueOf(11 - resto);
	}

	@Override
	public void initialize(CPF constraintAnnotation) {
	}

	@Override
	public boolean isValid(String cpf, ConstraintValidatorContext context) {
		String cpfSomenteNumeros = cpf.replaceAll("[^0-9]", "");
		if (cpfSomenteNumeros.length() != 11)
			return false;
		return validaDigito(cpfSomenteNumeros);
	}

}
