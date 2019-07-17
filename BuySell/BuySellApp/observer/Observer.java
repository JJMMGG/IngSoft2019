package observer;

import subject.SujetoUsuario;

public abstract class Observer {

	protected SujetoUsuario sujeto;
	public abstract void Actualizar();
}
