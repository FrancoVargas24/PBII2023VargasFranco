package ar.edu.unlam.pb2;

import java.util.Objects;

public class Juridica extends Persona{
	
	private Integer cuit;
	
	public Juridica(String nombre, String apellido, Integer cuit) {
		super(nombre, apellido);
		this.cuit = cuit;
	}

	public Integer getCuit() {
		return cuit;
	}

	public void setCuit(Integer cuit) {
		this.cuit = cuit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cuit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Juridica other = (Juridica) obj;
		return Objects.equals(cuit, other.cuit);
	}
	
}
