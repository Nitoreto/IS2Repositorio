package factoria;

import DAOEmpleado.DAODesactivarEmpleado;
import DAOMarca.DAOAltaMarca;
import DAOMarca.DAOBajaMarca;
import DAOMarca.DAOBuscarMarca;
import DAOMarca.DAODesactivarMarca;
import DAOMarca.DAOListarMarcas;
import DAOMarca.DAOModificarMarca;
import main.Controlador;

public class Marca extends ShopObject {

	private String CIFMarca, nombre, pais;
	private Boolean activo;

	public Marca() {
		super("Marca");
	}

	public String getCIFMarca() {
		return CIFMarca;
	}

	public String getNombre() {
		return nombre;
	}

	public int getActivo() {
		int valor = this.activo ? 1 : 0;
		return valor;
	}

	public String getPais() {
		return pais;
	}

	@Override
	public String alta() {
		DAOAltaMarca dao = new DAOAltaMarca(this);
		return dao.conectar();

	}

	@Override
	public String baja() {
		DAOBajaMarca dao = new DAOBajaMarca(this);
		return dao.conectar();
	}

	@Override
	public String modificar(String ID) {
		DAOModificarMarca dao = new DAOModificarMarca(this, ID);
		return dao.conectar();

	}

	@Override
	public String listar(Controlador controlador) {
		DAOListarMarcas dao = new DAOListarMarcas(this);
		String string = dao.conectar();
		if (string == "Exito")
			controlador.generarTabla(dao.generarTabla(), dao.generarTitulos(), "Abstract");
		return string;
	}

	@Override
	public String buscar(Controlador controlador) {
		DAOBuscarMarca dao = new DAOBuscarMarca(this);
		String string = dao.conectar();
		if (string == "Exito")
			controlador.generarTabla(dao.generarTabla(), dao.generarTitulos(), "Default");
		return string;
	}
	
	@Override
	public String desactivar() {
		DAODesactivarMarca dao = new DAODesactivarMarca(this);
		return dao.conectar();
	}

	@Override
	public void inicializarObjeto(String[] datos) throws NumberFormatException{
		for (int i = 0; i < datos.length; i++) {
			switch (i) {
			case 0:
				CIFMarca = datos[0];
				break;
			case 1:
				nombre = datos[1];
				break;
			case 2:
				pais = datos[2];
				break;
			case 3:
				if (datos[3].equals("1")) {
					activo = true;
				} else if(datos[3].equals("0")){
					activo = false;
				}else{
					throw new NumberFormatException();
				}
				;
				break;
			}
		}
	}

	@Override
	public String mostrarHistorial(Controlador controlador) {
		// TODO Auto-generated method stub
		return null;
	}

}
