package gertor;

import java.util.ArrayList;
import java.util.Scanner;
import clases.Caballero;
import menu.Visor;
import modelo.ModeloCaballero;

public class GestorHistoria {

    private static ArrayList<Caballero> caballeros = new ArrayList<>();

    public static void run() {
        cargarCaballeros(); // Cargar los caballeros disponibles
        Scanner scan = new Scanner(System.in);
        mostrarCaballeros();
        Visor.mostrarMensaje("Ingresa el ID del caballero para ver su historia:");
        int idCaballero = Integer.parseInt(scan.nextLine());
        mostrarHistoria(idCaballero);
    }

    private static void cargarCaballeros() {
    	ModeloCaballero modeloCaballero = new ModeloCaballero();
        caballeros = modeloCaballero.getCaballeros();
    }

    private static void mostrarCaballeros() {
        Visor.mostrarMensaje("Lista de caballeros disponibles:");
        for (Caballero caballero : caballeros) {
            Visor.mostrarMensaje("ID: " + caballero.getId() + ", Nombre: " + caballero.getNombre());
        }
    }

    private static void mostrarHistoria(int idCaballero) {
        for (Caballero caballero : caballeros) {
            if (caballero.getId() == idCaballero) {
                Visor.mostrarMensaje("Historia de " + caballero.getNombre() + ":");
                switch (idCaballero) {
                    case 1:
                        Visor.mostrarMensaje("Conocido por su coraje y su dominio del escudo torre, Black Prior era un guerrero temido en el campo de batalla. Su experiencia de 33 años le había enseñado a ser astuto y estratégico, capaz de anticipar los movimientos de sus enemigos y proteger a sus compañeros en las batallas más feroces.");
                        break;
                    case 2:
                        Visor.mostrarMensaje("Topuria era un arquero habilidoso, cuya destreza con la ballesta era legendaria en todo el reino. Con una experiencia de 69 años, había perfeccionado su técnica hasta convertirla en un arte, y su precisión era temida por todos aquellos que se atrevían a desafiarlo.");
                        break;
                    case 3:
                        Visor.mostrarMensaje("A pesar de su aspecto imponente, Shugoki era un guerrero gentil de corazón. Su fuerza bruta y su habilidad con el cuchillo lo convertían en un oponente formidable en la batalla, pero su verdadera fortaleza residía en su corazón noble y su lealtad inquebrantable hacia sus compañeros.");
                        break;
                    case 4:
                        Visor.mostrarMensaje("Nobushi era una maestra del arco, cuya destreza en el combate a distancia era incomparable. Su agilidad y rapidez con los arcos le permitían atacar desde la distancia con una precisión letal, convirtiéndola en una figura temida por sus enemigos.");
                        break;
                    case 5:
                        Visor.mostrarMensaje("Afeera, la portadora del hacha, era conocida por su ferocidad en el campo de batalla. Su fuerza y valentía la convertían en una fuerza imparable, capaz de enfrentarse a cualquier desafío con determinación y coraje.");
                        break;
                    case 6:
                        Visor.mostrarMensaje("Orochi era un maestro de la lanza, cuya agilidad y velocidad lo convertían en un oponente formidable en el campo de batalla. Con su capacidad para esquivar los ataques enemigos y contraatacar con precisión letal, era un guerrero temido por todos aquellos que se atrevían a desafiarlo.");
                        break;
                    case 7:
                        Visor.mostrarMensaje("Con su imponente maza, Warmonger era un guerrero formidable en el campo de batalla. Su fuerza y su habilidad en el combate cuerpo a cuerpo lo convertían en un oponente temible, capaz de derrotar a múltiples enemigos con un solo golpe de su arma devastadora.");
                        break;
                    case 8:
                        Visor.mostrarMensaje("Con su alabarda en mano y su escudo con púas, Conqueror era un símbolo de resistencia y determinación en el campo de batalla. Su fuerza y su inteligencia táctica lo convertían en un líder entre sus compañeros, capaz de guiar a su ejército hacia la victoria en las batallas más difíciles.");
                        break;
                    default:
                        Visor.mostrarMensaje("No se encontró la historia del caballero con ID: " + idCaballero);
                        break;
                }
                return;
            }
        }
        Visor.mostrarMensaje("No se encontró ningún caballero con ID: " + idCaballero);
    }
}
