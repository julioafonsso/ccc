package br.com.julios.ccc.componentes;

public class CPF {

	private static boolean validaDigito(String cpf) {
		String digitos = getDigitoVerificador(cpf, 1) + getDigitoVerificador(cpf, 2);
		return cpf.endsWith(digitos);
	}

	private static String getDigitoVerificador(String cpf, int numDigito) {
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


	private static void isValid(String cpf) throws Exception {
		if (cpf.length() != 11 || !validaDigito(cpf))
				throw new Exception("CPF Invalido");
	}
	
	public static String getSemFormatacao(String cpf) throws Exception
	{
		String cpfTMP = "";
		if(cpf != null)
		{
			cpfTMP = cpf.replaceAll("[^0-9]", "");
			isValid(cpfTMP);
		}
		return cpfTMP;
		
	}
	
}
