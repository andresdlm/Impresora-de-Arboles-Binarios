package arbolgrafico;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;

public class Archivo {

    private File archivo;
    String ecuacion;
    public String leer_archivo() throws IOException {
        FileReader fileReader = new FileReader(archivo);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ecuacion = bufferedReader.readLine();
        return ecuacion;
    }

    public void setUbicacion(String ubicacion) {
        archivo = new File(ubicacion);
    }
    
     public int Validar(String n){
             char elem = n.charAt(n.length()-1); 
             char elem2 = n.charAt(0); 
             
             if(elem == '+' || elem == '-' ||elem == '*' ||elem == '/' ||elem == '^' ){
                 return 3;
             }else if (elem2 == '+' || elem2 == '-' ||elem2 == '*' ||elem2 == '/' ||elem2 == '^' ){
                 return 2;
             }else{
                 return 1;
             }
           
           }
}