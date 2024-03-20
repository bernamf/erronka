package gertor;

import java.util.ArrayList;
import java.util.Scanner;

import clases.Arma;
import clases.Caballero;
import clases.Escudo;
import menu.Menu;
import menu.Visor;
import modelo.ModeloArma;
import modelo.ModeloCaballero;
import modelo.ModeloEscudo;

public class GestorTienda {

    public static void run() {
    	ArrayList<Escudo> escudos = new ArrayList<Escudo>();
		ModeloEscudo modeloEscudo = new ModeloEscudo();
		ArrayList<Arma> armas = new ArrayList<Arma>();
        ModeloArma modeloArma = new ModeloArma();
        ModeloCaballero modeloCaballero = new ModeloCaballero();
        ArrayList<Caballero> caballeros = modeloCaballero.getCaballeros();
        
        
        Scanner scan = new Scanner(System.in);
        int opcion;
        int eleccion;
        
        Visor.mostrarCaballeros(caballeros);
        Visor.mostrarMensaje("Escoge el caballero para entrar en la tienda");
        Caballero tienCaballero = caballeros.get(Integer.parseInt(scan.nextLine())-1);
        do {
            Menu.menuTienda();
            Visor.mostrarMensaje("Tienes "+tienCaballero.getExperiencia()+"EXP");
            opcion = Integer.parseInt(scan.nextLine());
            switch (opcion) {
                case Menu.COMPRAR_ARMA:
                	
				comprarArma(modeloArma, scan, tienCaballero);
                    break;
                case Menu.COMPRAR_ESCUDO:
                	
				comprarEscudo(modeloEscudo, scan, tienCaballero);
    				break;
                case Menu.SALIR:
                    return; 
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 0);
    }

	private static void comprarEscudo(ModeloEscudo modeloEscudo, Scanner scan, Caballero tienCaballero) {
		ArrayList<Escudo> escudos;
		int eleccion;
		escudos = modeloEscudo.getEscudos();
		Visor.mostrarEscudos(escudos);
		eleccion= Integer.parseInt(scan.nextLine())-1;
		int exprequired= (int)(escudos.get(eleccion).getDefensa()*0.4);
		if (exprequired<tienCaballero.getExperiencia()) {
			Visor.mostrarMensaje("Tienes EXP suficiente, restando y cambiando el escudo");
			tienCaballero.setExperiencia(tienCaballero.getExperiencia()-exprequired);
			tienCaballero.setEscudo(escudos.get(eleccion));
			
		}else {
			Visor.mostrarMensaje("Tienes "+tienCaballero.getExperiencia()+"EXP, te hace falta:"+escudos.get(eleccion).getDefensa()*0.4+"EXP");
		}
	}

	private static void comprarArma(ModeloArma modeloArma, Scanner scan, Caballero tienCaballero) {
		ArrayList<Arma> armas;
		int eleccion;
		armas = modeloArma.getArmas();
		Visor.mostrarArmasTienda(armas);
		eleccion= Integer.parseInt(scan.nextLine())-1;
		int exprequired= (int)(armas.get(eleccion).getAtaque()*0.4);
		if (exprequired<tienCaballero.getExperiencia()) {
			Visor.mostrarMensaje("Tienes EXP suficiente, restando y cambiando el arma");
			tienCaballero.setExperiencia(tienCaballero.getExperiencia()-exprequired);
			tienCaballero.setArma(armas.get(eleccion));
			
		}else {
			Visor.mostrarMensaje("Tienes "+tienCaballero.getExperiencia()+"EXP, te hace falta:"+armas.get(eleccion).getAtaque()*0.4+"EXP");
		}
	}
}
