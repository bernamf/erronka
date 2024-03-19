package gertor;

import java.util.ArrayList;
import java.util.Scanner;

import clases.Caballo;
import clases.Escudero;
import menu.Menu;
import menu.Visor;
import modelo.ModeloCaballo;
import modelo.ModeloEscudero;

public class GestorEscudero {

	
public static void run() {
		
		Scanner scan = new Scanner(System.in);
		int opcion = 0;
		ModeloEscudero modeloEscudero = new ModeloEscudero();
		ArrayList<Escudero> escudero = new ArrayList<Escudero>();
		do {
			Menu.menuEscudero();
			opcion= Integer.parseInt(scan.nextLine());
			switch (opcion) {
			case Menu.ver_escuderos:
				escudero = modeloEscudero.getEscuderos();
				Visor.mostrarEscuderos(escudero);
				
				break;
			case Menu.insertar_escudero:
				Escudero es = insertarEscudero();
				modeloEscudero.insertarEscudero(es);
				break;
			case Menu.eliminar_escudero:
				int id =pedirDatosDelete();
				modeloEscudero.eliminarEscudero(id);
				break;
			
			default:
				break;
			}
		} while (opcion!=0);
		Visor.mostrarMensaje("Adios");
		
	}


private static Escudero insertarEscudero() {
	Scanner scan = new Scanner(System.in);
    Visor.mostrarMensaje("Insertar nuevo escudero");
    Visor.mostrarMensaje("Ingrese el nombre del escudero:");
    String nombre = scan.nextLine();
    Visor.mostrarMensaje("Ingrese la experiencia del escudero:");
    int experiencia = Integer.parseInt(scan.nextLine());
    // Suponiendo que el ID del caballero asociado ya se tiene o se selecciona previamente
    Visor.mostrarMensaje("Ingrese el ID del caballero al que pertenece el escudero:");
    int idCaballero = Integer.parseInt(scan.nextLine());

    // Crear un objeto Escudero con los datos proporcionados por el usuario
    Escudero nuevoEscudero = new Escudero(nombre, experiencia, idCaballero);
    return nuevoEscudero;
}


public static int pedirDatosDelete() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Introduce el id del escudero que quieres eliminar");
	int idEscudero= Integer.parseInt(scanner.nextLine());
    
	return idEscudero;
}


}
