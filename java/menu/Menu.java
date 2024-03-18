package menu;

public class Menu {
	
	public static final int LUCHAR = 1;
	public static final int VER_ARMAS = 2;
	public static final int HISTORIA = 4;
	public static final int VER_ESCUDOS = 3;
	
	public static final int Ver_armas = 1;
	public static final int insertar_arma = 2;
	public static final int eliminar_arma = 3;
	
	public static final int ver_escudos = 1;
	public static final int insertar_escudo = 2;
	public static final int eliminar_escudo = 3;
	
	public static final int SALIR =0;
	
	public static void menuPrincipal() {
		System.out.println("------MENU-------");
		System.out.println(LUCHAR + ". Entra en el campo de batalla");
		System.out.println(VER_ARMAS + ". Gestionar apartado de armas");
		System.out.println(VER_ESCUDOS + ". Gestionar apartado de escudos");
		System.out.println(HISTORIA + ". Leer la historia");
		System.out.println(SALIR + ". Salir");
		System.out.println("Elije una de las opciones");
	}

	
	public static void menuArma() {
		System.out.println("------MENU-------");
		System.out.println(Ver_armas + ". Ver armas");
		System.out.println(insertar_arma + ". Insertar un arma");
		System.out.println(eliminar_arma + ". Eliminar un arma");
		System.out.println(SALIR + ". Salir");
		System.out.println("Elije una de las opciones");
	}
	
	
	public static void menuEscudo() {
		System.out.println("------MENU-------");
		System.out.println(ver_escudos + ". Ver escudos");
		System.out.println(insertar_escudo + ". Insertar un escudo");
		System.out.println(eliminar_escudo + ". Eliminar un escudo");
		System.out.println(SALIR + ". Salir");
		System.out.println("Elije una de las opciones");
	}
	
	
	
}
