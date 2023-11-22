package ar.edu.unlam.pb2;

public class CuentaCorriente extends CuentaBancaria{

	private Double saldoDisponible;
	private Double sobreGiro;
	
	public CuentaCorriente(Integer cbu) {
		super(cbu);
		this.saldoDisponible=0.0;
		this.sobreGiro= 0.0 ;

	}

	public Double getSaldoDisponible() {
		return saldoDisponible;
	}

	public void setSaldoDisponible(Double saldoDisponible) {
		this.saldoDisponible = saldoDisponible;
	}

	@Override
	public Double getSaldo() {
		return saldoDisponible;
	}

	@Override
	public void depositar(Double importe) {
		this.saldoDisponible += importe;
	}

	@Override
	public Boolean extraer(Double importe) {
		if (saldoDisponible >= importe || sobreGiro >= importe) {
			return true;
		}
		return false;
	}


	public Double getSobreGiro() {
		return sobreGiro;
	}

	public void setSobreGiro(Double sobreGiro) {
		this.sobreGiro = sobreGiro;
	}
}
