package factoryController;

import main.Mediator;

public interface Acciones {
	public String alta();

	public String baja();

	public String modificar(String ID);

	public String listar(Mediator controlador);

	public String buscar(Mediator controlador);

	public String mostrarHistorial(Mediator controlador);

	public String desactivar();

}
