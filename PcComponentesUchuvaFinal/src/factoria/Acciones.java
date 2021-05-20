package factoria;

import main.Controlador;

public interface Acciones {
	public String alta();

	public String baja();

	public String modificar(String ID);

	public String listar(Controlador controlador);

	public String buscar(Controlador controlador);

	public String mostrarHistorial(Controlador controlador);

	public String desactivar();

}
