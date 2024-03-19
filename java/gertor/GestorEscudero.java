package gertor;

import java.util.Scanner;

import menu.Menu;
import menu.Visor;
import modelo.ModeloCaballo;
import modelo.ModeloEscudero;

public class GestorEscudero {

	
public static void run() {
		
		Scanner scan = new Scanner(System.in);
		int opcion = 0;
		ModeloEscudero modeloEscudero = new ModeloEscudero();
		
		do {
			Menu.menuEscudo();
			opcion= Integer.parseInt(scan.nextLine());
			switch (opcion) {
			case Menu.ver_escuderos:
				
				
				break;
			case Menu.insertar_escudero:
				
				
				break;
			case Menu.eliminar_escudero:
				
				
				break;
			
			default:
				break;
			}
		} while (opcion!=0);
		Visor.mostrarMensaje("Adios");
		
	}
}
