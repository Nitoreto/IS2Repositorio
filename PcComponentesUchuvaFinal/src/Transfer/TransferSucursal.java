package Transfer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransferSucursal extends Transfer {
	private String direccion;
	private int ID, telefono;
	private Boolean activo;

	public TransferSucursal(ResultSet resultado) throws SQLException {
		super(resultado);
	}

	public TransferSucursal(String[] datos) throws Exception {
		switch (datos.length) {
		case 4:
			if (datos[3].equals("1")) {
				activo = true;
			} else if (datos[3].equals("0")) {
				activo = false;
			} else {
				throw new Exception("Formato del campo activo incorrecto");
			}
		case 3:
			try {
				telefono = Integer.parseInt(datos[2]);
			} catch (NumberFormatException e) {
				throw new Exception("Formato del telefono incorrecto, solo numero");
			}
		case 2:
			direccion = datos[1];
		case 1:
			try {
				ID = Integer.parseInt(datos[0]);
			} catch (NumberFormatException e) {
				throw new Exception("Formato del telefono incorrecto, solo numero");
			}
		}
	}

	public int isActivo() {
		int valor = this.activo ? 1 : 0;
		return valor;
	}

	public String getDireccion() {
		return direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public int getID() {
		return ID;
	}

}
