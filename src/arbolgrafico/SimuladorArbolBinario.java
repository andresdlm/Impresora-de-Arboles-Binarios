package arbolgrafico;

import java.util.ArrayList;
import javax.swing.JPanel;


public class SimuladorArbolBinario {

     ArbodeExpresiones miArbol = new ArbodeExpresiones();

    public SimuladorArbolBinario() {
    }

    public boolean insertar(String dato) {
      return (this.miArbol.contruir(dato));
    }

    public JPanel getDibujo() {
        return this.miArbol.getdibujo();
    }

}
