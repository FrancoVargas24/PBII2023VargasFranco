package ar.edu.unlam.pb2;

public class CuentaVirtual extends MedioDePago implements Transferible{

	private Integer cvu;
	private Double saldo;

	public CuentaVirtual(Integer cvu) {
		super();
		this.cvu = cvu;
		this.saldo = 0.0;
	}

	public Integer getCvu() {
		return cvu;
	}

	public void setCvu(Integer cvu) {
		this.cvu = cvu;
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
	
	public void sePuedeExtraer(Double importe) throws SaldoInsuficienteException{
		if (extraer(importe)) {
			
		}else {
			throw new SaldoInsuficienteException();
		}
	}
}
