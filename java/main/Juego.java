package main;

import modelo.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import clases.*;
import gertor.GestorEscudero;
import menu.Visor;

public class Juego {

	private static final int CABALLERO_2 = 2;
	private static final int CABALLERO_1 = 1;
	private static ModeloCaballero modeloCaballero = new ModeloCaballero();

	public static void run() {

		Scanner scan = new Scanner(System.in);

		ArrayList<Caballero> caballeros = new ArrayList<Caballero>();

		caballeros = modeloCaballero.getCaballeros();

		Visor.mostrarMensaje(
				"Bienvenido que desea hacer \n Opcionº1: Luchar combate aleatorio \n Opcionº2: Entrar en el Torneo");
		int opcionstart = Integer.parseInt(scan.nextLine());
		if (opcionstart == 1) {
			luchaAleatoria(scan, caballeros, modeloCaballero);
		} else if (opcionstart == 2) {
			torneo(scan, caballeros, modeloCaballero);
		} else {
			Visor.mostrarMensaje("Opcion Incorrecta, Redirigiendo");
		}

	}

	private static void torneo(Scanner scan, ArrayList<Caballero> caballeros, ModeloCaballero modeloCaballero) {
		ArrayList<Integer> idparticipantesFuera = new ArrayList<Integer>();
		ArrayList<Caballero> participantesTorneo = new ArrayList<Caballero>();
		int ganador;
		Visor.mostrarMensaje("Bienvenidos Participantes de todos los reinos y lugares");

		participantesTorneo.add(seleccionarJugador(scan, caballeros));

		for (int i = 0; i < 6; i++) {
			participantesTorneo.add(generarEnemigo(caballeros));
		}

		Visor.mostrarMensaje(" Demos paso a nuestros temibles PARTICIPANTESSSSS");
		Visor.mostrarCaballeros(participantesTorneo);
		try {
			Thread.sleep(12000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Primera ronda, Cuatro combates de 8 Caballeros
		for (int i = 0; i < 3; i++) {
			Visor.mostrarMensaje("La ronda Comienza");
			// conbate el 1 contra
			ganador = peleaDeCaballeros(caballeros, modeloCaballero, participantesTorneo.get(i),
					participantesTorneo.get(i + 4));

			if (ganador == CABALLERO_1) {
				Visor.mostrarMensaje(participantesTorneo.get(i) + " pasa a la siguiente ronda");
				idparticipantesFuera.add(i + 4);
			} else if (ganador == CABALLERO_2) {
				Visor.mostrarMensaje(participantesTorneo.get(i + 4) + " pasa a la siguiente ronda");
				idparticipantesFuera.add(i);
			} else {// ENBPATE
				Visor.mostrarMensaje("Debido a terminar en empate, la moneda decidira su destino");
				try {
					Thread.sleep(4500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if ((Math.random() * (1 - 0 + 1) + 0) == 1) {
					Visor.mostrarMensaje("Cara, gana " + participantesTorneo.get(i).getNombre());
					idparticipantesFuera.add(i + 4);
				} else {
					Visor.mostrarMensaje("Cruz, gana " + participantesTorneo.get(i + 4).getNombre());
					idparticipantesFuera.add(i);
				}
			}
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// elimianr de la lista de participantes
		for (Integer integer : idparticipantesFuera) {
			participantesTorneo.remove(integer);
		}
		idparticipantesFuera.clear();

		for (int i = 0; i < 1; i++) {
			Visor.mostrarMensaje("La ronda Semifinal-Comienza");
			ganador = peleaDeCaballeros(caballeros, modeloCaballero, participantesTorneo.get(i),
					participantesTorneo.get(i + 2));
			if (ganador == 1) {
				Visor.mostrarMensaje(participantesTorneo.get(i) + " pasa a la siguiente ronda");
				idparticipantesFuera.add(i + 4);
			} else if (ganador == 2) {
				Visor.mostrarMensaje(participantesTorneo.get(i + 2) + " pasa a la siguiente ronda");
				idparticipantesFuera.add(i);
			} else {
				Visor.mostrarMensaje("Debido a terminar en empate, la moneda decidira su destino");
				if ((Math.random() * (1 - 0 + 1) + 0) == 1) {
					Visor.mostrarMensaje("Cara, gana " + participantesTorneo.get(i).getNombre());
					idparticipantesFuera.add(i + 2);
				} else {
					Visor.mostrarMensaje("Cruz, gana " + participantesTorneo.get(i + 2).getNombre());
					idparticipantesFuera.add(i);
				}
			}
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (Integer integer : idparticipantesFuera) {
			participantesTorneo.remove(integer);
		}

		Visor.mostrarMensaje("La GRAN FINAL Comienza");
		if (peleaDeCaballeros(caballeros, modeloCaballero, participantesTorneo.get(0),
				participantesTorneo.get(1)) == 1) {
			Visor.mostrarMensaje("--------------------------------------------------------------");
			Visor.mostrarMensaje(
					participantesTorneo.get(0).getNombre() + " SE CONVIERTE EN EL GLORIOSO GANADOR DEL TORNEO");
			Visor.mostrarMensaje("--------------------------------------------------------------");

		} else if (peleaDeCaballeros(caballeros, modeloCaballero, participantesTorneo.get(0),
				participantesTorneo.get(1)) == 2) {
			Visor.mostrarMensaje("--------------------------------------------------------------");
			Visor.mostrarMensaje(
					participantesTorneo.get(1).getNombre() + " SE CONVIERTE EN EL GLORIOSO GANADOR DEL TORNEO");
			Visor.mostrarMensaje("--------------------------------------------------------------");
		} else {
			Visor.mostrarMensaje("Debido a terminar en empate, la moneda decidira su destino");
			if ((Math.random() * (1 - 0 + 1) + 0) == 1) {
				Visor.mostrarMensaje("Cara, gana " + participantesTorneo.get(0).getNombre());

			} else {
				Visor.mostrarMensaje("Cruz, gana " + participantesTorneo.get(1).getNombre());

			}
		}

	}

	private static void luchaAleatoria(Scanner scan, ArrayList<Caballero> caballeros, ModeloCaballero modeloCaballero) {
		// Datos jugador
		Caballero jugador;
		int opcionJugador;

		// Datos enemigo
		Caballero enemigo;

		// Datos Pelea
		int datosVictoria;

		// Jugador
		jugador = seleccionarJugador(scan, caballeros);

		
		// Enemigo
		enemigo = generarEnemigo(caballeros);

		Visor.mostrarMensaje("Te vas a enfrentar ha: \n" + enemigo);

		

		peleaDeCaballeros(caballeros, modeloCaballero, jugador, enemigo);
	}

	private static Caballero generarEnemigo(ArrayList<Caballero> caballeros) {
		Caballero enemigo;
		int valorEntero = (int) (Math.floor(Math.random() * ((caballeros.size() - 1) - 0 + 1) + 0));
		enemigo = caballeros.get(valorEntero);
		return enemigo;
	}

	private static Caballero seleccionarJugador(Scanner scan, ArrayList<Caballero> caballeros) {
		Caballero jugador;
		int opcionJugador;
		Visor.mostrarCaballeros(caballeros);
		Visor.mostrarMensaje("Escoge un caballero");
		opcionJugador = Integer.parseInt(scan.nextLine()) - 1;
		jugador = caballeros.get(opcionJugador);

		Visor.mostrarMensaje("Has escogido ha: \n" + jugador);

		return jugador;
	}

	private static int peleaDeCaballeros(ArrayList<Caballero> caballeros, ModeloCaballero modeloCaballero,
			Caballero jugador, Caballero enemigo) {
		int datosVictoria;
		int ganador;
		//Escudero aparece
		jugador=(posibilidadEscudero(jugador));
		enemigo=(posibilidadEscudero(enemigo));
		
		// Calculos lucha

		Visor.mostrarMensaje("El poder de " + jugador.getNombre() + " es de: " + jugador.getCaballeroLV());
		Visor.mostrarMensaje("El poder de " + enemigo.getNombre() + "tu enemigo es de:" + enemigo.getCaballeroLV());

		Visor.mostrarMensaje(
				"------------------------------------------------------------------------------------------------");

		int jugadorPoderFinal = jugador.getCaballeroLVEXP();
		int enemigoPoderFinal = enemigo.getCaballeroLVEXP();
		datosVictoria = jugadorPoderFinal - enemigoPoderFinal;

		Visor.mostrarMensaje("Debido a tu maestria tu poder ha subido: " + jugadorPoderFinal);
		Visor.mostrarMensaje("Debido a la maestria del enemigo su poder ha subido:" + enemigoPoderFinal);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Opciones de final
		if (datosVictoria > 25) {
			Visor.mostrarMensaje("El ganador es " + jugador.getNombre());
			jugador.setExperiencia(jugador.getExperiencia() + (int) (Math.random() * (4 - 1 + 1)) + 1);
			enemigo.setExperiencia(enemigo.getExperiencia() + (int) (Math.random() * (15 - 5 + 1)) + 5);
			jugador.getEscudero().setExperiencia(jugador.getEscudero().getExperiencia() + (int) (Math.random() * (4 - 1 + 1)) + 1);
			enemigo.getEscudero().setExperiencia(enemigo.getEscudero().getExperiencia() + (int) (Math.random() * (10 - 3 + 1)) + 3);
			
			ganador = 1;
		} else if (datosVictoria < (-25)) {
			Visor.mostrarMensaje("El ganador es " + enemigo.getNombre());
			enemigo.setExperiencia(enemigo.getExperiencia() + (int) (Math.random() * (4 - 1 + 1)) + 1);
			jugador.setExperiencia(jugador.getExperiencia() + (int) (Math.random() * (15 - 5 + 1)) + 5);
			jugador.getEscudero().setExperiencia(jugador.getEscudero().getExperiencia() + (int) (Math.random() * (10 - 3 + 1)) + 3);
			enemigo.getEscudero().setExperiencia(enemigo.getEscudero().getExperiencia() + (int) (Math.random() * (4 - 1 + 1)) + 1);
			ganador = 2;
		} else {
			Visor.mostrarMensaje("El combate resulta en empate");
			jugador.setExperiencia(jugador.getExperiencia() + (int) (Math.random() * (20 - 1 + 1)) + 1);
			enemigo.setExperiencia(enemigo.getExperiencia() + (int) (Math.random() * (20 - 1 + 1)) + 1);
			jugador.getEscudero().setExperiencia(jugador.getEscudero().getExperiencia() + (int) (Math.random() * (20 - 1 + 1)) + 1);
			enemigo.getEscudero().setExperiencia(enemigo.getEscudero().getExperiencia() + (int) (Math.random() * (20 - 1 + 1)) + 1);
			ganador = 0;
		}
		if (jugador.getEscudero().getExperiencia()>=50) {
			Caballero caballero = new Caballero();
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Subir a la BBDD
		caballeros.set(jugador.getId() - 1, jugador);
		caballeros.set(enemigo.getId() - 1, enemigo);
		modeloCaballero.modificarCaballeros(caballeros);
		return ganador;
	}

	private static Caballero posibilidadEscudero(Caballero caballero) {

		if (caballero.getEscudero() == null) {

			if ((int) (Math.random() * (5 - 1 + 1) + 1) == 5) {
				Visor.mostrarMensaje("------Un civil salta de las gradas y se propone a ser escudero de "
						+ caballero.getNombre() + "--------");
				Escudero escudero = new GestorEscudero().insertarEscuderoPorCaballero(caballero.getId());
				new ModeloEscudero().insertarEscudero(escudero);
				caballero.setEscudero(escudero);
			}
		}
		return caballero;

	}

}
