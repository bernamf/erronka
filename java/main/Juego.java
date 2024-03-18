package main;

import modelo.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import clases.*;
import menu.Visor;

public class Juego {

	private static ModeloCaballero modeloCaballero = new ModeloCaballero();
	public static void run() {
		
		Scanner scan = new Scanner(System.in);
		
		ArrayList<Caballero> caballeros = new ArrayList<Caballero>();
	
		caballeros= modeloCaballero.getCaballeros();
		
		
	
		
		luchar(scan, caballeros, modeloCaballero);
	
	}

	private static void luchar(Scanner scan, ArrayList<Caballero> caballeros, ModeloCaballero modeloCaballero) {
		//Datos jugador
		Caballero jugador;
		int opcionJugador;
		int jugadorLV;
		
		//Datos enemigo
		Caballero enemigo;
		int enemigoLV;
		int datosVictoria;
		
		//Jugador
		Visor.mostrarCaballeros(caballeros);
		Visor.mostrarMensaje("Escoge un caballero");
		opcionJugador = Integer.parseInt(scan.nextLine())-1;
		jugador = caballeros.get(opcionJugador);
		
		Visor.mostrarMensaje("Has escogido ha: \n"+ jugador);
		
		
		//Enemigo
		int valorEntero = (int) (Math.floor(Math.random()*((caballeros.size()-1)-0+1)+0));
		enemigo = caballeros.get(valorEntero);
		
		Visor.mostrarMensaje("Te vas a enfrentar ha: \n"+ enemigo);
		
		
		//Calculos lucha
		jugadorLV= jugador.getFuerza()+jugador.getInteligencia()+jugador.getAgilidad()+jugador.getArma().getAtaque()+jugador.getEscudo().getDefensa();
		enemigoLV= enemigo.getFuerza()+enemigo.getInteligencia()+enemigo.getAgilidad()+enemigo.getArma().getAtaque()+enemigo.getEscudo().getDefensa();
		
		Visor.mostrarMensaje("El poder tuyo es de: "+ jugadorLV);
		Visor.mostrarMensaje("El poder de tu enemigo es de:"+ enemigoLV);
		
		datosVictoria = jugadorLV*(int) (Math.floor(Math.random()*(jugador.getExperiencia()-1+1)+1))-enemigoLV*(int) (Math.floor(Math.random()*(enemigo.getExperiencia()-1+1)+1));
		
		
		//Opciones de final
		if (datosVictoria>10) {
			Visor.mostrarMensaje("El ganador es "+jugador.getNombre());
			jugador.setExperiencia(jugador.getExperiencia()+(int)(Math.random()*(5-1+1))+1);
			enemigo.setExperiencia(enemigo.getExperiencia()+(int)(Math.random()*(10-1+1))+1);
		}else if (datosVictoria<-10) {
			Visor.mostrarMensaje("El ganador es "+enemigo.getNombre());
			enemigo.setExperiencia(enemigo.getExperiencia()+(int)(Math.random()*(5-1+1))+1);
			jugador.setExperiencia(jugador.getExperiencia()+(int)(Math.random()*(10-1+1))+1);
		}else {
			Visor.mostrarMensaje("El combate resulta en empate");
			jugador.setExperiencia(jugador.getExperiencia()+(int)(Math.random()*(15-1+1))+1);
			enemigo.setExperiencia(enemigo.getExperiencia()+(int)(Math.random()*(15-1+1))+1);
		}
		caballeros.set(jugador.getId()-1, jugador);
		caballeros.set(enemigo.getId()-1, enemigo);
		modeloCaballero.modificarCaballeros(caballeros);
	}
	
}
