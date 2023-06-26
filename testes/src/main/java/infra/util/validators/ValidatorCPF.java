package infra.util.validators;

import java.util.InputMismatchException;

public class ValidatorCPF {

	public static boolean isCPFValido(String cpf) {
		// considera-se erro CPF's formados por uma sequencia de numeros iguais

		if(verificarSeCPFEstaNulo(cpf)){
			return false;
		}
		cpf = cpf.replaceAll("\\.", "");
		cpf = cpf.replaceAll("\\-", "");
		if (verificarSeCPFEstaComPadraoDeNumeracaoInadequado(cpf)) {
			return (false);
		}

		char dig10, dig11;
		int soma, i, posicao, num, peso;

		// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
		try {
			// Calculo do 1o. Digito Verificador
			soma = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				// converte o i-esimo caractere do CPF em um numero:
				// por exemplo, transforma o caractere '0' no inteiro 0
				// (48 eh a posicao de '0' na tabela ASCII)
				num = (int) (cpf.charAt(i) - 48);
				soma = soma + (num * peso);
				peso = peso - 1;
			}

			posicao = 11 - (soma % 11);
			if ((posicao == 10) || (posicao == 11))
				dig10 = '0';
			else
				dig10 = (char) (posicao + 48); // converte no respectivo caractere numerico

			// Calculo do 2o. Digito Verificador
			soma = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (cpf.charAt(i) - 48);
				soma = soma + (num * peso);
				peso = peso - 1;
			}

			posicao = 11 - (soma % 11);
			if ((posicao == 10) || (posicao == 11))
				dig11 = '0';
			else
				dig11 = (char) (posicao + 48);

			// Verifica se os digitos calculados conferem com os digitos informados.
			if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}

	private static boolean verificarSeCPFEstaComPadraoDeNumeracaoInadequado(String cpf) {
		return verificarSeCPFEstaNulo(cpf) || verificarSeCPFEstaComNumerosRepetidos(cpf)
				|| verificaSeCPFEstaComTamanhoDiferenteDoPadrao(cpf);
	}

	private static boolean verificarSeCPFEstaNulo(String cpf) {
		return cpf == null;
	}

	private static boolean verificarSeCPFEstaComNumerosRepetidos(String cpf) {
		return cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
				|| cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
				|| cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
				|| cpf.equals("99999999999");
	}

	private static boolean verificaSeCPFEstaComTamanhoDiferenteDoPadrao(String cpf) {
		return cpf.length() != 11;
	}
}