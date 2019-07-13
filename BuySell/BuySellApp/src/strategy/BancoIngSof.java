package strategy;

public class BancoIngSof extends PagoBanco{

	@Override
	void inciar() {
		// obtener lo necesario para que en el siguiente paso
		// se pueda verificar saldo
		// - guiarse por BancoPago-
	}
	
	@Override
	void verificarSaldo() {}
	
	@Override
	void realizarCompra() {}
	
	@Override
	void notificarAdmin() {}
}
