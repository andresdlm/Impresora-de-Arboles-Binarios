
package arbolgrafico;

import java.util.Stack;

public class Infija{

    private Stack s = new Stack();
	private String strout ="";

	private void acomodar_ecuacion(){
		String numerador = strout.split("/")[1];
		String denominador = strout.split("/")[0];
		numerador = "(" + invertir_cadena(numerador)+ ")";
		denominador = "("+ invertir_cadena(denominador) +")";
		strout = numerador + "/" + denominador;
	}

	private String invertir_cadena(String cadena){
		char[] invertir = cadena.toCharArray();
		String invertido = "";

		for(int i = invertir.length-1; i >= 0; i--){
			invertido = invertido + invertir[i];
		}
		return invertido;
	}

	public String postToIn(String str){

		for (int i = 0; i < str.length(); i++) {
			if (!(str.charAt(i) == '+' || str.charAt(i) == '/' || str.charAt(i) == '*' || str.charAt(i) == '-' || str.charAt(i) == '^')){
				s.push(str.charAt(i));
			}
			else{
				String stemp = s.pop().toString() + str.charAt(i) + s.pop().toString();
				s.push(stemp);

			}
		}
		while (!s.isEmpty()) {
			strout = strout + s.pop();
		}

		if(strout.contains("/")){
			acomodar_ecuacion();
		}
		else{
			strout = "(" + invertir_cadena(strout) + ")";
		}

		return strout;
	}   
        
        
}
