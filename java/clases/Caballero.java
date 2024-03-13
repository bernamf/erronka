package clases;

public class Caballero {

	private int id;
	private String nombre;
	private int idArma;
	private int idEscudo;
	
	
	
	public Caballero(int id, String nombre, int idArma, int idEscudo) {
		this.id = id;
		this.nombre = nombre;
		this.idArma = idArma;
		this.idEscudo = idEscudo;
	}
	
	public Caballero() {
		
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
	public int getIdArma() {
		return idArma;
	}
	public void setIdArma(int idArma) {
		this.idArma = idArma;
	}
	public int getIdEscudo() {
		return idEscudo;
	}
	public void setIdEscudo(int idEscudo) {
		this.idEscudo = idEscudo;
	}

	@Override
	public String toString() {
		return "Caballero [id=" + id + ", nombre=" + nombre + ", idArma=" + idArma + ", idEscudo=" + idEscudo + "]";
	}
	
	
	
}
