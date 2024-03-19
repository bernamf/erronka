
package clases;

public class Caballo {

	private int id;
	private String nombre;
	private int velocidadMaxima;
	private int resistencia;
	private int idCaballero;
	
	
	
	public Caballo( String nombre, int velocidadMaxima, int resistencia, int idCaballero) {
		
		this.nombre = nombre;
		this.velocidadMaxima = velocidadMaxima;
		this.resistencia = resistencia;
		this.idCaballero= idCaballero;
		
	}
	
	public Caballo() {
		
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

	public int getVelocidadMaxima() {
		return velocidadMaxima;
	}

	public void setVelocidadMaxima(int velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}

	public int getResistencia() {
		return resistencia;
	}

	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}

	
	

	public int getIdCaballero() {
		return idCaballero;
	}

	public void setIdCaballero(int idCaballero) {
		this.idCaballero = idCaballero;
	}

	@Override
	public String toString() {
		return "Caballo [id=" + id + ", nombre=" + nombre + ", velocidadMaxima=" + velocidadMaxima + ", resistencia="
				+ resistencia + ", idCaballero=" + idCaballero + "]";
	}

	
	
	
}
