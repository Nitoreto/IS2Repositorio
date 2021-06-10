package factoryController;

import Transfer.Transfer;
import main.Mediator;

public interface Acciones {
	public Boolean alta();

	public Boolean baja();

	public Boolean modificar(String ID);

	public Boolean listar();

	public Boolean buscar();

	public Boolean desactivar();
	
	public Boolean mostrarHistorial();

}
