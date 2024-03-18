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
			case Menu.insertar_escudo:
				Escudo escudo = solicitarDatosNuevoEscudo();
				modeloEscudo.insertarEscudo(escudo);
				break;
			case Menu.eliminar_escudo:
				int id = solicitarIdEscudoEliminar();
				modeloEscudo.eliminarEscudo(id);
				break;
			
			default:
				break;
			}
		} while (opcion!=0);
		Visor.mostrarMensaje("Adios");
		
	}
	
	public static Escudo solicitarDatosNuevoEscudo() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese el nombre del escudo:");
        String nombre = scanner.nextLine();
        
        System.out.println("Ingrese el nivel de defensa del escudo:");
        int defensa = Integer.parseInt(scanner.nextLine());
        
        
        Escudo nuevoEscudo = new Escudo(nombre, defensa);
        
        return nuevoEscudo;
    }

    public static int solicitarIdEscudoEliminar() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese el ID del escudo que desea eliminar:");
        int id = Integer.parseInt(scanner.nextLine());
        
        return id;
    }

	
}
