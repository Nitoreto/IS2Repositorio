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
		switch(datos.length) {
		case 4:
			if (datos[3].equals("1")) {
				activo = true;
			} else if (datos[3].equals("0")) {
				activo = false;
			} else {
				throw new Exception("Formato del telefono incorrecto");
			}
		case 3:
			pais = datos[2];
		case 2:
			nombre = datos[1];
		case 1:
			CIFMarca = datos[0];
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
