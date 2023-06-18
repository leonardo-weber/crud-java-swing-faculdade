package utils;

public class ValidarCamposFormulario {
	
	public static boolean validacao (String campo) {
		
		boolean nullField = campo == null;
		boolean emptyField = campo.trim().isEmpty();
		
		boolean valido = !nullField && !emptyField;
		 
		return valido;
		
	}

}
