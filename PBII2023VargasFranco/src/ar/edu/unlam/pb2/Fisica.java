package ar.edu.unlam.pb2;

import java.util.Objects;

public class Fisica extends Persona{

	private Integer cuil;
	
	
	public Fisica(String nombre, String apellido,Integer cuil) {
		super(nombre, apellido);
		this.cuil = cuil;
		}


	public Integer getCuil() {
		return cuil;
	}


	public void setCuil(Integer cuil) {
		this.cuil = cuil;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cuil);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fisica other = (Fisica) obj;
		return Objects.equals(cuil, other.cuil);
	}

	
}
