package ar.edu.unlam.pb2;

public class TarjetaDeDebito extends MedioDePago implements Pagadora{

	private String nombreBanco;
	private Integer numeroTarjeta;
	private Double saldoDisponible;
	
	public TarjetaDeDebito(String nombreBanco, Integer numeroTarjeta) {
		super();
		this.nombreBanco = nombreBanco;
		this.numeroTarjeta = numeroTarjeta;
		this.saldoDisponible = 0.0;
	}
	public String getNombreBanco() {
		return nombreBanco;
	}
	public void setNombreBanco(String nombreBanco) {
		this.nombreBanco = nombreBanco;
	}
	public Integer getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(Integer numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	@Override
	public Boolean pagar(Persona vendedor, Double importe) {
		if (saldoDisponible>= importe) {
			saldoDisponible -= importe;
			return true;
		}
		return false;
	}
	public Double getSaldoDisponible() {
		return saldoDisponible;
	}
	public void setSaldoDisponible(Double saldoDisponible) {
		this.saldoDisponible = saldoDisponible;
	}
	
	public void sePuedePagar(Persona vendedor, Double importe) throws SaldoInsuficienteException{
		if (pagar(vendedor, importe)) {
			
		}else {
			throw new SaldoInsuficienteException();
		}
	}

	
	
}
