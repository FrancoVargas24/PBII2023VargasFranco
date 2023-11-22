package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.List;

public abstract class Persona {
	
	private String nombre;
	private String apellido;
	private List<MedioDePago> medios;
	
	public Persona(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.medios = new ArrayList<MedioDePago>();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	protected void agregarMedio(MedioDePago medio) {
		medios.add(medio);
	}

	public List<MedioDePago> getMedios() {
		return medios;
	}

	public void setMedios(List<MedioDePago> medios) {
		this.medios = medios;
	}
	

}
