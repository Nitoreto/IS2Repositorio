package Transfer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransferMarca extends Transfer {

	private String CIFMarca, nombre, pais;
	private Boolean activo;

	public TransferMarca(ResultSet resultado) throws SQLException {
		super(resultado);
	}

	public TransferMarca(String[] datos) throws Exception {
		super();
		CIFMarca = datos[0];
		nombre = datos[1];
		pais = datos[2];
		if (datos[3].equals("1")) {
			activo = true;
		} else if (datos[3].equals("0")) {
			activo = false;
		} else {
			throw new Exception("Formato del telefono incorrecto");
		}
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
}
