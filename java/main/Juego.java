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
		int jugadorLVEXP;
		
		//Datos enemigo
		Caballero enemigo;
		int enemigoLV;
		int datosVictoria;
		int enemigoLVEXP;
		
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
		jugadorLV= (int) ((jugador.getFuerza()+jugador.getInteligencia()+jugador.getAgilidad())*4+(jugador.getArma().getAtaque()+jugador.getEscudo().getDefensa())*0.4);
		enemigoLV= (int) ((enemigo.getFuerza()+enemigo.getInteligencia()+enemigo.getAgilidad())*4+(enemigo.getArma().getAtaque()+enemigo.getEscudo().getDefensa())*0.4);
		
		Visor.mostrarMensaje("El poder de "+jugador.getNombre()+" es de: "+ jugadorLV);
		Visor.mostrarMensaje("El poder de "+enemigo.getNombre() +"tu enemigo es de:"+ enemigoLV);
		
		Visor.mostrarMensaje("------------------------------------------------------------------------------------------------");
		
		jugadorLVEXP=(int) (jugadorLV*(1+((Math.floor(Math.random()*(jugador.getExperiencia()-1+1)+1)))*0.02));
		enemigoLVEXP=(int) (enemigoLV*(1+((Math.floor(Math.random()*(enemigo.getExperiencia()-1+1)+1)))*0.02));
		datosVictoria = jugadorLVEXP - enemigoLVEXP;
		
		Visor.mostrarMensaje("Debido a tu maestria tu poder ha subido: "+ jugadorLVEXP);
		Visor.mostrarMensaje("Debido a la maestria del enemigo su poder ha subido:"+ enemigoLVEXP);
		
		
		
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
	
}
