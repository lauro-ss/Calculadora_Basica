package calculadora;

public class Operadores {
	
	private String[] valoresVetor = new String[3];
	private String auxilia;
	
	public String resultado(String valores, int sinal) {
		valores = valores.replaceAll(",", ".");
		if(sinal == 1) 
			return soma(valores);
		else if(sinal == 2)
			return sub(valores);
		else if(sinal == 3)
			return multi(valores);
		else if(sinal == 4)
			return divisao(valores);
		else if(sinal == 5)
			return porcent(valores);
		else if(sinal == 6)
			return porcentSub(valores);
		return "Erro!";
	}
	
	private String soma(String valores) {
		valoresVetor = valores.split("\\+");
			if(valoresVetor.length == 1)
				return "Erro!";
			auxilia = Double.toString((Double.parseDouble(valoresVetor[0]) + Double.parseDouble(valoresVetor[1]))).replace(".", ",");
			valoresVetor = auxilia.split(",");
			if(!(valoresVetor[1].compareTo("0") < 0))
				return valoresVetor[0];
		return auxilia;
	}
	private String sub(String valores) {
		valoresVetor = valores.split("\\-");
			if(valoresVetor.length == 1)
				return "Erro!";
			if(valoresVetor[0].isEmpty()) {
				valoresVetor[0] += "-" + valoresVetor[1];
				valoresVetor[1] = valoresVetor[2];
			}
			auxilia = Double.toString((Double.parseDouble(valoresVetor[0]) - Double.parseDouble(valoresVetor[1]))).replace(".", ",");
			valoresVetor = auxilia.split(",");
			if(!(valoresVetor[1].compareTo("0") < 0))
				return valoresVetor[0];
		return auxilia;
	}
	private String multi(String valores) {
		valoresVetor = valores.split("\\*");
			if(valoresVetor.length == 1)
				return "Erro!";

			auxilia = Double.toString((Double.parseDouble(valoresVetor[0]) * Double.parseDouble(valoresVetor[1]))).replace(".", ",");
			valoresVetor = auxilia.split(",");
			if(!(valoresVetor[1].compareTo("0") < 0))
				return valoresVetor[0];
		return auxilia;
	}
	private String divisao(String valores) {
		valoresVetor = valores.split("\\÷");
			if(valoresVetor.length == 1)
				return "Erro!";
			if(valoresVetor[1] == "0")
				return "/0 impossível";
			auxilia = Double.toString((Double.parseDouble(valoresVetor[0]) / Double.parseDouble(valoresVetor[1]))).replace(".", ",");
			valoresVetor = auxilia.split(",");
			if(!(valoresVetor[1].compareTo("0") < 0))
				return valoresVetor[0];
		return auxilia;
	}
	private String porcent(String valores) {
		valoresVetor = valores.split("\\%");
			if(valoresVetor.length == 1)
				return "Erro!";
			auxilia = Double.toString(((Double.parseDouble(valoresVetor[0]) / 100) * Double.parseDouble(valoresVetor[1]))).replace(".", ",");
			valoresVetor = auxilia.split(",");

			if(valoresVetor[0].equals("0"))
				return auxilia;
		return valoresVetor[0];
	}
	private String porcentSub(String valores) {
		valoresVetor = valores.split("\\-");
		if(valoresVetor[1].equals("%"))
			return "Erro!";
		
		auxilia = valoresVetor[0];
		valoresVetor = valoresVetor[1].split("\\%");
		
		auxilia = Double.toString(((Double.parseDouble(auxilia)) - Double.parseDouble(valoresVetor[0]) / 100  * Double.parseDouble(auxilia))).replace(".", ",");
		valoresVetor = auxilia.split(",");
		if(valoresVetor[1].equals("0"))
			return valoresVetor[0];
		return auxilia;
	}
	
}
