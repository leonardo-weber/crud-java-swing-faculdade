package utils;

import java.time.LocalDate;

import javax.swing.JOptionPane;

public class ValidarCamposFormulario {
	
	public static boolean validacao (String campo) {
		
		System.out.println(campo);
		
		boolean nullField = campo == null;
		boolean emptyField = campo.trim().isEmpty();
		
		boolean valido = !nullField && !emptyField;
		 
		return valido;
		
	}

	public static boolean validacaoData(LocalDate dataNascimento) {
		return dataNascimento != null;
	}
	
	public static boolean validarAno (String ano) {
		return ano.matches("(?:19|20)\\d{2}");
	}
	
	public static boolean validarPlacaCarro (String placa) {
		return placa.matches("^[a-zA-Z]{3}[0-9][A-Za-z0-9][0-9]{2}$");
	}
	
	public static boolean validarSenha (String senha) {
		return senha.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");
	}
	
	public static boolean validarCPF (String cpf) {
		
		boolean cpfInvalido = false;
		
		if (cpf.length() != 11) {
			cpfInvalido = true;
		}

		int soma = 0;
		for (int i = 0; i < 9; i++) {
			int digito = Character.getNumericValue(cpf.charAt(i));
			soma += digito * (10 - i);
		}
		int primeiroDigitoVerificador = 11 - (soma % 11);
		if (primeiroDigitoVerificador > 9) {
			primeiroDigitoVerificador = 0;
		}

		if (Character.getNumericValue(cpf.charAt(9)) != primeiroDigitoVerificador) {
			cpfInvalido = true;
		}
		soma = 0;
		for (int i = 0; i < 10; i++) {
			int digito = Character.getNumericValue(cpf.charAt(i));
			soma += digito * (11 - i);
		}
		int segundoDigitoVerificador = 11 - (soma % 11);
		if (segundoDigitoVerificador > 9) {
			segundoDigitoVerificador = 0;
		}

		if (Character.getNumericValue(cpf.charAt(10)) != segundoDigitoVerificador) {
			cpfInvalido = true;
		}

		return true;
		
	}
	
}
