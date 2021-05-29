package DAOMarca;

import dao_Transfer_Singelton.DAOSuper;
import factoria.Marca;

public class DAOModificarMarca extends DAOSuper {

	public DAOModificarMarca(Marca marca, String CIFMarcaOriginal) {
		super();
		this.query = "UPDATE marcas SET CIFMarca = '" + marca.getCIFMarca() + "' ,Nombre = '" + marca.getNombre()
				+ "', Pais = '" + marca.getPais() + "', Activo = " + marca.getActivo() + " WHERE CIFMarca = '" + CIFMarcaOriginal + "'";
	}

	public String conectar() {
		int row = -1;
		try {
			row = super.conectarUpdate();
		} catch (Exception e) {
			if (e.getClass().getName().equals("com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException")) {
				return "No se puede cambiar el nombre de una marca con productos";
			}

			return e.getMessage();
		}
		if (row == 0) {
			return "El CIF esta vacio.";
		}
		return "Exito";
	}

}