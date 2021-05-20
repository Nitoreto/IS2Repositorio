package DAOMarca;

import DAOAndTransfer.DAOSuper;
import factoria.Marca;

public class DAODesactivarMarca extends DAOSuper {
	public DAODesactivarMarca(Marca marca) {
		super();
		this.query = "UPDATE marcas SET Activo = 0 WHERE CIFMarca = '" + marca.getCIFMarca() + "'";
	}

	public String conectar() {
		int row = -1;
		try {
			row = super.conectarUpdate();
		} catch (Exception e) {

			return e.getMessage();
		}
		if (row == 0) {
			return "CIF no Encontrado";
		}
		return "Exito";
	}
}
