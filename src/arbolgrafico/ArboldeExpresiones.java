package arbolgrafico;

import java.util.*;
import javax.swing.JPanel;
import java.util.ArrayList;


public class ArboldeExpresiones {  //Genera los árboles a partir de la expresi´´n 
    Stack < Nodo > pOperandos = new Stack < Nodo> ();
    Stack < String > pOperadores = new Stack < String > ();
   
                 
    final String blanco;           // Cadena de espacios en blanco
    final String operadores;       // Cadena con operadores para expresiones
    private Nodo raiz;
    private Object miArbol;

   //Constructor por omisión
    public ArboldeExpresiones() {    
	blanco = " \t";
	operadores = ")+-*/%^(";  //acomodados por precedencia;
    }

    public Nodo getRaiz() {
        return this.raiz;
    }

    public void setRaiz(Nodo r) {
        this.raiz = r;
    }
    
    public boolean construir (String con){
    construirArbol(con);
    return true;
    }
    
    public Nodo construirArbol(String expresion) {
       	StringTokenizer tokenizer;
	String token;
	
	tokenizer = new StringTokenizer(expresion, blanco+operadores, true);
	while (tokenizer.hasMoreTokens()) {
	    token = tokenizer.nextToken();
	    if (blanco.indexOf(token) >= 0) 
		;               // Es un espacio en blanco, se ignora
	    else if (operadores.indexOf(token) < 0) {
		                // Es operando y lo guarda como nodo del arbol
                                Nodo a;
		pOperandos.push( new Nodo(token));
	    } else if(token.equals(")")) { // Saca elementos hasta encontrar (
		while (!pOperadores.empty() && !pOperadores.peek().equals("(")) {
		    guardarSubArbol();
		}
		pOperadores.pop();  // Saca el parentesis izquierdo
	    } else {
		if (!token.equals("(") && !pOperadores.empty()) {
		           //operador diferente de cualquier parentesis
		    String op = (String) pOperadores.peek();
		    while (!op.equals("(") && !pOperadores.empty()
			   && operadores.indexOf(op) >= operadores.indexOf(token)) {
			guardarSubArbol();
			if (!pOperadores.empty()) 
			    op = (String)pOperadores.peek();
		    }
		}
		pOperadores.push(token);  //Guarda el operador
	    }
	}
	//Sacar todo lo que queda
	raiz = (Nodo)pOperandos.peek();
	while (!pOperadores.empty()) {
	    if (pOperadores.peek().equals("(")) {
		pOperadores.pop();
	    } else {
	    guardarSubArbol();
	    raiz = (Nodo) pOperandos.peek() ;
	    }
	}
	return raiz;
    }

    //Almacena pila en un subárbol
    private void guardarSubArbol() {
	Nodo op2 = (Nodo) pOperandos.pop();
	Nodo op1 = (Nodo)pOperandos.pop();
	pOperandos.push( new Nodo(op2, pOperadores.pop(), op1));
    }

    
    public JPanel getdibujo() {
       return new ArbolExpresionGrafico(this);
    }
    
    
    //Simulador
    public boolean insertar(String dato) {
      return (this.construir(dato));
    }

    public JPanel getDibujo() {
        return this.getdibujo();
    }

}

