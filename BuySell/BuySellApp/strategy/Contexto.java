package strategy;

public class Contexto {
	IEstrategia estrategia;
	
	public Contexto(IEstrategia estrategia) {
		this.estrategia = estrategia;
	}
	
	public void ejecutar() {
		this.estrategia.realizarPago();; 
	}
}
