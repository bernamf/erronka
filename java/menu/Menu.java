package menu;

public class Menu {
	
	public static final int LUCHAR = 1;
	public static final int VER_CABALLEROS = 2;
	public static final int HISTORIA = 3;
	
	
	public static final int SALIR =0;
	
	public static void menuPrincipal() {
		System.out.println("------MENU-------");
		System.out.println(LUCHAR + ". Entra en el campo de batalla");
		System.out.println(VER_CABALLEROS + ". Ver la lista de caballeros");
		System.out.println(HISTORIA + ". Leer la historia");
		System.out.println(SALIR + ". Salir");
		System.out.println("Elije una de las opciones");
	}

}
