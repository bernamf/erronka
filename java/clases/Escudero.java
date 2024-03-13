package clases;

public class Escudero {
	
	private int id;
	private String nombre;
	private int Experiencia;
	private int idCaballero;
	
	
	public Escudero(int id, String nombre, int experiencia, int idCaballero) {
		this.id = id;
		this.nombre = nombre;
		Experiencia = experiencia;
		this.idCaballero = idCaballero;
	}
	
	public Escudero() {
	
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

	public int getExperiencia() {
		return Experiencia;
	}

	public void setExperiencia(int experiencia) {
		Experiencia = experiencia;
	}

	public int getIdCaballero() {
		return idCaballero;
	}

	public void setIdCaballero(int idCaballero) {
		this.idCaballero = idCaballero;
	}

	@Override
	public String toString() {
		return "Escudero [id=" + id + ", nombre=" + nombre + ", Experiencia=" + Experiencia + ", idCaballero="
				+ idCaballero + "]";
	}
	
	

}
