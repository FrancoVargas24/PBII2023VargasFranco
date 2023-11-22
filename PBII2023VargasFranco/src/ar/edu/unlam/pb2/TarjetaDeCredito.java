package ar.edu.unlam.pb2;

public class TarjetaDeCredito extends MedioDePago implements Pagadora{

	private String nombreBanco;
	private Integer numeroTarjeta;
	private Integer	saldoDisponible;
	
	public TarjetaDeCredito(String nombreBanco, Integer numeroTarjeta) {
		super();
		this.nombreBanco = nombreBanco;
		this.numeroTarjeta = numeroTarjeta;
		this.saldoDisponible = 0;
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
			return true;
		}
		return false;
	}
	public Integer getSaldoDisponible() {
		return saldoDisponible;
	}
	public void setSaldoDisponible(Integer saldoDisponible) {
		this.saldoDisponible = saldoDisponible;
	}
	public void sePuedePagar(Juridica pJuridica, Double importe) throws SaldoInsuficienteException{
		if (pagar(pJuridica, importe)) {
			
		}else {
			throw new SaldoInsuficienteException();
		}
		
	}

}
