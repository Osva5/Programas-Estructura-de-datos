package logica;

import igu.Pantalla;        //Importar  la capa de igu 

/**
 *
 * @author Osvaldo
 */

public class Main {

    public static void main(String[] args) {
        
        Pantalla panta = new Pantalla();    //Crear el objeto 
        panta.setTitle("Simulador de Grafos");  //Para darle un titulo a la ventana 
        panta.setLocationRelativeTo(null);      //Primero centramos 
        panta.setVisible(true);         //Luego mostramos 

    }
}

