package Transfer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransferCliente extends Transfer {
	private String nombre, DNI;
	private int telefono;
	private Boolean activo;

	public TransferCliente(ResultSet resultado) throws SQLException {
		super(resultado);
	}

	public TransferCliente(String[] datos) throws Exception {
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
			nombre = datos[1];
		case 1:
			DNI = datos[0];
		}
	}

	public String getDNI() {
		return DNI;
	}

	public String getNombre() {
		return nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public int isActivo() {
		int valor = this.activo ? 1 : 0;
		return valor;
	}
}
