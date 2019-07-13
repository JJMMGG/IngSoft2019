package strategy;

public class CasaDePago extends PagoCodigo {

	@Override
	void inciar() {
		// obtener lo necesario para que en el siguiente paso
				// se pueda verificar saldo
				// - guiarse por PagoCodigo-
	}
	
	@Override
	void verificarSaldo() {}
	
	@Override
	void realizarCompra() {}
	
	@Override
	void notificarAdmin() {}
}
