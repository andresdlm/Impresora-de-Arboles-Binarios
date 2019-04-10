
package arbolgrafico;

public class Polaca {

    public Polaca() {
    }

 public  String Infijo2PrefijoTxt(String infijo){
		Pila p1 = Infijo2Prefijo(infijo);
		String text = "";
		while (p1.i > 0)
			text = text + p1.pop();            
        
		return text;
	}
     
     public  Pila Infijo2Prefijo(String infijo) {
                infijo = '(' + infijo;
		int tamaño = infijo.length();
		Pila PilaDefinitiva = new Pila(tamaño);
		Pila PilaTemp = new Pila(tamaño);
		PilaTemp.push(')'); // Agregamos a la pila temporal un &#8216;(&#8216;<br />
		for (int i = tamaño-1; i >= 0; i--) {
			char caracter = infijo.charAt(i);
			switch (caracter) {
			case ')':
				PilaTemp.push(caracter);
				break;
			case '+':case '-':case '^':case '*':case '/':
				while (Jerarquia(caracter) < Jerarquia(PilaTemp.nextPop()))
					PilaDefinitiva.push(PilaTemp.pop());
				PilaTemp.push(caracter);
				break;
			case '(':
				while (PilaTemp.nextPop() != ')')
					PilaDefinitiva.push(PilaTemp.pop());
				PilaTemp.pop();
				break;
			default:
				PilaDefinitiva.push(caracter);
			}
		}
		return PilaDefinitiva;
	}
     
   public  int Jerarquia(char elemento) {
		int res = 0;
		switch (elemento) {
		case '(':
			res = 5; break;
		case '^':
			res = 4; break;
		case '*': case '/':
			res = 3; break;
		case '+': case '-':
			res = 2; break;
		case ')':
			res = 1; break;
		}
		return res;
	}

   
    
}
