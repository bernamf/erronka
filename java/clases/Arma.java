package clases;

public class Arma {

	private int id;
	private String nombre;
	private int ataque;
	
	
	public Arma( String nombre, int ataque) {
		
		this.nombre = nombre;
		this.ataque = ataque;
	}
	
	public Arma() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	@Override
	public String toString() {
		return "Arma: " + id + "= " + nombre + ", " + ataque + " atk";
	}
	
	
	
}
