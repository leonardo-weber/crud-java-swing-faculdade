package utils;

import java.time.LocalDate;

public class ValidarCamposFormulario {
	
	public static boolean validacao (String campo) {
		
		boolean nullField = campo == null;
		boolean emptyField = campo.trim().isEmpty();
		
		boolean valido = !nullField && !emptyField;
		 
		return valido;
		
	}

	public static boolean validacaoData(LocalDate dataNascimento) {
		return dataNascimento != null;
	}
}
