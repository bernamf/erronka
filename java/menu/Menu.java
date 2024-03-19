package menu;

public class Menu {
	
	public static final int LUCHAR = 1;
	public static final int VER_ARMAS = 2;
	public static final int HISTORIA = 7;
	public static final int VER_ESCUDOS = 3;
	public static final int VER_ESCUDEROS = 4;
	public static final int VER_CABALLOS = 5;
	public static final int TIENDA = 6;
	
	public static final int Ver_armas = 1;
	public static final int insertar_arma = 2;
	public static final int eliminar_arma = 3;
	
	public static final int ver_escudos = 1;
	public static final int insertar_escudo = 2;
	public static final int eliminar_escudo = 3;
	
	public static final int ver_escuderos = 1;
	public static final int insertar_escudero = 2;
	public static final int eliminar_escudero = 3;
	
	public static final int ver_caballos = 1;
	public static final int insertar_caballo = 2;
	public static final int eliminar_caballo = 3;
	
	public static final int COMPRAR_ARMA = 1;
	public static final int COMPRAR_ESCUDO = 2;
	
	
	public static final int SALIR =0;
	
	public static void menuPrincipal() {
		System.out.println("------MENU-------");
		System.out.println(LUCHAR + ". Entra en el campo de batalla");
		System.out.println(VER_ARMAS + ". Gestionar apartado de armas");
		System.out.println(VER_ESCUDOS + ". Gestionar apartado de escudos");
		System.out.println(VER_ESCUDEROS+ ". Gestionar apartado de escuderos");
		System.out.println(VER_CABALLOS + ". Gestionar apartado de caballos");
		System.out.println(TIENDA + ". Entrar a la tienda");
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
	
	public static void menuEscudero() {
		System.out.println("------MENU-------");
		System.out.println(ver_escudos + ". Ver escudero");
		System.out.println(insertar_escudo + ". Insertar un escudero");
		System.out.println(eliminar_escudo + ". Eliminar un escudero");
		System.out.println(SALIR + ". Salir");
		System.out.println("Elije una de las opciones");
	}
	
	public static void menuCaballo() {
		System.out.println("------MENU-------");
		System.out.println(ver_escudos + ". Ver caballos");
		System.out.println(insertar_escudo + ". Insertar un caballo");
		System.out.println(eliminar_escudo + ". Eliminar un caballo");
		System.out.println(SALIR + ". Salir");
		System.out.println("Elije una de las opciones");
	}
	
	 public static void menuTienda() {
	        System.out.println("Bienvenido a la tienda:");
	        System.out.println(COMPRAR_ARMA +". Comprar armas");
	        System.out.println(COMPRAR_ESCUDO +". Comprar escudos");
	        System.out.println(SALIR + ". Salir");
	        System.out.print("Ingrese su opción: ");
	    }
	
	
}
