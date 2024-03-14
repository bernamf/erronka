package gertor;

import java.util.ArrayList;
import java.util.Scanner;

import clases.Arma;
import clases.Caballero;
import menu.Menu;
import menu.Visor;

public class GestorArma {
	
	public static void run() {
		Scanner scan = new Scanner(System.in);
		int opcion = 0;
		ArrayList<Caballero> caballeros = new ArrayList<Caballero>();
		caballeros = GestorCaballero.rellenarCaballeros();
		do {
			Menu.asdf();
			opcion= Integer.parseInt(scan.nextLine());
			switch (opcion) {
			case Menu.MODIFICAR_ARMA:
				//CONECTARSE ALA bbddd
				
				//MOSTRAR LISTADO DE ARMAS
					//COGER ARMAS DE LA bbddd
					//MOSTRAR ARMAS
				
				//EL USUARIO ELIJE EL ARMA
				
				//EL FORMULARIO PARA MODIFICAR LOS ATRIBUROS
				
				//UPDATE EN BBDD
				break;
			case Menu.VER_ARMAS:
				
				break;
			case Menu.HISTORIA:
				
				break;
			
			default:
				break;
			}
		} while (opcion!=0);
		Visor.mostrarMensaje("Adios");
		
	}

	public static ArrayList<Arma> rellenarArma() {
		
		Modelo gestorBBDD = new Modelo();
		return gestorBBDD.getArmas();
	}
	
}
