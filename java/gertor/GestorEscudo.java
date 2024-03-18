package gertor;

import java.util.ArrayList;
import java.util.Scanner;

import clases.Arma;
import clases.Escudo;
import conector.Conectar;
import menu.Menu;
import menu.Visor;
import modelo.ModeloArma;
import modelo.ModeloEscudo;

public class GestorEscudo extends Conectar {

	public static void run() {
		
		Scanner scan = new Scanner(System.in);
		int opcion = 0;
		ArrayList<Escudo> escudos = new ArrayList<Escudo>();
		ModeloEscudo modeloEscudo = new ModeloEscudo();
		
		do {
			Menu.menuEscudo();
			opcion= Integer.parseInt(scan.nextLine());
			switch (opcion) {
			case Menu.ver_escudos:
				escudos = modeloEscudo.getEscudos();
				Visor.mostrarEscudos(escudos);
				break;
			case Menu.modificar_escudo:
				
				break;
			case Menu.eliminar_escudo:
				
				break;
			
			default:
				break;
			}
		} while (opcion!=0);
		Visor.mostrarMensaje("Adios");
		
	}

	
}
