package ar.edu.unlam.pb2;

public class CuentaBancaria extends MedioDePago implements Transferible{

	private Integer cbu;
	private Double saldo;

	public CuentaBancaria(Integer cbu) {
		super();
		this.cbu = cbu;
		this.saldo = 0.0;
	}

	public Integer getCbu() {
		return cbu;
	}

	public void setCbu(Integer cbu) {
		this.cbu = cbu;
	}

	@Override
	public Double getSaldo() {
		return saldo;
	}

	@Override
	public void depositar(Double importe) {
		this.saldo += importe;
	}

	@Override
	public Boolean extraer(Double importe) {
		if (saldo >= importe) {
			return true;
		}
		return false;
	}

	public void sePuedeTransferir(Double importe) throws SaldoInsuficienteException {
		if (extraer(importe)) {
			
		}else {
			throw new SaldoInsuficienteException();
		}		
	}
	
	
}
