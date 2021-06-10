package Transfer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransferEmpleado extends Transfer {

	private String nombre, DNI, direccion, password;
	private int telefono, sueldo, idSucursal;
	private Boolean activo;

	public TransferEmpleado(ResultSet resultado) throws SQLException {
		super(resultado);
	}

	public TransferEmpleado(String[] datos) throws Exception {
		switch (datos.length) {
		case 8:
			try {
				idSucursal = Integer.parseInt(datos[7]);
			} catch (NumberFormatException e) {
				throw new Exception("Formato del sueldo incorrecto, solo numeros");
			}
		case 7:
			if (datos[6].equals("1")) {
				activo = true;
			} else if (datos[6].equals("0")) {
				activo = false;
			} else {
				throw new Exception("Formato del campo activo incorrecto");
			}
		case 6:
			try {
				sueldo = Integer.parseInt(datos[5]);
			} catch (NumberFormatException e) {
				throw new Exception("Formato del sueldo incorrecto, solo numeros");
			}
		case 5:
			try {
				telefono = Integer.parseInt(datos[4]);
			} catch (NumberFormatException e) {
				throw new Exception("Formato del telefono incorrecto, solo numeros");
			}
		case 4:
			direccion = datos[3];
		case 3:
			password = datos[2];
		case 2:
			nombre = datos[1];
		case 1:
			DNI = datos[0];
		}
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getDNI() {
		return this.DNI;
	}

	public String getDir() {
		return this.direccion;
	}

	public int getNumero() {
		return this.telefono;
	}

	public int getActivo() {
		int valor = this.activo ? 1 : 0;
		return valor;
	}

	public String getPassword() {
		return password;
	}

	public int getSueldo() {
		return sueldo;
	}

	public int getIdSucursal() {
		return idSucursal;
	}
}
