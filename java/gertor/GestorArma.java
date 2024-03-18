package gertor;

import java.util.ArrayList;
import java.util.Scanner;

import clases.Arma;

import menu.Menu;
import menu.Visor;
import modelo.ModeloArma;

public class GestorArma  {
    
    public static void run() {
        Scanner scan = new Scanner(System.in);
        int opcion = 0;
        ArrayList<Arma> armas = new ArrayList<Arma>();
        ModeloArma modeloArma = new ModeloArma();
        
        do {
            Menu.menuArma();
            opcion= Integer.parseInt(scan.nextLine());
            switch (opcion) {
            case Menu.Ver_armas:
                armas = modeloArma.getArmas();
                Visor.mostrarArmas(armas);
                break;
            case Menu.modificar_arma:
                
                break;
            case Menu.eliminar_arma:
                
                break;
            
            default:
                break;
            }
        } while (opcion!=0);
        Visor.mostrarMensaje("Adios");
        
    }

  
}
