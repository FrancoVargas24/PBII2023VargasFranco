package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class testBilleteraDePago {

	@Test
	public void queSePuedanAlmacenarLosDistintosTiposDeTransacciones() {
		String nombre = "MiBilletera";
		Billetera miBilletera = new Billetera(nombre);

		String nombre1 = "Unlam";
		String nombre2 = "srl";
		Juridica pJuridica = new Juridica(nombre1, nombre2, 156548915);

		String nombre3 = "Franco";
		String nombre4 = "Vargas";
		Fisica pFisica = new Fisica(nombre1, nombre2, 48915154);

		TarjetaDeCredito tarjetaDeCredito = new TarjetaDeCredito("Visa", 48954355);
		TarjetaDeDebito tarjetaDeDebito = new TarjetaDeDebito("VisaDebito", 123459541);

		miBilletera.agregarTransaccion(2123, tarjetaDeDebito);
		miBilletera.agregarTransaccion(54125, tarjetaDeCredito);

		assertNotNull(miBilletera.getTransacciones());
	}

	@Test
	public void queSePuedanAlmacenarLosDistintosTiposDePersonas() {
		String nombre = "MiBilletera";
		Billetera miBilletera = new Billetera(nombre);

		String nombre1 = "Unlam";
		String nombre2 = "srl";
		Juridica pJuridica = new Juridica(nombre1, nombre2, 156548915);

		String nombre3 = "Franco";
		String nombre4 = "Vargas";
		Fisica pFisica = new Fisica(nombre1, nombre2, 48915154);

		miBilletera.agregarComercio(pJuridica);

		miBilletera.agregarConsumidor(pFisica);

		assertTrue(miBilletera.buscarPersonaJuridica(pJuridica));
	}

	@Test
	public void queSePuedanAsociadACadaPersonaSusMedios() {

		String nombre1 = "Unlam";
		String nombre2 = "srl";
		Juridica pJuridica = new Juridica(nombre1, nombre2, 156548915);

		String nombre3 = "Franco";
		String nombre4 = "Vargas";
		Fisica pFisica = new Fisica(nombre1, nombre2, 48915154);

		CuentaBancaria cuentaBancaria = new CuentaBancaria(4564645);
		CuentaBancaria cuentaBancaria1 = new CuentaBancaria(6521516);

		pJuridica.agregarMedio(cuentaBancaria);
		pFisica.agregarMedio(cuentaBancaria1);

		assertNotNull(pJuridica.getMedios());
		assertNotNull(pFisica.getMedios());
	}

	@Test
	public void queSePuedanRealizarCompras() {
		String nombre = "MiBilletera";
		Billetera miBilletera = new Billetera(nombre);

		String nombre1 = "Unlam";
		String nombre2 = "srl";
		Juridica pJuridica = new Juridica(nombre1, nombre2, 156548915);

		String nombre3 = "Franco";
		String nombre4 = "Vargas";
		Fisica pFisica = new Fisica(nombre1, nombre2, 48915154);

		Compra compraActual = new Compra(pJuridica, 56215.0);

		miBilletera.agregarCompra(compraActual);

		assertNotNull(miBilletera.getCompras());
	}

	@Test
	public void queSePuedanRealizarMovimientosBancarios() {
		String nombre = "MiBilletera";
		Billetera miBilletera = new Billetera(nombre);

		String nombre1 = "Unlam";
		String nombre2 = "srl";
		Juridica pJuridica = new Juridica(nombre1, nombre2, 156548915);

		CuentaBancaria cuentaBancaria = new CuentaBancaria(4564645);

		pJuridica.agregarMedio(cuentaBancaria);

		cuentaBancaria.depositar(1548.0);

		Double esperado = 1548.0;

		assertNotNull(cuentaBancaria.extraer(esperado));

		String nombre3 = "Franco";
		String nombre4 = "Vargas";
		Fisica pFisica = new Fisica(nombre1, nombre2, 48915154);

		CuentaBancaria cuentaBancaria1 = new CuentaBancaria(3245645);

		pFisica.agregarMedio(cuentaBancaria1);

		cuentaBancaria.depositar(1514.0);

		Double esperado2 = 1514.0;

		assertNotNull(cuentaBancaria1.extraer(esperado2));

	}

	@Test
	public void queSePuedanRealizarTransferencias() {
		String nombre = "MiBilletera";
		Billetera miBilletera = new Billetera(nombre);

		String nombre1 = "Unlam";
		String nombre2 = "srl";
		Juridica pJuridica = new Juridica(nombre1, nombre2, 156548915);

		TarjetaDeDebito tarjetaDeDebito = new TarjetaDeDebito("Visa", 85613254);

		pJuridica.agregarMedio(tarjetaDeDebito);
		
		miBilletera.agregarComercio(pJuridica);

		String nombre3 = "Franco";
		String nombre4 = "Vargas";
		Fisica pFisica = new Fisica(nombre1, nombre2, 48915154);

		TarjetaDeDebito tarjetaDeDebito1 = new TarjetaDeDebito("Visa", 13245645);

		pFisica.agregarMedio(tarjetaDeDebito1);

		tarjetaDeDebito1.setSaldoDisponible(1514.0);

		tarjetaDeDebito1.pagar(pFisica, 50.0);
		
		assertEquals(50.0, tarjetaDeDebito.getSaldoDisponible(), 50.0);
	}

	@Test(expected = SaldoInsuficienteException.class)
	public void queSeLanceUnaExcepcionSiElSaldoDeLaTarjetaEsInsuficienteParaHacerUnaCompra()
			throws SaldoInsuficienteException {
		String nombre = "MiBilletera";
		Billetera miBilletera = new Billetera(nombre);

		String nombre1 = "Unlam";
		String nombre2 = "srl";
		Juridica pJuridica = new Juridica(nombre1, nombre2, 156548915);
		String nombre3 = "Franco";
		String nombre4 = "Vargas";
		Fisica pFisica = new Fisica(nombre1, nombre2, 48915154);
		TarjetaDeDebito tarjetaDebito = new TarjetaDeDebito("visa", 4564645);

		pFisica.agregarMedio(tarjetaDebito);

		tarjetaDebito.setSaldoDisponible(5000.0);

		tarjetaDebito.sePuedePagar(pJuridica, 10050.0);

	}

	@Test(expected = SaldoInsuficienteException.class)
	public void queSeLanceUnaExcepcionSiElSaldoDeLaCuentaVirtualEsInsuficienteParaHacerUnaCompra()
			throws SaldoInsuficienteException {
		String nombre = "MiBilletera";
		Billetera miBilletera = new Billetera(nombre);

		String nombre1 = "Unlam";
		String nombre2 = "srl";
		Juridica pJuridica = new Juridica(nombre1, nombre2, 156548915);
		String nombre3 = "Franco";
		String nombre4 = "Vargas";
		Fisica pFisica = new Fisica(nombre1, nombre2, 48915154);
		CuentaVirtual cuentaVirtual = new CuentaVirtual(498513);

		pFisica.agregarMedio(cuentaVirtual);

		cuentaVirtual.depositar(1565.0);

		cuentaVirtual.sePuedeExtraer(1600.0);
	}

	@Test
	public void queSeLanceUnaExcepcionSiElLimiteDeCompraDeLaTarjetaEsInsuficienteParaHacerUnaCompra()
			throws SaldoInsuficienteException {
		String nombre = "MiBilletera";
		Billetera miBilletera = new Billetera(nombre);

		String nombre1 = "Unlam";
		String nombre2 = "srl";
		Juridica pJuridica = new Juridica(nombre1, nombre2, 156548915);
		String nombre3 = "Franco";
		String nombre4 = "Vargas";
		Fisica pFisica = new Fisica(nombre1, nombre2, 48915154);
		TarjetaDeCredito tarjetaCredito = new TarjetaDeCredito("Visa", 985215);

		pFisica.agregarMedio(tarjetaCredito);
		tarjetaCredito.pagar(pJuridica, 1591.0);

	}

	@Test
	public void queSeLanceUnaExcepcionSiElSaldoDeLaCuentaEsInsuficienteParaHacerUnaTransferencia()
			throws SaldoInsuficienteException {

		String nombre = "MiBilletera";
		Billetera miBilletera = new Billetera(nombre);

		String nombre1 = "Unlam";
		String nombre2 = "srl";
		Juridica pJuridica = new Juridica(nombre1, nombre2, 156548915);

		CuentaBancaria cuentaBancaria = new CuentaBancaria(4564645);

		pJuridica.agregarMedio(cuentaBancaria);

		cuentaBancaria.depositar(1548.0);

		cuentaBancaria.sePuedeTransferir(1548.0);

	}

	@Test
	public void queDesdeUnaCuentaCorrienteSePuedaRealizarUnaTransferenciaPorEncimaDeSuSaldo() {
		String nombre1 = "Unlam";
		String nombre2 = "srl";
		Juridica pJuridica = new Juridica(nombre1, nombre2, 156548915);

		CuentaCorriente cuentaCorriente = new CuentaCorriente(4564645);

		pJuridica.agregarMedio(cuentaCorriente);

		cuentaCorriente.setSobreGiro(5000.0);

		assertTrue(cuentaCorriente.extraer(4000.0));

	}

}
