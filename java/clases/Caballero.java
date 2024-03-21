package clases;

public class Caballero {

	private int id;
	private String nombre;

	private int experiencia;
	private int fuerza;
	private int inteligencia;
	private int agilidad;

	private Arma arma;
	private Escudo escudo;
	private Escudero escudero;
	private Caballo caballo;

	private int caballeroLV;
	private int caballeroLVEXP;

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

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	public int getAgilidad() {
		return agilidad;
	}

	public void setAgilidad(int agilidad) {
		this.agilidad = agilidad;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public Escudo getEscudo() {
		return escudo;
	}

	public void setEscudo(Escudo escudo) {
		this.escudo = escudo;
	}

	public Escudero getEscudero() {
		return escudero;
	}

	public void setEscudero(Escudero escudero) {
		this.escudero = escudero;
	}

	public Caballo getCaballo() {
		return caballo;
	}

	public void setCaballo(Caballo caballo) {
		this.caballo = caballo;
	}

	public Caballero(int id, String nombre, int experiencia, int fuerza, int inteligencia, int agilidad, Arma arma,
			Escudo escudo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.experiencia = experiencia;
		this.fuerza = fuerza;
		this.inteligencia = inteligencia;
		this.agilidad = agilidad;
		this.arma = arma;
		this.escudo = escudo;

	}

	@Override
	public String toString() {
		return "Caballeroº " + id + ", " + nombre + " Experiencia:" + experiencia + ", fuerza=" + fuerza
				+ ", inteligencia=" + inteligencia + ", agilidad=" + agilidad + "," + arma + ", " + escudo;
	}

	public int getCaballeroLV() {
		int armaATK;
		int escudoDEF;
		this.caballeroLV = (this.getFuerza() + this.getInteligencia() + this.getAgilidad()) * 4;
		if (escudero != null) {
			escudoDEF = (int) (this.getEscudo().getDefensa() * (1 + this.escudero.getExperiencia() * 0.015));
		} else {
			escudoDEF = this.getEscudo().getDefensa();
		}
		if (caballo != null) {
			armaATK = (int) (this.getArma().getAtaque() * (1 + this.caballo.getVelocidadMaxima() * 0.015));
		} else {
			armaATK = this.getArma().getAtaque();
		}
		this.caballeroLV += (escudoDEF + armaATK) * 0.4;
		return caballeroLV;
	}

	public int getCaballeroLVEXP() {
		this.caballeroLVEXP = (int) (this.caballeroLV
				* (1 + ((Math.floor(Math.random() * (this.getExperiencia() - 1 + 1) + 1))) * 0.02));
		return caballeroLVEXP;
	}

}
