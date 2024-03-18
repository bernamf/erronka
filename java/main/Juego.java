package main;

import modelo.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import clases.*;
import menu.Visor;

public class Juego {

	
	public static void run() {
		Scanner scan = new Scanner(System.in);
		ModeloCaballero modeloCaballero = new ModeloCaballero();
		ArrayList<Caballero> caballeros = new ArrayList<Caballero>();
		caballeros= modeloCaballero.getCaballeros();
		
	
		
		luchar(scan, caballeros);
	}

	private static void luchar(Scanner scan, ArrayList<Caballero> caballeros) {
		//Datos jugador
		Caballero jugador;
		int opcionJugador;
		int jugadorLV;
		
		//Datos enemigo
		Caballero enemigo;
		int enemigoLV;
		int datosVictoria;
		
		
		Visor.mostrarCaballeros(caballeros);
		Visor.mostrarMensaje("Escoge un caballero");
		opcionJugador = Integer.parseInt(scan.nextLine())-1;
		jugador = caballeros.get(opcionJugador);
		
		
		int valorEntero = (int) (Math.floor(Math.random()*(caballeros.size()-0+1)+0));
		enemigo = caballeros.get(valorEntero);
		
		jugadorLV= jugador.getFuerza()+jugador.getInteligencia()+jugador.getAgilidad()+jugador.getArma().getAtaque()+jugador.getEscudo().getDefensa();
		enemigoLV= enemigo.getFuerza()+enemigo.getInteligencia()+enemigo.getAgilidad()+enemigo.getArma().getAtaque()+enemigo.getEscudo().getDefensa();
		
		datosVictoria = jugadorLV*jugador.getExperiencia()-enemigoLV*enemigo.getExperiencia();
		
		if (datosVictoria>10) {
			Visor.mostrarMensaje("El ganador es "+jugador.getNombre());
			
		}else if (datosVictoria<-10) {
			Visor.mostrarMensaje("El ganador es "+enemigo.getNombre());
			
		}else {
			Visor.mostrarMensaje("El combate resulta en empate");
		}
	}
	
}
