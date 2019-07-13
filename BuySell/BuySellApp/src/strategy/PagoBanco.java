package strategy;

public abstract class PagoBanco implements IEstrategia {

	@Override
	public void realizarPago() {
		// TODO Auto-generated method stub
		inciar();
		verificarSaldo();
		realizarCompra();
		notificarAdmin();
		
		
	}

	abstract void inciar();
	abstract void verificarSaldo();
	abstract void realizarCompra();
	abstract void notificarAdmin();
}
