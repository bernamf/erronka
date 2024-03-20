package main;

import modelo.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import clases.*;
import gertor.GestorEscudero;
import menu.Visor;

public class Juego {

	private static ModeloCaballero modeloCaballero = new ModeloCaballero();
	public static void run() {
		
		Scanner scan = new Scanner(System.in);
		
		ArrayList<Caballero> caballeros = new ArrayList<Caballero>();
	
		caballeros= modeloCaballero.getCaballeros();
		
		Visor.mostrarMensaje("Bienvenido que desea hacer \n Opcionº1: Luchar combate aleatorio \n Opcionº2: Entrar en el Torneo");
		int opcionstart = Integer.parseInt(scan.nextLine());
		if (opcionstart==1) {
			luchar(scan, caballeros, modeloCaballero);
		}else if (opcionstart==2) {
			
		}else {
			Visor.mostrarMensaje("Opcion Incorrecta, Redirigiendo");
		}
		
	
	}

	private static void luchar(Scanner scan, ArrayList<Caballero> caballeros, ModeloCaballero modeloCaballero) {
		//Datos jugador
		Caballero jugador;
		int opcionJugador;
		
		//Datos enemigo
		Caballero enemigo;
		
		//Datos Pelea
		int datosVictoria;
		
		
		//Jugador
		Visor.mostrarCaballeros(caballeros);
		Visor.mostrarMensaje("Escoge un caballero");
		opcionJugador = Integer.parseInt(scan.nextLine())-1;
		jugador = caballeros.get(opcionJugador);
		
		Visor.mostrarMensaje("Has escogido ha: \n"+ jugador);
		
		jugador.setEscudero(posibilidadEscudero(jugador));
		
		
		//Enemigo
		int valorEntero = (int) (Math.floor(Math.random()*((caballeros.size()-1)-0+1)+0));
		enemigo = caballeros.get(valorEntero);
		
		Visor.mostrarMensaje("Te vas a enfrentar ha: \n"+ enemigo);
		
		enemigo.setEscudero(posibilidadEscudero(enemigo));
		
		
		//Calculos lucha
		
		Visor.mostrarMensaje("El poder de "+jugador.getNombre()+" es de: "+ jugador.getCaballeroLV());
		Visor.mostrarMensaje("El poder de "+enemigo.getNombre() +"tu enemigo es de:"+ enemigo.getCaballeroLV());
		
		Visor.mostrarMensaje("------------------------------------------------------------------------------------------------");
		
		
		
		datosVictoria = jugador.getCaballeroLVEXP() - enemigo.getCaballeroLVEXP();
		
		Visor.mostrarMensaje("Debido a tu maestria tu poder ha subido: "+ jugador.getCaballeroLVEXP());
		Visor.mostrarMensaje("Debido a la maestria del enemigo su poder ha subido:"+ enemigo.getCaballeroLVEXP());
		
		
		
		//Opciones de final
		if (datosVictoria>25) {
			Visor.mostrarMensaje("El ganador es "+jugador.getNombre());
			jugador.setExperiencia(jugador.getExperiencia()+(int)(Math.random()*(4-1+1))+1);
			enemigo.setExperiencia(enemigo.getExperiencia()+(int)(Math.random()*(15-5+1))+5);
		}else if (datosVictoria<-25) {
			Visor.mostrarMensaje("El ganador es "+enemigo.getNombre());
			enemigo.setExperiencia(enemigo.getExperiencia()+(int)(Math.random()*(4-1+1))+1);
			jugador.setExperiencia(jugador.getExperiencia()+(int)(Math.random()*(15-5+1))+5);
		}else {
			Visor.mostrarMensaje("El combate resulta en empate");
			jugador.setExperiencia(jugador.getExperiencia()+(int)(Math.random()*(20-1+1))+1);
			enemigo.setExperiencia(enemigo.getExperiencia()+(int)(Math.random()*(20-1+1))+1);
		}
		
		//Subir a la BBDD
		caballeros.set(jugador.getId()-1, jugador);
		caballeros.set(enemigo.getId()-1, enemigo);
		modeloCaballero.modificarCaballeros(caballeros);
	}

	private static Escudero posibilidadEscudero(Caballero caballero) {
		
		if (caballero.getEscudero()==null) {
			
			if ((int)(Math.random()*(5-1+1))==5) {
				Visor.mostrarMensaje("------Un civil salta de las gradas y se propone a ser escudero de "+caballero.getNombre()+"--------");
				Escudero escudero = new GestorEscudero().insertarEscuderoPorCaballero(caballero.getId());
				new ModeloEscudero().insertarEscudero(escudero);
				
			}
		}
		return null;
		
	}
	
}
