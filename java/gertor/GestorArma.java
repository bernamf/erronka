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
            	modeloArma.conectar();
                armas = modeloArma.getArmas();
                Visor.mostrarArmas(armas);
                modeloArma.cerrar();
                break;
            case Menu.insertar_arma:
            	Arma arma =solicitarDatosNuevaArma();
            	modeloArma.conectar();
            	modeloArma.insertarArma(arma);
            	modeloArma.cerrar();
                break;
            case Menu.eliminar_arma:
            	modeloArma.conectar();
            	int id =solicitarIdArmaEliminar();
            	modeloArma.eliminarArma(id);
            	modeloArma.cerrar();
                break;
            
            default:
                break;
            }
        } while (opcion!=0);
        Visor.mostrarMensaje("Adios");
        
    }

    public static Arma solicitarDatosNuevaArma() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese el nombre del arma:");
        String nombre = scanner.nextLine();
        
        System.out.println("Ingrese el nivel de ataque del arma:");
        int ataque = Integer.parseInt(scanner.nextLine());
        
        
        Arma nuevaArma = new Arma(nombre, ataque);
        
        return nuevaArma;
    }
    
    public static int solicitarIdArmaEliminar() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese el ID del arma que desea eliminar:");
        int id = Integer.parseInt(scanner.nextLine());
        
        return id;
    }
}
