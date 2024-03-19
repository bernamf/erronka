package gertor;

import java.util.ArrayList;
import java.util.Scanner;

import clases.Caballo;
import clases.Escudo;
import menu.Menu;
import menu.Visor;
import modelo.ModeloCaballo;


public class GestorCaballo {

public static void run() {
		
		Scanner scan = new Scanner(System.in);
		int opcion = 0;
		ModeloCaballo modeloCaballo = new ModeloCaballo();
		ArrayList<Caballo> caballo = new ArrayList<Caballo>();
		do {
			Menu.menuCaballo();
			opcion= Integer.parseInt(scan.nextLine());
			switch (opcion) {
			case Menu.ver_caballos:
				caballo = modeloCaballo.getCaballos();
				Visor.mostrarCaballos(caballo);
	
				break;
			case Menu.insertar_caballo:
				Caballo caballos=pedirDatosInsert();
				modeloCaballo.insertarCaballo(caballos);
				break;
			case Menu.eliminar_caballo:
				int id = pedirDatosDelete();
				modeloCaballo.eliminarCaballo(id);
				break;
			
			default:
				break;
			}
		} while (opcion!=0);
		Visor.mostrarMensaje("Adios");
		
	}

public static Caballo pedirDatosInsert() {
	Scanner scanner = new Scanner(System.in);
	 System.out.println("Insertar nuevo caballo:");
     System.out.print("Nombre: ");
     String nombre = scanner.nextLine();
     System.out.print("Velocidad máxima: ");
     int velocidadMaxima =Integer.parseInt(scanner.nextLine());
     System.out.print("Resistencia: ");
     int resistencia = Integer.parseInt(scanner.nextLine());
     System.out.print("ID del caballero al que pertenece: ");
     int idCaballero = Integer.parseInt(scanner.nextLine());
     
     Caballo nuevoCaballo = new Caballo(nombre, velocidadMaxima, resistencia, idCaballero);
	return nuevoCaballo;
}

public static int pedirDatosDelete() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Introduce el id del caballo que quieres eliminar");
	int idCaballo = Integer.parseInt(scanner.nextLine());
    
	return idCaballo;
}


}
