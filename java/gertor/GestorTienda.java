package gertor;

import java.util.ArrayList;
import java.util.Scanner;

import clases.Arma;
import clases.Escudo;
import menu.Menu;
import menu.Visor;
import modelo.ModeloArma;
import modelo.ModeloEscudo;

public class GestorTienda {

    public static void run() {
    	ArrayList<Escudo> escudos = new ArrayList<Escudo>();
		ModeloEscudo modeloEscudo = new ModeloEscudo();
		ArrayList<Arma> armas = new ArrayList<Arma>();
        ModeloArma modeloArma = new ModeloArma();
        Scanner scan = new Scanner(System.in);
        int opcion;
        do {
            Menu.menuTienda();
            opcion = Integer.parseInt(scan.nextLine());
            switch (opcion) {
                case Menu.COMPRAR_ARMA:
                	armas = modeloArma.getArmas();
                    Visor.mostrarArmas(armas);
                    break;
                case Menu.COMPRAR_ESCUDO:
                	escudos = modeloEscudo.getEscudos();
    				Visor.mostrarEscudos(escudos);
    				break;
                case Menu.SALIR:
                    return; 
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 0);
    }
}
