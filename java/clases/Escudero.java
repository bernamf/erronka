package clases;

public class Escudero {
	
	private int id;
	private String nombre;
	private int Experiencia;
	
	
	
	public Escudero(int id, String nombre, int experiencia) {
		this.id = id;
		this.nombre = nombre;
		Experiencia = experiencia;
		
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


	@Override
	public String toString() {
		return "Escudero [id=" + id + ", nombre=" + nombre + ", Experiencia=" + Experiencia +  "]";
	}
	
	

}
