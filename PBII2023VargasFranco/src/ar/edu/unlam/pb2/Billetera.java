package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Billetera {

	private String nombre;
	private Set<Juridica> juridicas;
	private Set<Fisica> fisicas; 
	private Map<MedioDePago, Integer> transacciones; 
	private List<Compra> compras;

	public Billetera(String nombre) {
		this.setNombre(nombre);
		this.juridicas= new HashSet<>();
		this.fisicas= new HashSet<>();
		this.transacciones= new HashMap<>();
		this.compras= new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarComercio(Juridica juridica) {
		juridicas.add(juridica);
	}
	

	public Integer getCantidadDeComercios() {
		return juridicas.size();
	}
	
	public void agregarTransaccion(Integer transaccion, MedioDePago medioDePago) {
		transacciones.put(medioDePago, transaccion);
	}


	public Integer getCantidadDeTransacciones() {
		return transacciones.size();
	}


	public void agregarConsumidor(Fisica consumidor) {
		fisicas.add(consumidor);	
	}

	public Object getCantidadDeConsumidores() {
		
		return fisicas.size();
	}

	// generar qr y buscar persona Juridica
	public Compra generarCodigoQR(Integer cuitComercio, Double importeCompra) {
		
		Juridica comercioEncontrado = buscarComercio(cuitComercio);
		Compra nueva= new Compra(comercioEncontrado, importeCompra);
		compras.add(nueva);
		return nueva;
	}

	public Juridica buscarComercio(Integer cuitComercio) {
		
		for (Juridica actual : juridicas) {
			
			if (actual.getCuit().equals(cuitComercio)) {
				return actual;
			}
		}
		return null;
	}

	public Boolean buscarPersonaJuridica(Juridica juridica) {
		
		for (Juridica actual : juridicas) {
			
			if (actual.getCuit().equals(juridica.getCuit())) {
				return true;
			}
		}
		return false;
	}

	public Set<Juridica> getJuridicas() {
		return juridicas;
	}

	public void setJuridicas(Set<Juridica> juridicas) {
		this.juridicas = juridicas;
	}

	public Set<Fisica> getFisicas() {
		return fisicas;
	}

	public void setFisicas(Set<Fisica> fisicas) {
		this.fisicas = fisicas;
	}

	public Map<MedioDePago, Integer> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(Map<MedioDePago, Integer> transacciones) {
		this.transacciones = transacciones;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public void agregarCompra(Compra compraActual) {
		compras.add(compraActual);
	}

	
}
