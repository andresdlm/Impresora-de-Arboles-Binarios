package arbolgrafico;

public class Nodo {
    
    private int dato;
    private Nodo izq, der;
    private String informacion;
    private Nodo padre;
    private Nodo nodoIzquierdo;
    private Nodo nodoDerecho;

    public Nodo(int dato, Nodo izq, Nodo der) {
        this.dato = dato;
        this.izq = izq;
        this.der = der;
    }
    
    public Nodo(String informacion){
        this.informacion=informacion;
        this.nodoIzquierdo=null;
        this.nodoDerecho=null;
        this.padre=null;    
    }
    
    public  Nodo (Nodo op1, String pop, Nodo op2) {
      this.nodoDerecho=op1;
      this.informacion=pop;
      this.nodoIzquierdo=op2;
      this.padre=null;
      
    }

    //Getters
    public int getDato() {
        return dato;
    }
    
    public Nodo getIzq() {
        return izq;
    }
    public Nodo getDer() {
        return der;
    }

    public String getInformacion() {
        return informacion;
    }

    public Nodo getPadre() {
        return padre;
    }

    public Nodo getNodoIzquierdo() {
        return nodoIzquierdo;
    }

    public Nodo getNodoDerecho() {
        return nodoDerecho;
    }
    
    

    //Setters
    public void setDato(int dato) {
        this.dato = dato;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public void setDer(Nodo der) {
        this.der = der;
    } 

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public void setNodoIzquierdo(Nodo nodoIzquierdo) {
        this.nodoIzquierdo = nodoIzquierdo;
    }

    public void setNodoDerecho(Nodo nodoDerecho) {
        this.nodoDerecho = nodoDerecho;
    }
    

}
